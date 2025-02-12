package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Arrays;
import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Banking System!");

        // New account creation
        System.out.println("Create your account to start!");
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();

        Account account = new Account(accountNumber, "qwerty");
        System.out.println("The new account with account number " + account.getAccountNumber() + " was created!");

        // Basic loop for users
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    //
                case 2:
                    //
                case 3:
                    //
                case 4:
                    //
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 4.");
            }
        }

    }
}
