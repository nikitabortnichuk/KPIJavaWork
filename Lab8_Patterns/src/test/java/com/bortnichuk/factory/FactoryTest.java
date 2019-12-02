package com.bortnichuk.factory;

import com.bortnichuk.factory.Dialog;
import com.bortnichuk.factory.Visitor;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryTest {

    @Test
    public void checkAlcoholicMenu(){
        Visitor visitor = new Visitor("James", 23);
        Dialog dialog = visitor.getMenu();
        dialog.render();
        assertTrue(visitor.getAge() >= 18);
    }

    @Test
    public void NonCheckAlcoholicMenu(){
        Visitor visitor = new Visitor("Kyle", 15);
        Dialog dialog = visitor.getMenu();
        dialog.render();
        assertTrue(visitor.getAge() < 18);
    }

}
