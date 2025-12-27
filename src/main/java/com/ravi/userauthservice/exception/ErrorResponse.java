package com.ravi.userauthservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timeStamp;

    public ErrorResponse(String message , int status){
        this.message =  message;
        this.status= status;
        this.timeStamp = LocalDateTime.now();
    }

}
