package com.bortnichuk.variant1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class QuadraticEquationImpl implements QuadraticEquation {

    private static Logger logger = LogManager.getLogger(QuadraticEquationImpl.class);

    public double[] getResult(double a, double b, double c){

        double[] results;

        double discriminant = b * b - 4 * a * c;


        if(a == 0){
            throw new IllegalArgumentException("Equation is not quadratic");
        }

        if(discriminant > 0){
            results = new double[2];
            double discriminantRoot = Math.sqrt(discriminant);
            results[0] = (-b + discriminantRoot) / (2 * a);
            results[1] = (-b - discriminantRoot) / (2 * a);
            logger.trace("Equation solved. " +
                    "Result: x1 = " + results[0] + ", " + "x2 = " + results[1]);
        }
        else if(discriminant == 0){
            results = new double[1];
            results[0] = -b / (2 * a);
            logger.trace("Equation solved. " +
                    "Result: x = " + results[0]);
        }
        else {
            results = new double[]{};
            logger.trace("There is no solutions! Discriminant is lower than 0!");
        }

        return results;
    }

}
