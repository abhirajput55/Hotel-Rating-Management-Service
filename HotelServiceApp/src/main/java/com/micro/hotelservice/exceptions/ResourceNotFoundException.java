package com.micro.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Ressource not found on server with the given id !!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
