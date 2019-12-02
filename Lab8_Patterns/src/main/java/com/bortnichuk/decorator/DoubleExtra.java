package com.bortnichuk.decorator;

public class DoubleExtra extends Extra{

    DoubleExtra(String name, double price, Order order) {
        super(name, price, order);
    }

    @Override
    public double getPrice() {
        return order.getPrice() + this.price * 2;
    }

    @Override
    public String getName() {
        return order.getName() + ", double " + this.name;
    }
}
