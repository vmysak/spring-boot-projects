package org.zeksa.collections.basic;

import org.zeksa.collections.basic.thread.ThreadWorker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        CountDownLatch latch = new CountDownLatch(1);

        ThreadWorker putter = new ThreadWorker(synchronousQueue, true, latch);
        ThreadWorker getter = new ThreadWorker(synchronousQueue, false, latch);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        putter.setExecutorService(ex);
        getter.setExecutorService(ex);
        Future<Integer> f1 = ex.submit(putter, 1);
        Future<Integer> f2 = ex.submit(getter, 2);

        latch.countDown();
    }
}
