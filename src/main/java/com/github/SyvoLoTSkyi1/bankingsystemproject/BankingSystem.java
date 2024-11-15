package com.github.SyvoLoTSkyi1.bankingsystemproject;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System");

        Account account = new Account("12345678", 0);

        account.getAccountNumber();
        account.getBalance();

    }
}
