package com.epam.petProject.exception;

public class PetNotFoundException extends Exception {
    private static final long serialVersionUID = 1l;
    public PetNotFoundException(String message){
        super(message);
    }
}
