package com.bortnichuk.observer;

import org.apache.log4j.Logger;

public class EmailNotificationVisitor implements Visitor {

    private Logger logger = Logger.getLogger(this.getClass());

    private String email;

    EmailNotificationVisitor(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType) {

        logger.trace("Email to " + email + ": In our Burger Pub " + getMessage(eventType));
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
