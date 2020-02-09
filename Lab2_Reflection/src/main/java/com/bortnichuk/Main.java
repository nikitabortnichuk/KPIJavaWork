package com.bortnichuk;

import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;


public class Main {


    public static void main(String[] args) {
        Window windowImpl1 = new Window(2, 5, 4, 3, "red");
        Window windowImpl2 = new Window(6, 3, 7, 2, "blue");

        System.out.println(windowImpl1);
        System.out.println(windowImpl2);

        TextWindow textWindow1 = new TextWindow("Happy new year!", "white");
        TextWindow textWindow2 = new TextWindow("Happy birthday!", "black");

        windowImpl1.changeColor("yellow");
        System.out.println(windowImpl1);

    }

}
