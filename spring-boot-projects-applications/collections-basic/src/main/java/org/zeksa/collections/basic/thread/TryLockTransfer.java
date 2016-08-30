package org.zeksa.collections.basic.thread;

import org.zeksa.collections.basic.model.BankAccountTryLock;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TryLockTransfer implements Callable<Integer> {

    private String name;
    private CountDownLatch latch;
    private BankAccountTryLock a;
    private BankAccountTryLock b;
    private int amount;

    public TryLockTransfer(String name, CountDownLatch latch, BankAccountTryLock a, BankAccountTryLock b, int amount) {
        this.name = name;
        this.latch = latch;
        this.a = a;
        this.b = b;
        this.amount = amount;
    }

    private void transfer(String name, BankAccountTryLock a, BankAccountTryLock b, int amount) {
        int rand = (int) (Math.random() * 2000);
        System.out.println(name + " time: " + rand);
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.setBalance(a.getBalance() - amount);
        b.setBalance(b.getBalance() + amount);
    }

    @Override
    public Integer call() throws Exception {
        latch.await();

        if (a.getLock().tryLock(10, TimeUnit.SECONDS)) {
            try {
                if (b.getLock().tryLock(10, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread " + name + " locked " + a.getName() + " " + b.getName());
                        transfer(name, a, b, amount);
                    } finally {
                        b.getLock().unlock();
                    }
                }
            } finally {
                a.getLock().unlock();
            }
        }

        return amount;
    }
}
