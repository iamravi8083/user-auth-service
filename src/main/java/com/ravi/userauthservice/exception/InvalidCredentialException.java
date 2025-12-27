package com.ravi.userauthservice.exception;

public class InvalidCredentialException extends RuntimeException{
    public InvalidCredentialException(String message ){
        super(message);
    }
}
