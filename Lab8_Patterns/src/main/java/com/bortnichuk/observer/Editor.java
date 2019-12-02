package com.bortnichuk.observer;

public class Editor {

    public EventManager events;

    public Editor(){
        this.events = new EventManager("new dish", "discounts");
    }

    public void makeDiscounts(){
        events.send("discounts");
    }

    public void addNewDishToMenu(){
        events.send("new dish");
    }
}
