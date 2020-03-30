package com.bortnichuk;

import com.bortnichuk.decorator.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.*;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);
    private static Marker marker = MarkerManager.getMarker("Visitor");

    private static final int NUMBER_OF_VISITORS = 20;

    public static void main(String[] args) {
        Random random = new Random();

        Map<Integer, Burger> burgers = new HashMap<>();
        burgers.put(0, new Burger("Vega Burger", 9));
        burgers.put(1, new Burger("BBQ Burger", 12));
        burgers.put(2, new Burger("Fish Burger", 15));
        burgers.put(3, new Burger("Chicken Burger", 10));
        burgers.put(4, new Burger("Beef Burger", 13));

        List<Ingredient> extras = new ArrayList<>();
        extras.add(new Ingredient("Cheese", 4));
        extras.add(new Ingredient("Onion", 1));
        extras.add(new Ingredient("Bacon", 5));
        extras.add(new Ingredient("Tomato", 1));
        extras.add(new Ingredient("Cucumber", 1));
        extras.add(new Ingredient("Mushrooms", 2));


        for (int i = 0; i < NUMBER_OF_VISITORS; i++) {
            int burgerNumber = random.nextInt(5);
            Order order = getOrder(burgers.get(burgerNumber), random, extras);

            logger.info(marker, "Visitor-{}: Order: {} Price: {}", i, order.getName(), order.getPrice());
        }
    }

    public static Order getOrder(Order burger, Random random, List<Ingredient> extras) {
        Order order = burger;

        if (random.nextBoolean()) {
            Ingredient ingredient = extras.get(random.nextInt(6));
            order = new RegularExtra(ingredient.getName(), ingredient.getPrice(), order);
        }
        if (random.nextBoolean()) {
            Ingredient ingredient = extras.get(random.nextInt(6));
            order = new DoubleExtra(ingredient.getName(), ingredient.getPrice(), order);
        }
        if (random.nextBoolean()) {
            order = new FreeExtra("Onion", 1, order);
        }

        return order;
    }
}
