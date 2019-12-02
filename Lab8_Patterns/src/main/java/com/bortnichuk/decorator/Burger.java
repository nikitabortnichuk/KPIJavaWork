package com.bortnichuk.decorator;

public class Burger implements Order{

    private double price;
    private String name;

    public Burger(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
