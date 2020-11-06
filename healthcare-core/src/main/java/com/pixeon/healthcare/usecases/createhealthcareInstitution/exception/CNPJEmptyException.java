package com.pixeon.healthcare.usecases.createhealthcareInstitution.exception;

public class CNPJEmptyException extends RuntimeException {

    public CNPJEmptyException(){
        super("CNPJ da instituição está em branco!");
    }
}
