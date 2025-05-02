package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AccountService accountService = new AccountService();
        List<Account> accounts = new ArrayList<>();


        System.out.println("Welcome to the Banking System!");


        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create a new account");
            System.out.println("2. Select an existing account");
            System.out.println("3. Exit");

            int option = inputHandler.getIntInput("\nChoose an option: ");

            switch (option) {

                case 1 -> {
                    String accountNumber = inputHandler.getStringInput("\nEnter your account number: ");
                    String accountPassword = inputHandler.getStringInput("\nEnter your password: ");

                    accountService.createAccount(accountNumber, accountPassword, accounts);

                }

                case 2 -> {

                    if (!accounts.isEmpty()) {
                        for (Account account : accounts) {
                            System.out.println("Account " + account.getAccountNumber());
                        }
                        String accountNumber = inputHandler.getStringInput("\nEnter account number from the list: ");

                        Account selectedAccount = accountService.selectAccount(accountNumber, accounts);

                        if (selectedAccount != null) {

                            accountService.manageAccount(inputHandler, selectedAccount);

                        } else {
                            System.out.println("Invalid selection");
                        }

                    } else {
                        System.out.println("No accounts yet");
                    }
                }

                case 3 -> {
                    System.out.println("\nThank you for using the Banking System! Goodbye.");
                    inputHandler.close();
                    return;
                }

                default -> System.out.println("\nInvalid option. Please enter a number from 1 to 3.");
            }

        }

    }

}
