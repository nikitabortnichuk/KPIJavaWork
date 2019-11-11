package com.bortnichuk.variant1;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int c = 5;

        QuadraticEquation quadraticEquation = new QuadraticEquationImpl();

        try {
            quadraticEquation.getResult(a, b, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
