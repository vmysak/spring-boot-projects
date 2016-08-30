package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.BankAccount;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeadLockExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(200);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = ex.submit(new CallableExample("Thread1", latch, a, b, 45));
        Future<Integer> f2 = ex.submit(new CallableExample("Thread2", latch, b, a, 12));

        latch.countDown();

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ex.shutdown();
    }

    private static void transfer(String name, BankAccount a, BankAccount b, int amount) {
        synchronized (a) {
            int rand = (int) (Math.random() * 2000);
            System.out.println(name + " time: " + rand);
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                a.setBalance(a.getBalance() - amount);
                b.setBalance(b.getBalance() + amount);
            }
        }
    }

    private static class CallableExample implements Callable<Integer> {

        private String name;
        private CountDownLatch latch;
        private BankAccount a;
        private BankAccount b;
        private int amount;

        public CallableExample(String name, CountDownLatch latch, BankAccount a, BankAccount b, int amount) {
            this.name = name;
            this.latch = latch;
            this.a = a;
            this.b = b;
            this.amount = amount;
        }

        @Override
        public Integer call() throws Exception {
            latch.await();

            transfer(name, a, b, amount);

            return amount;
        }
    }
}
