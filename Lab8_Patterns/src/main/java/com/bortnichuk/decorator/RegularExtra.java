package com.bortnichuk.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class RegularExtra extends Extra {

    private static Logger logger = LogManager.getLogger(RegularExtra.class);
    private static Marker marker = MarkerManager.getMarker("Extra");

    public RegularExtra(String name, double price, Order order) {
        super(name, price, order);
        logger.debug(marker, "Extra Regular: {} is created", name);
    }

    @Override
    public double getPrice() {
        return this.price + order.getPrice();
    }


}
