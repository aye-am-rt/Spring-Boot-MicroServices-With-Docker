package com.stackroute.exception;

public class MovieAlreadyExistException extends Exception{
    private String message;
    public MovieAlreadyExistException(){}
    public MovieAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
