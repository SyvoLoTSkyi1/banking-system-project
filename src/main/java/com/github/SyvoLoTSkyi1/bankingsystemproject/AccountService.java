package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.List;

public class AccountService {

    public void createAccount(String accountNumber, String accountPassword, List<Account> accounts) {
        Account newAccount = new Account(accountNumber, accountPassword);
        System.out.println("\nThe new account with account number " + newAccount.getAccountNumber() + " was created!");
        accounts.add(newAccount);
    }

    public Account selectAccount(String accountNumber, List<Account> accounts) {

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;

            }
        }

        return null;

    }

    public void manageAccount(InputHandler inputHandler, Account selectedAccount) {

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

                case 1 -> getAccountInfo(selectedAccount);

                case 2 -> getAccountBalance(selectedAccount);

                case 3 -> {
                    double depositAmount = inputHandler.getDoubleInput("\nEnter deposit amount: ");
                    depositToAccount(selectedAccount, depositAmount);
                }

                case 4 -> {
                    double withdrawalAmount = inputHandler.getDoubleInput("\nEnter withdrawal amount: ");
                    withdrawalFromAccount(selectedAccount, withdrawalAmount);
                }

                case 5 -> accountTransactionHistory(selectedAccount);

                case 6 -> {
                    System.out.println("Back to Main Menu...");
                    return;
                }

                default -> System.out.println("\nInvalid choice. Please enter a number from 1 to 6.");
            }
        }
    }


    public void getAccountInfo(Account account) {
        System.out.println("\nAccount information:");
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Account creation date: " + account.getCreationDate());
    }

    public void getAccountBalance(Account account) {
        System.out.println("\nAccount balance: " + account.getBalance());
    }

    public void depositToAccount(Account account, double depositAmount) {
        if (account.deposit(depositAmount)) {
            System.out.println("Deposit of " + depositAmount + " amount to account was made successfully");
        } else {
            System.out.println("Deposit failed. Deposit amount must be bigger than zero");
        }
    }

    public void withdrawalFromAccount(Account account, double withdrawalAmount) {
        if (account.withdrawal(withdrawalAmount)) {
            System.out.println("Withdrawal of " + withdrawalAmount + " amount from account was made successfully");
        } else {
            System.out.println("Withdrawal failed. Withdrawal amount must be bigger than zero and equals or less than balance");
        }
    }

    public void accountTransactionHistory(Account account) {
        System.out.println("\nTransaction history: ");

        List<Transaction> transactions = account.getTransactionList();
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("No transactions yet");
        }


    }

}
