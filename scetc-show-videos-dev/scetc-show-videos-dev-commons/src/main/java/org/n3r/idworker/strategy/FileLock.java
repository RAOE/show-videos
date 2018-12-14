package org.n3r.idworker.strategy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.OverlappingFileLockException;

/**
 * A file lock a la flock/funlock
 * <p/>
 * The given path will be created and opened if it doesn't exist.
 */
public class FileLock {
    private final File file;
    private FileChannel channel;
    private java.nio.channels.FileLock flock = null;
    Logger logger = LoggerFactory.getLogger(FileLock.class);

    public FileLock(File file) {
        this.file = file;

        try {
            file.createNewFile(); // create the file if it doesn't exist
            channel = new RandomAccessFile(file, "rw").getChannel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Lock the file or throw an exception if the lock is already held
     */
    public void lock() {
        try {
            synchronized (this) {
                logger.trace("Acquiring lock on {}", file.getAbsolutePath());
                flock = channel.lock();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Try to lock the file and return true if the locking succeeds
     */
    public boolean tryLock() {
        synchronized (this) {
            logger.trace("Acquiring lock on {}", file.getAbsolutePath());
            try {
                // weirdly this method will return null if the lock is held by another
                // process, but will throw an exception if the lock is held by this process
                // so we have to handle both cases
                flock = channel.tryLock();
                return flock != null;
            } catch (OverlappingFileLockException e) {
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Unlock the lock if it is held
     */
    public void unlock() {
        synchronized (this) {
            logger.trace("Releasing lock on {}", file.getAbsolutePath());
            if (flock == null) return;
            try {
                flock.release();
            } catch (ClosedChannelException e) {
                // Ignore
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Destroy this lock, closing the associated FileChannel
     */
    public void destroy() {
        synchronized (this) {
            unlock();
            if (!channel.isOpen()) return;

            try {
                channel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @SuppressWarnings("unchecked")
    public <T> T readObject() {
        try {
            InputStream is = Channels.newInputStream(channel);
            ObjectInputStream objectReader = new ObjectInputStream(is);
            return (T) objectReader.readObject();
        } catch (EOFException e) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public synchronized boolean writeObject(Object object) {
        if (!channel.isOpen()) return false;

        try {
            channel.position(0);
            OutputStream out = Channels.newOutputStream(channel);
            ObjectOutputStream objectOutput = new ObjectOutputStream(out);
            objectOutput.writeObject(object);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
