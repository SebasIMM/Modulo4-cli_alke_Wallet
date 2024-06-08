package org.example.model;

public class Currency {
    private String code;
    private String name;
    private double rate;

    // Constructor
    public Currency(String code, String name, double rate) {
        this.code = code;
        this.name = name;
        this.rate = rate;
    }

    // Getters
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public double getRate() {
        return rate;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
