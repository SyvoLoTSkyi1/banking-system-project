package com.github.SyvoLoTSkyi1.bankingsystemproject;

public class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void getAccountNumber() {
        System.out.println("Account number: " + this.accountNumber);
    }

    public void getBalance() {
        System.out.println("Account balance: " + this.balance);
    }

}
