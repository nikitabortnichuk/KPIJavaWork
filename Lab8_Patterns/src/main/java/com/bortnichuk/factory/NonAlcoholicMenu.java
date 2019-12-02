package com.bortnichuk.factory;

public class NonAlcoholicMenu implements Menu{
    @Override
    public void show() {
        System.out.println("You are under 18 years old. So now you can choose juice or soda");
    }
}
