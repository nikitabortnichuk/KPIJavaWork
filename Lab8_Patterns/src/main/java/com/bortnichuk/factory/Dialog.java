package com.bortnichuk.factory;

public abstract class Dialog {

    public void render(){
        Menu menu = createMenu();
        menu.show();
    }

    public abstract Menu createMenu();

}
