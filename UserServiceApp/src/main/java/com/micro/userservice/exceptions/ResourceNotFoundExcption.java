package com.micro.userservice.exceptions;

public class ResourceNotFoundExcption extends RuntimeException {

    public ResourceNotFoundExcption(){
        super("Resource not found on server !!");
    }

    public ResourceNotFoundExcption(String message){
        super(message);
    }
}
