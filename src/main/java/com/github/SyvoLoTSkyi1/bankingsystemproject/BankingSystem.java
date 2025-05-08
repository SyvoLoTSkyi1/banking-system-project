package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AccountService accountService = new AccountService();
        List<User> users = new ArrayList<>();
        Map<String, Account> accounts = new HashMap<>();
        
        System.out.println("Welcome to the Banking System!");

        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");

            int choice = inputHandler.getIntInput("\nChoose an option: ");

            switch (choice) {

                case 1 -> {
                    String username = inputHandler.getStringInput("\nEnter your username: ");

                    User newUser = new User(username);
                    System.out.println("\nThe new user with username " + newUser.getUsername() + " was created!");
                    users.add(newUser);
                }

                case 2 -> {
                    if (!users.isEmpty()) {

                        String username = inputHandler.getStringInput("\nEnter your username: ");

                        User selectedUser = null;

                        for (User user : users) {
                            if (user.getUsername().equals(username)) {
                                selectedUser = user;
                                break;
                            }
                        }

                        if (selectedUser != null) {

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

                                    default ->
                                            System.out.println("\nInvalid option. Please enter a number from 1 to 3.");

                                }

                            }

                        } else {
                            System.out.println("Invalid selection");
                        }

                    } else {
                        System.out.println("No users yet");
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
