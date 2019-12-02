package com.bortnichuk.observer;

public class EmailNotificationVisitor implements Visitor {

    private String email;

    public EmailNotificationVisitor(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType) {

        System.out.println("Email to " + email + ": In our Burger Pub " + getMessage(eventType));
    }

    public String getMessage(String eventType){

        if(eventType.equals("discounts")){
            return "BIG DISCOUNTS!!!";
        }
        else if( eventType.equals("new dish")){
            return "NEW DISH HAS BEEN ADDED!!!";
        }
        else
            throw new IllegalArgumentException();

    }
}
