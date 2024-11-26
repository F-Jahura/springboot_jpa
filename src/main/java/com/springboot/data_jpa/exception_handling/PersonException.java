package com.springboot.data_jpa.exception_handling;

public class PersonException extends RuntimeException {
    public PersonException(String message) {
        super(message);
    }
}
