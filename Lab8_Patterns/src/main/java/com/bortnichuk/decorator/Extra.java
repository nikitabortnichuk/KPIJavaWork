package com.bortnichuk.decorator;

public abstract class Extra implements Order{

    Order order;
    double price;
    String name;

    Extra(String name, double price, Order order) {
        this.name = name;
        this.price = price;
        this.order = order;
    }

    @Override
    public String getName() {
        return order.getName() + ", " + this.name;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "order=" + order +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
