package com.bortnichuk.decorator;

public class FreeExtra extends Extra{

    FreeExtra(String name, double price, Order order) {
        super(name, price, order);
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
