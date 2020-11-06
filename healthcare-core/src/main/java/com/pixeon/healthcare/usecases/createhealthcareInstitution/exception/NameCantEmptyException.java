package com.pixeon.healthcare.usecases.createhealthcareInstitution.exception;

public class NameCantEmptyException extends RuntimeException {

    public NameCantEmptyException(){
        super("Nome da instituição está em branco.");
    }

}
