package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AccountService accountService = new AccountService();
        Map<String, Account> accounts = new HashMap<>();
        
        System.out.println("Welcome to the Banking System!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create a new account");
            System.out.println("2. Select an existing account");
            System.out.println("3. Exit");

            int option = inputHandler.getIntInput("\nChoose an option: ");

            switch (option) {

                case 1 -> accountService.createAccount(inputHandler, accounts);

                case 2 -> accountService.selectAccount(inputHandler, accounts);

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
