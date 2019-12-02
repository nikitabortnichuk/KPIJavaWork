package com.bortnichuk;

import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Window windowImpl1 = new Window(2, 5, 4, 3, "red");
        Window windowImpl2 = new Window(6, 3, 7, 2, "blue");

        logger.trace(windowImpl1);
        logger.trace(windowImpl2);

        TextWindow textWindow1 = new TextWindow("Happy new year!", "white");
        TextWindow textWindow2 = new TextWindow("Happy birthday!", "black");

        logger.trace(textWindow1.getText());
        logger.trace(textWindow2.getText());

        windowImpl1.changeColor("yellow");
        logger.trace(windowImpl1);


    }

}
