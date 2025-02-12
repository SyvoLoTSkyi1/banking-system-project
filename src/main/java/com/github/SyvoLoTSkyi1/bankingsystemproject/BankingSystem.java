package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");

        Account account = new Account("12345678", "qwerty");
        System.out.println("The new account with account number " + account.getAccountNumber() + " was created!");

        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Account creation date: " + account.getCreationDate());

        double depositAmount = 1000;
        String password1 = "qwerty";
        if (account.checkPassword(password1)) {
            boolean depositResult = account.deposit(depositAmount);
            if (depositResult) {
                System.out.println("Deposit of " + depositAmount + " amount to account was made successfully");
            } else {
                System.out.println("Deposit failed. Deposit amount must be bigger than zero");
            }
            System.out.println("Account balance: " + account.getBalance());
        } else {
            System.out.println("Your password is incorrect");
        }


        double withdrawalAmount = 300;
        String password2 = "qwerty";
        if (account.checkPassword(password2)) {
            boolean withdrawalResult = account.withdrawal(withdrawalAmount);
            if (withdrawalResult) {
                System.out.println("Withdrawal of " + withdrawalAmount + " amount from account was made successfully");
            } else {
                System.out.println("Withdrawal failed. Withdrawal amount must be bigger than zero and equals or less than balance");
            }
            System.out.println("Account balance: " + account.getBalance());
        } else {
            System.out.println("Your password is incorrect");
        }


    }
}
