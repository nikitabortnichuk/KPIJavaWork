package com.bortnichuk.decorator;

public class RegularExtra extends Extra {

    RegularExtra(String name, double price, Order order) {
        super(name, price, order);
    }

    @Override
    public double getPrice() {
        return this.price + order.getPrice();
    }


}
