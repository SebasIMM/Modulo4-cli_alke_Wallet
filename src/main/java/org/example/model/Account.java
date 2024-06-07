package org.example.model;

public class Account {
    private String id;
    private String name;
    private String age;
    private String passWd;

    public Account(String id, String name, String age, String passWd) {
        this.id = id;
        setName(name);
        this.age = age;
        this.passWd = passWd;
    }


    // Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getPassWd(){ return passWd;}

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        } else {
            System.out.println("Invalid name. It must have a maximum of 20 characters.");
        }
    }

    public void setAge(String age) {
            this.age = age;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    // validators
    private boolean validateName(String name) {
        return name != null && name.length() <= 20;
    }

    @Override
    public String toString() {
        return "id: " + id + " " + "usuario = " + name;
    }
}

