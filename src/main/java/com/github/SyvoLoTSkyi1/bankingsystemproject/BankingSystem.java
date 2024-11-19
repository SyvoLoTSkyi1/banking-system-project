package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");

        Account account = new Account("12345678");
        System.out.println("The new account with account number " + account.getAccountNumber() + " was created!");

        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());

        account.deposit(1000);
        System.out.println("Deposit of 1000 amount to account was made successfully ");
        System.out.println("Account balance: " + account.getBalance());

        account.withdrawal(300);
        System.out.println("Withdrawal of 300 amount from account was made successfully");
        System.out.println("Account balance: " + account.getBalance());


    }
}
