package com.epam.petProject.exception;

public class OwnerFoundException extends Exception {
    private static final long serialVersionUID = 1l;
    public OwnerFoundException(String message){
        super(message);
    }
}
