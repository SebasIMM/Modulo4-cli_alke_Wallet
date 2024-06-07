package org.example.model;

import java.util.Date;

public class Transaction {
    private final String id;
    private final Date date;
    private final String currency;
    private final double amount;
    private final String type;
    private final String description;
    private final String idAccount;

    // Constructor
    public Transaction(String id, Date date, String currency, double amount, String type, String description, String idAccount) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.idAccount = idAccount;
    }

    // Getters
    public String getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getCurrency() {
        return currency;
    }
    public double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public String getAccountId() {
        return idAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", idAccount=" + idAccount +
                '}';
    }
}

