package com.bortnichuk.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Burger implements Order{

    private Logger logger = LogManager.getLogger(Burger.class);
    private static Marker marker = MarkerManager.getMarker("Burger");


    private double price;
    private String name;

    public Burger(String name, double price) {
        this.name = name;
        this.price = price;
        logger.debug(marker,"Burger:{} with price:{} is created", name, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
