package org.n3r.idworker;

import org.n3r.idworker.strategy.DefaultWorkerIdStrategy;

public class Id {
    private static WorkerIdStrategy workerIdStrategy;
    private static IdWorker idWorker;

    static {
        configure(DefaultWorkerIdStrategy.instance);
    }

    public static synchronized void configure(WorkerIdStrategy custom) {
        if (workerIdStrategy == custom) return;

        if (workerIdStrategy != null) workerIdStrategy.release();
        workerIdStrategy = custom;
        workerIdStrategy.initialize();
        idWorker = new IdWorker(workerIdStrategy.availableWorkerId());
    }

    public static long next() {
        return idWorker.nextId();
    }

    public static long getWorkerId() {
        return idWorker.getWorkerId();
    }
}
