package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        Map<String, User> users = new HashMap<>();
        Map<String, Account> accounts = new HashMap<>();
        
        System.out.println("Welcome to the Banking System!");

        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");

            int choice = inputHandler.getIntInput("\nChoose an option: ");

            switch (choice) {

                case 1 -> userService.signUpUser(inputHandler, users);

                case 2 -> userService.logInUser(inputHandler, accountService, users, accounts);

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
