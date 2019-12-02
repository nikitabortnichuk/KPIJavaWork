package com.bortnichuk.factory;

public interface Dialog {

    default void render(){
        Menu menu = createMenu();
        menu.show();
    }

    Menu createMenu();

}
