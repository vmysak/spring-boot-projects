package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.BankAccount;
import org.zeksa.collections.basic.model.BankAccountTryLock;
import org.zeksa.collections.basic.thread.TryLockTransfer;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DeadLockTryLockExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        BankAccountTryLock a = new BankAccountTryLock("Acc " + 1, 100);
        BankAccountTryLock b = new BankAccountTryLock("Acc " + 2, 200);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = ex.submit(new TryLockTransfer("Thread1", latch, a, b, 45));
        Future<Integer> f2 = ex.submit(new TryLockTransfer("Thread2", latch, b, a, 12));

        latch.countDown();

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ex.shutdown();
    }
}
