package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clean wrong input
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public double getDoubleInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clean wrong input
        }

        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
