package com.w04m1.jordle;

public class WrongLengthException extends Exception {
    public WrongLengthException(String errorMessage) {
        super(errorMessage);
    }
}
