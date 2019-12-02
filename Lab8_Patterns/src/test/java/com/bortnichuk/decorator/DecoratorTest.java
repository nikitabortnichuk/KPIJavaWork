package com.bortnichuk.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void getFullName(){
        Order burger = getOrder();
        String fullName = "BBQ Burger, Bacon, double Cheese, Onion";
        assertEquals(fullName, burger.getName());
    }

    @Test
    public void getOrderPrice(){
        Order burger = getOrder();
        double price = 20;
        assertEquals(price, burger.getPrice(), 0.001);
    }

    private Order getOrder(){
        Order burger = new Burger("BBQ Burger", 10);
        burger = new RegularExtra("Bacon", 4, burger);
        burger = new DoubleExtra("Cheese", 3, burger);
        burger = new FreeExtra("Onion", 2, burger);
        return burger;
    }

}
