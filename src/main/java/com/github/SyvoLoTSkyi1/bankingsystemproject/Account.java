package com.github.SyvoLoTSkyi1.bankingsystemproject;

public class Account {
    private String accountNumber;
    private double balance;

    Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;

    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }

    public void withdrawal(double amount) {
        this.balance -= amount;

    }

}
