package com.bortnichuk.factory;

public class AlcoDialog implements Dialog {
    @Override
    public Menu createMenu() {
        return new AlcoholicMenu();
    }
}
