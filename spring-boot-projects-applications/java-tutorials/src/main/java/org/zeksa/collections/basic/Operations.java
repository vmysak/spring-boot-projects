package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.BankAccount;

public class Operations {

    public static void main(String[] args) {
        final BankAccount a=new BankAccount(1000);
        final BankAccount b=new BankAccount(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a,b,500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            transfer(b,a,300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void transfer(BankAccount acc1, BankAccount acc2, int amount) throws Exception {
        if(acc1.getBalance() <amount){
            throw new Exception("No funds");
        }

        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
