package com.bham.pij.assignments.converters;

public class InvalidFormatException extends RuntimeException {

    public InvalidFormatException() {
        super("The value provided is not in a valid format.");
    }

}
