package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private final String password;
    private double balance;
    private final LocalDateTime creationDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    Account(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 0.0;
        this.creationDate = LocalDateTime.now();

    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getCreationDate() {
        return this.creationDate.format(formatter);
    }

    public boolean checkPassword(String password) {
        return Objects.equals(password, this.password);
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            logTransaction("Deposit", amount);
            return true;
        } else {
            return false;
        }

    }

    public boolean withdrawal(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            logTransaction("Withdrawal", amount);
            return true;
        } else {
            return false;
        }

    }

    private void logTransaction(String operation, double amount) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println("[" + date.format(formatter) + "] " + "Transaction: " + operation + "; Amount: " + amount);
    }

}
