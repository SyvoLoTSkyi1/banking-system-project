package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System");

        Account account = new Account("12345678", 1200);

        System.out.println("Account number: " + account.accountNumber);
        System.out.println("Account balance: " + account.balance);


    }
}
