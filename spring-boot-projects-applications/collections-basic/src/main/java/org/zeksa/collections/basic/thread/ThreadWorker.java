package org.zeksa.collections.basic.thread;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;

public class ThreadWorker implements Runnable {

    private final SynchronousQueue<Integer> queue;
    private final boolean function;
    private CountDownLatch latch;
    private ExecutorService executorService;

    public ThreadWorker(SynchronousQueue<Integer> queue, boolean function, CountDownLatch latch) {
        this.queue = queue;
        this.function = function;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();

            for (int i = 0; i < 5; i++) {
                if (function) {
                    int value=UUID.randomUUID().hashCode();
                    System.out.println("Put putting "+value);
                    queue.put(value);
                    System.out.println("Put Size: " + queue.size()+"  "+i);
                    if(i==4){
                        executorService.shutdown();
                    }
                } else {
                    System.out.println("Get Size: " + queue.size()+"  "+i);
                    int j = queue.take();
                    System.out.println("Get "+j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }
}
