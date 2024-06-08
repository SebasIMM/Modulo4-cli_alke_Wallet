package org.example.model;

import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private String currency;
    private double amount;
    private String type;
    private String description;
    private int idAccount;

    // Constructor
    public Transaction(int id, Date date, String currency, double amount, String type, String description, int idAccount) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.idAccount = idAccount;
    }

    // Getters
    public int getId() {
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
    public int getAccountId() {
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

