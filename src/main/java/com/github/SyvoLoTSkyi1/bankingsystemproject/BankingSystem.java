package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;
import java.util.Scanner;

public class BankingSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");

        // New account creation
        System.out.println("\nCreate your account to start!");

        System.out.print("\nEnter your account number: ");
        String accountNumber = scanner.next();
        System.out.print("\nEnter your password: ");
        String accountPassword = scanner.next();

        Account account = new Account(accountNumber, accountPassword);
        System.out.println("\nThe new account with account number " + account.getAccountNumber() + " was created!");

        // Basic loop for users
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Account information");
            System.out.println("2. Check balance");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Transaction history");
            System.out.println("6. Exit\n");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.nextLine(); // Clean wrong input
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    getAccountInfo(account);
                    break;

                case 2:
                    getAccountBalance(account);
                    break;

                case 3:
                    accountDeposit(account);
                    break;

                case 4:
                    accountWithdrawal(account);
                    break;

                case 5:
                    accountTransactionHistory(account);
                    break;

                case 6:
                    System.out.println("\nThank you for using the Banking System! Goodbye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid option. Please enter a number from 1 to 5.");
            }
        }

    }

    private static void getAccountInfo(Account account) {
        System.out.println("\nAccount information:");
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Account creation date: " + account.getCreationDate());
    }

    private static void getAccountBalance(Account account) {
        System.out.println("\nAccount balance: " + account.getBalance());
    }

    private static void accountDeposit(Account account) {
        System.out.print("\nEnter deposit amount: ");

        if (scanner.hasNextDouble()) {
            double depositAmount = scanner.nextDouble();
            scanner.nextLine(); // Clean after nextDouble()

            if (account.deposit(depositAmount)) {
                System.out.println("Deposit of " + depositAmount + " amount to account was made successfully");
            } else {
                System.out.println("Deposit failed. Deposit amount must be bigger than zero");
            }

        } else {
            System.out.println("Error. Enter a number");
            scanner.nextLine(); // Clean wrong input
        }
    }

    private static void accountWithdrawal(Account account) {
        System.out.print("\nEnter withdrawal amount: ");

        if (scanner.hasNextDouble()) {
            double withdrawalAmount = scanner.nextDouble();
            scanner.nextLine(); // Clean after nextDouble()

            if (account.withdrawal(withdrawalAmount)) {
                System.out.println("Withdrawal of " + withdrawalAmount + " amount from account was made successfully");
            } else {
                System.out.println("Withdrawal failed. Withdrawal amount must be bigger than zero and equals or less than balance");
            }

        } else {
            System.out.println("Error. Enter a number");
            scanner.nextLine(); // Clean wrong input
        }
    }

    private static void accountTransactionHistory(Account account) {
        System.out.println("\nTransaction history: ");

        for (String transaction : account.getTransactionList()) {
            System.out.println(transaction);
        }
    }
}
