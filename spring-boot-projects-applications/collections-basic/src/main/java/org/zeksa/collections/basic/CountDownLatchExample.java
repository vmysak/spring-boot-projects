package org.zeksa.collections.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchExample {

    private static final int threads = 100;

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        List<Future> futures = new ArrayList<>();

        ExecutorService ex = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            futures.add(ex.submit(new CallableExample(latch)));
        }

        latch.countDown();

        for (int i = 0; i < threads; i++) {
            try {
                System.out.println(futures.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ex.shutdown();
    }

    private static class CallableExample implements Callable<String> {

        private CountDownLatch latch;

        public CallableExample(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public String call() throws Exception {
            latch.await();

            int rand = (int) (Math.random() *10000);
            System.out.println("time: "+rand);
            Thread.sleep(rand);

            return String.valueOf(rand);
        }
    }
}
