package com.bortnichuk.factory;

public class NonAlcoDialog implements Dialog {
    @Override
    public Menu createMenu() {
        return new NonAlcoholicMenu();
    }
}
