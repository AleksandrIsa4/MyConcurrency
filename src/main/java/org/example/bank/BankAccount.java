package org.example.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private Integer balance;

    public final Lock lock;

    public BankAccount(int balance) {
        this.balance = balance;
        this.lock=new ReentrantLock();
    }

    public void deposit(int value) {
        lock.lock();
        try {
            balance += value;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int value) {
        lock.lock();
        try {
            balance -= value;
        } finally {
            lock.unlock();
        }
    }

    public synchronized Integer getBalance() {
        return balance;
    }
}
