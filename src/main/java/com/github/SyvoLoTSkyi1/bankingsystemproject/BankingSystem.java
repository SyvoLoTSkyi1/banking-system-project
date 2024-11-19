package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");

        Account account = new Account("12345678");
        System.out.println("The new account with account number " + account.getAccountNumber() + " was created!");

        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());

        int depositAmount = 1000;
        boolean depositResult = account.deposit(depositAmount);
        if (depositResult) {
            System.out.println("Deposit of " + depositAmount + " amount to account was made successfully");
        } else {
            System.out.println("Deposit failed. Deposit amount must be bigger than zero");
        }
        System.out.println("Account balance: " + account.getBalance());

        int withdrawalAmount = 300;
        boolean withdrawalResult = account.withdrawal(withdrawalAmount);
        if (withdrawalResult) {
            System.out.println("Withdrawal of " + withdrawalAmount + " amount to account was made successfully");
        } else {
            System.out.println("Withdrawal failed. Withdrawal amount must be bigger than zero and equals or less than balance");
        }
        System.out.println("Account balance: " + account.getBalance());


    }
}
