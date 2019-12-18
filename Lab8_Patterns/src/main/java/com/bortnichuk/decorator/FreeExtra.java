package com.bortnichuk.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class FreeExtra extends Extra{

    private Logger logger = LogManager.getLogger(FreeExtra.class);
    private static Marker marker = MarkerManager.getMarker("Extra");



    public FreeExtra(String name, double price, Order order) {
        super(name, price, order);
        logger.debug(marker, "Extra Free: {} is created", name);
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
