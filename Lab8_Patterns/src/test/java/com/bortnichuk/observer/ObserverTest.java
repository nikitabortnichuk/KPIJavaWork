package com.bortnichuk.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObserverTest {


    @Test
    public void checkSubscribersAdded(){

        Editor editor = getEditor();

        int subscribers = editor.events.getVisitors().get("discounts").size();

        assertEquals(2, subscribers);
    }

    @Test
    public void checkMessages(){
        Editor editor = getEditor();

        editor.addNewDishToMenu();
        editor.makeDiscounts();
    }


    private Editor getEditor(){
        Editor editor = new Editor();
        editor.events.subscribe("new dish", new EmailNotificationVisitor("nikita@kpi.ua"));
        editor.events.subscribe("discounts", new EmailNotificationVisitor("nikita@kpi.ua"));
        editor.events.subscribe("new dish", new EmailNotificationVisitor("mandarinka@gmail.com"));
        editor.events.subscribe("discounts", new EmailNotificationVisitor("mandarinka@gmail.com"));

        return editor;
    }


}
