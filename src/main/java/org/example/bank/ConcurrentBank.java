package org.example.bank;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccount createAccount(int value) {
        BankAccount bankAccount = new BankAccount(value);
        bankAccountList.add(bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount account1, BankAccount account2, int value) {
        account1.lock.lock();
        account2.lock.lock();
        try {
            account1.withdraw(value);
            account2.deposit(value);
        } finally {
            account1.lock.unlock();
            account2.lock.unlock();
        }
    }

    public Integer getTotalBalance() {
        return bankAccountList.stream().mapToInt(BankAccount::getBalance).sum();
    }

}
