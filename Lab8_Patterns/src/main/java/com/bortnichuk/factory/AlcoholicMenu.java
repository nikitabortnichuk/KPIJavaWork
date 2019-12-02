package com.bortnichuk.factory;

public class AlcoholicMenu implements Menu {
    @Override
    public void show() {
        System.out.println("You are above 18 years old. So now you can choose a beer");
    }
}
