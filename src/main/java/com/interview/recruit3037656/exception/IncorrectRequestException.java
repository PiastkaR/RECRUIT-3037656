package com.interview.recruit3037656.exception;

public class IncorrectRequestException extends Exception {
    public IncorrectRequestException(Long id) {
        super(String.format("Error while making a request for number's id: '%s' please try 1 or 2.", id));
    }
}
