package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.BankAccountTryLock;
import org.zeksa.collections.basic.thread.TryLockTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsServiceExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
        List<BankAccountTryLock> accounts = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(1);
        int accsCount=4;

        for (int i = 0; i < accsCount; i++) {
            accounts.add(new BankAccountTryLock("Account " + i, 400));
        }

        for (int i = 0; i < 256; i++) {
            int rand1 = (int) (Math.random() * accsCount);
            int rand2 = (int) (Math.random() * accsCount);
            int rand3 = (int) (Math.random() * 50);

            service.submit(new TryLockTransfer("Thread " + i, latch, accounts.get(rand1), accounts.get(rand2), rand3));
        }

        latch.countDown();

        service.shutdown();
    }
}
