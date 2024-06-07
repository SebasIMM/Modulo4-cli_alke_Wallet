package org.example.model;

public class Account {
    private int id;
    private String name;
    private int age;

    public Account(int id, String name, int age) {
        this.id = id;
        setName(name);
        setAge(age);
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
        if (validateAge(age)) {
            this.age = age;
        } else {
            System.out.println("Invalid age. It must be greater than 17 and equal to or less than 100.");
        }
    }

    // validators
    private boolean validateAge(int age) {
        return age >= 18 && age <= 100;
    }

    private boolean validateName(String name) {
        return name != null && name.length() <= 20;
    }

    @Override
    public String toString() {
        return "usuario = " + name ;
    }
}

