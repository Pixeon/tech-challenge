package com.pixeon.healthcare.usecases.createhealthcareInstitution.exception;

public class CNPJInvalidException extends RuntimeException {

    public CNPJInvalidException() {
        super("CNPJ da instituição é inválido!");
    }
}
