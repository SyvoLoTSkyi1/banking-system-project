package com.github.SyvoLoTSkyi1.bankingsystemproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String operation;
    private final double amount;
    private final LocalDateTime timestamp;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(String operation, double amount) {
        this.operation = operation;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getOperation() {
        return this.operation;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp.format(formatter) + "] | Transaction: " + operation + " - Amount: " + amount;
    }

}
