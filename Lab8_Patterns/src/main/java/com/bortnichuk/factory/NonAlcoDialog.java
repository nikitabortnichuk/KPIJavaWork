package com.bortnichuk.factory;

public class NonAlcoDialog extends Dialog {
    @Override
    public Menu createMenu() {
        return new NonAlcoholicMenu();
    }
}
