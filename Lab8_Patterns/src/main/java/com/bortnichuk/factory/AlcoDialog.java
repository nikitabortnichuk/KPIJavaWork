package com.bortnichuk.factory;

public class AlcoDialog extends Dialog {
    @Override
    public Menu createMenu() {
        return new AlcoholicMenu();
    }
}
