package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.List;
import java.util.Map;

public class UserService {
    AccountService accountService = new AccountService();

    public void signUpUser(InputHandler inputHandler, Map<String, User> users) {
        String username = inputHandler.getStringInput("\nEnter your username: ");

        User newUser = new User(username);
        System.out.println("\nThe new user with username " + newUser.getUsername() + " was created!");
        users.put(username, newUser);
    }

    public void logInUser(InputHandler inputHandler, AccountService accountService, Map<String, User> users, Map<String, Account> accounts) {

        if (!users.isEmpty()) {

            String username = inputHandler.getStringInput("\nEnter your username: ");

            User selectedUser = users.get(username);

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

}
