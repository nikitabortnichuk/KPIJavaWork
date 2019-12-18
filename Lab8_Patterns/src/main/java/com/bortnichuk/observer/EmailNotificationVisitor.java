package com.bortnichuk.observer;

public class EmailNotificationVisitor implements Visitor {

    private String email;

    EmailNotificationVisitor(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType) {

        System.out.printf("Email to %s: In our Burger Pub %s", email, getMessage(eventType));
    }

    String getMessage(String eventType){

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
