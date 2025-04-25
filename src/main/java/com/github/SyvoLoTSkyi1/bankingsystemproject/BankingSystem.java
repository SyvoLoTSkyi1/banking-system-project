package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AccountService accountService = new AccountService();
        List<Account> accounts = new ArrayList<>();

        System.out.println("Welcome to the Banking System!");

        outerLoop:
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

                    Account newAccount = new Account(accountNumber, accountPassword);
                    System.out.println("\nThe new account with account number " + newAccount.getAccountNumber() + " was created!");
                    accounts.add(newAccount);
                }

                case 2 -> {

                    if (!accounts.isEmpty()) {
                        for (Account account : accounts) {
                            System.out.println("Account " + account.getAccountNumber());
                        }
                        String accountNumber = inputHandler.getStringInput("\nEnter account number from the list: ");

                        Account selectedAccount = null;

                        for (Account account : accounts) {
                            if (account.getAccountNumber().equals(accountNumber)) {
                                selectedAccount = account;
                                break;
                            }
                        }

                        if (selectedAccount != null) {

                            while (true) {
                                System.out.println("\nMenu:");
                                System.out.println("1. Account information");
                                System.out.println("2. Check balance");
                                System.out.println("3. Deposit money");
                                System.out.println("4. Withdraw money");
                                System.out.println("5. Transaction history");
                                System.out.println("6. Go back\n");

                                int choice = inputHandler.getIntInput("\nYour choice: ");

                                switch (choice) {

                                    case 1 -> accountService.getAccountInfo(selectedAccount);

                                    case 2 -> accountService.getAccountBalance(selectedAccount);

                                    case 3 -> {
                                        double depositAmount = inputHandler.getDoubleInput("\nEnter deposit amount: ");
                                        accountService.depositToAccount(selectedAccount, depositAmount);
                                    }

                                    case 4 -> {
                                        double withdrawalAmount = inputHandler.getDoubleInput("\nEnter withdrawal amount: ");
                                        accountService.withdrawalFromAccount(selectedAccount, withdrawalAmount);
                                    }

                                    case 5 -> accountService.accountTransactionHistory(selectedAccount);

                                    case 6 -> {
                                        System.out.println("Back to Main Menu...");
                                        continue outerLoop;
                                    }

                                    default -> System.out.println("\nInvalid choice. Please enter a number from 1 to 6.");
                                }
                            }

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
