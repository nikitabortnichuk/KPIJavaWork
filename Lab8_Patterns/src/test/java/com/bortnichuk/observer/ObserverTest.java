package com.bortnichuk.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObserverTest {


    @Test
    public void checkSubscribersAdded(){

        Editor editor = getEditor();

        int subscribers = editor.getEvents().getVisitors().get("discounts").size();

        assertEquals(2, subscribers);
    }

    @Test
    public void checkMessages(){
        Editor editor = getEditor();

        editor.addNewDishToMenu();
        editor.makeDiscounts();
        EmailNotificationVisitor visitor = (EmailNotificationVisitor) editor.getEvents().getVisitors().get("discounts").get(0);
        String actualMessage = visitor.getMessage("discounts");
        assertEquals("BIG DISCOUNTS!!!", actualMessage);
    }


    private Editor getEditor(){
        Editor editor = new Editor();
        editor.getEvents().subscribe("new dish", new EmailNotificationVisitor("nikita@kpi.ua"));
        editor.getEvents().subscribe("discounts", new EmailNotificationVisitor("nikita@kpi.ua"));
        editor.getEvents().subscribe("new dish", new EmailNotificationVisitor("mandarinka@gmail.com"));
        editor.getEvents().subscribe("discounts", new EmailNotificationVisitor("mandarinka@gmail.com"));

        return editor;
    }


}
