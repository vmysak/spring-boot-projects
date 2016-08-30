package org.zeksa.collections.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizedVSCopyOnWriteList {

    public static void main(String[] args) {
        int capacity=100000;
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        fillList(synchronizedList, capacity);
        fillList(copyOnWriteList, capacity);

        System.out.printf("\nsynchronizedList\n");
        checkList(synchronizedList,capacity);
        System.out.printf("\ncopyOnWriteList\n");
        checkList(copyOnWriteList,capacity);
    }


    private static void fillList(List list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }

    private static void checkList(List list, int capacity) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0, capacity/2, list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(capacity/2, capacity, list, latch));

        latch.countDown();
        try {
            System.out.println(f1.get() / 1000);
            System.out.println(f2.get() / 1000);
            ex.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ListRunner implements Callable<Long> {

        private int from;
        private int to;
        private List list;
        private CountDownLatch latch;

        public ListRunner(int from, int to, List list, CountDownLatch latch) {
            this.from = from;
            this.to = to;
            this.list = list;
            this.latch = latch;
        }

        @Override
        public Long call() throws Exception {
            latch.await();

            long startTime=System.nanoTime();
            for(int i=from;i<to;i++){
                list.get(i);
            }

            return System.nanoTime()-startTime;
        }
    }
}
