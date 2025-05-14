package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class User {
    private final String username;
    private final Map<String, Account> accounts;
    private final LocalDateTime creationDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public User(String username) {
        this.username = username;
        this.accounts = new HashMap<>();
        this.creationDate = LocalDateTime.now();
    }

    public String getUsername() {
        return this.username;
    }

    public Map<String, Account> getAccounts() {
        return new HashMap<>(this.accounts);
    }

    public String getCreationDate() {
        return this.creationDate.format(formatter);
    }

    public void addAccount(String accountNumber, Account account) {
        accounts.put(accountNumber, account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

}
