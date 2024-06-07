package org.example.model;

public class Account {
    private int id;
    private String name;
    private int age;
    private String passWd;
    private double balance;

    public Account(int id, String name, int age, String passWd, double balance) {
        this.id = id;
        setName(name);
        this.age = age;
        this.passWd = passWd;
        this.balance = balance;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPassWd(){ return passWd;}
    public double getBalance() {
        return balance;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        } else {
            System.out.println("Invalid name. It must have a maximum of 20 characters.");
        }
    }
    public void setAge(int age) {
            this.age = age;
    }
    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // validators
    private boolean validateName(String name) {
        return name != null && name.length() <= 20;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", passWd='" + passWd + '\'' +
                ", balance=" + balance +
                '}';
    }
}

