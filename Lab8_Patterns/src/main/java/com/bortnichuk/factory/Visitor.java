package com.bortnichuk.factory;

public class Visitor {

    private String name;
    private int age;

    public Visitor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Dialog getMenu(){
        Dialog dialog;

        if(age < 18)
            dialog = new NonAlcoDialog();
        else
            dialog = new AlcoDialog();

        return dialog;
    }

}
