package com.bortnichuk.variant1;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuadraticEquationImplTest {

    private QuadraticEquation quadraticEquation = new QuadraticEquationImpl();

    @Test
    public void checkResultWithTwoSolutions() {
        double a = 1, b = 5, c = 4;

        double discriminantRoot = Math.sqrt(b * b - 4 * a * c);

        double x1 = (-b + discriminantRoot) / (2 * a);
        double x2 = (-b - discriminantRoot) / (2 * a);

        double[] expected = new double[]{x1, x2};

        double[] result = new double[0];

        try {
            result = quadraticEquation.getResult(a, b, c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expected, result, 0.0);
    }

    @Test
    public void checkResultWithOneSolution() {
        double a = 1, b = -4, c = 4;

        double x1 = -b / (2 * a);

        double[] expected = new double[]{x1};

        double[] result = new double[0];
        try {
            result = quadraticEquation.getResult(a, b, c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expected, result, 0.0);
    }

    @Test
    public void checkResultWithNegativeDiscriminant() {
        double a = 1, b = -2, c = 4;

        double[] expected = new double[]{};

        double[] result = new double[0];
        try {
            result = quadraticEquation.getResult(a, b, c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expected, result, 0.0);
    }

    @Test(expected = Exception.class)
    public void checkException() throws Exception {
        double a = 0, b = 5, c = 4;

        double[] result = quadraticEquation.getResult(a, b, c);

    }

}