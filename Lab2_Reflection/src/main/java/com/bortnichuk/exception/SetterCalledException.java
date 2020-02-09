package com.bortnichuk.exception;

public class SetterCalledException extends RuntimeException{

    private static final String MESSAGE = "Can not set a value!";

    public SetterCalledException(String message) {
        System.out.println(MESSAGE + message);
    }

    public SetterCalledException() {
        System.out.println(MESSAGE);
    }

}
