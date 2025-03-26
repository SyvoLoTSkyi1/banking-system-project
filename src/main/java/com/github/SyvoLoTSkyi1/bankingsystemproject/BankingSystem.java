package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AccountService accountService = new AccountService();

        System.out.println("Welcome to the Banking System!");

        // New account creation
        System.out.println("\nCreate your account to start!");
        String accountNumber = inputHandler.getStringInput("\nEnter your account number: ");
        String accountPassword = inputHandler.getStringInput("\nEnter your password: ");

        Account account = new Account(accountNumber, accountPassword);
        System.out.println("\nThe new account with account number " + account.getAccountNumber() + " was created!");

        // Basic loop for users
        while (true) {
//            System.out.println("\nChoose an option:");
            System.out.println("\nMenu:");
            System.out.println("1. Account information");
            System.out.println("2. Check balance");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Transaction history");
            System.out.println("6. Exit\n");

            int option = inputHandler.getIntInput("\nChoose an option: ");

            switch (option) {

                case 1 -> accountService.getAccountInfo(account);

                case 2 -> accountService.getAccountBalance(account);

                case 3 -> {
                    double depositAmount = inputHandler.getDoubleInput("\nEnter deposit amount: ");
                    accountService.depositToAccount(account, depositAmount);
                }

                case 4 -> {
                    double withdrawalAmount = inputHandler.getDoubleInput("\nEnter withdrawal amount: ");
                    accountService.withdrawalFromAccount(account, withdrawalAmount);
                }

                case 5 -> accountService.accountTransactionHistory(account);

                case 6 -> {
                    System.out.println("\nThank you for using the Banking System! Goodbye.");
                    inputHandler.close();
                    return;
                }

                default -> System.out.println("\nInvalid option. Please enter a number from 1 to 6.");
            }
        }

    }

}
