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

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }


    }

    public boolean withdrawal(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }

    }

}
