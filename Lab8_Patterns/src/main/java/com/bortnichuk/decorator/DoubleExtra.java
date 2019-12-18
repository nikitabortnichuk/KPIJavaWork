package com.bortnichuk.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class DoubleExtra extends Extra{

    private Logger logger = LogManager.getLogger(DoubleExtra.class);
    private static Marker marker = MarkerManager.getMarker("Extra");


    public DoubleExtra(String name, double price, Order order) {
        super(name, price, order);
        logger.debug(marker, "Extra Double: {} is created", name);
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
