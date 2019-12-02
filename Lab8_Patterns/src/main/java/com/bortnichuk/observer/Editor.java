package com.bortnichuk.observer;

public class Editor {

    private EventManager events;

    Editor(){
        this.events = new EventManager("new dish", "discounts");
    }

    void makeDiscounts(){
        events.send("discounts");
    }

    void addNewDishToMenu(){
        events.send("new dish");
    }

    public EventManager getEvents() {
        return events;
    }
}
