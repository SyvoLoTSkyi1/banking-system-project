package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.util.List;

public class AccountService {

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
