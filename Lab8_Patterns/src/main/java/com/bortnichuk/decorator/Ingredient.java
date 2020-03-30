package com.bortnichuk.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Ingredient {

    private static Logger logger = LogManager.getLogger(Ingredient.class);
    private static Marker marker = MarkerManager.getMarker("Ingredient");

    private String name;
    private double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
        logger.debug(marker, "Ingredient:{} with price:{} is created", name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
