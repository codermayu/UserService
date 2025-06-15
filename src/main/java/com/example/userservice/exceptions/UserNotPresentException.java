package com.example.userservice.exceptions;

public class UserNotPresentException extends RuntimeException {

    public UserNotPresentException(String message) {

        super(message);
    }
}
