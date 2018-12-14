package org.n3r.idworker.strategy;

import org.n3r.idworker.Id;
import org.n3r.idworker.RandomCodeStrategy;
import org.n3r.idworker.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;

public class DefaultRandomCodeStrategy implements RandomCodeStrategy {
    public static final int MAX_BITS = 1000000;

    Logger log = LoggerFactory.getLogger(DefaultRandomCodeStrategy.class);

    File idWorkerHome = Utils.createIdWorkerHome();
    volatile FileLock fileLock;
    BitSet codesFilter;

    int prefixIndex = -1;
    File codePrefixIndex;

    int minRandomSize = 6;
    int maxRandomSize = 6;

    public DefaultRandomCodeStrategy() {
        destroyFileLockWhenShutdown();
    }

    @Override
    public void init() {
        release();

        while (++prefixIndex < 1000) {
            if (tryUsePrefix()) return;
        }

        throw new RuntimeException("all prefixes are used up, the world maybe ends!");
    }

    public DefaultRandomCodeStrategy setMinRandomSize(int minRandomSize) {
        this.minRandomSize = minRandomSize;
        return this;
    }

    public DefaultRandomCodeStrategy setMaxRandomSize(int maxRandomSize) {
        this.maxRandomSize = maxRandomSize;
        return this;
    }

    protected boolean tryUsePrefix() {
        codePrefixIndex = new File(idWorkerHome, Id.getWorkerId() + ".code.prefix." + prefixIndex);

        if (!createPrefixIndexFile()) return false;
        if (!createFileLock()) return false;
        if (!createBloomFilter()) return false;

        log.info("get available prefix index file {}", codePrefixIndex);

        return true;
    }

    private boolean createFileLock() {
        if (fileLock != null) fileLock.destroy();
        fileLock = new FileLock(codePrefixIndex);
        return fileLock.tryLock();
    }

    private boolean createBloomFilter() {
        codesFilter = fileLock.readObject();
        if (codesFilter == null) {
            log.info("create new bloom filter");
            codesFilter = new BitSet(MAX_BITS); // 2^24
        } else {
            int size = codesFilter.cardinality();
            if (size >= MAX_BITS) {
                log.warn("bloom filter with prefix file {} is already full", codePrefixIndex);
                return false;
            }
            log.info("recreate bloom filter with cardinality {}", size);
        }

        return true;
    }

    private void destroyFileLockWhenShutdown() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                release();
            }
        });
    }

    private boolean createPrefixIndexFile() {
        try {
            codePrefixIndex.createNewFile();
            return codePrefixIndex.exists();
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("create file {} error {}", codePrefixIndex, e.getMessage());
        }
        return false;
    }

    @Override
    public int prefix() {
        return prefixIndex;
    }

    static final int CACHE_CODES_NUM = 1000;

    SecureRandom secureRandom = new SecureRandom();
    Queue<Integer> availableCodes = new ArrayDeque<Integer>(CACHE_CODES_NUM);

    @Override
    public int next() {
        if (availableCodes.isEmpty()) generate();

        return availableCodes.poll();
    }

    @Override
    public synchronized void release() {
        if (fileLock != null) {
            fileLock.writeObject(codesFilter);
            fileLock.destroy();
            fileLock = null;
        }
    }

    private void generate() {
        for (int i = 0; i < CACHE_CODES_NUM; ++i)
            availableCodes.add(generateOne());

        fileLock.writeObject(codesFilter);
    }

    private int generateOne() {
        while (true) {
            int code = secureRandom.nextInt(max(maxRandomSize));
            boolean existed = contains(code);

            code = !existed ? add(code) : tryFindAvailableCode(code);
            if (code >= 0) return code;

            init();
        }
    }

    private int tryFindAvailableCode(int code) {
        int next = codesFilter.nextClearBit(code);
        if (next != -1 && next < max(maxRandomSize)) return add(next);

        next = codesFilter.previousClearBit(code);
        if (next != -1) return add(next);

        return -1;
    }

    private int add(int code) {
        codesFilter.set(code);
        return code;
    }

    private boolean contains(int code) {
        return codesFilter.get(code);
    }


    private int max(int size) {
        switch (size) {
            case 1: // fall through
            case 2: // fall through
            case 3: // fall through
            case 4:
                return 10000;
            case 5:
                return 100000;
            case 6:
                return 1000000;
            case 7:
                return 10000000;
            case 8:
                return 100000000;
            case 9:
                return 1000000000;
            default:
                return Integer.MAX_VALUE;
        }
    }
}
