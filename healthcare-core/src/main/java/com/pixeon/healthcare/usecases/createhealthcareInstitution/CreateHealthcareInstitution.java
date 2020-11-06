package com.pixeon.healthcare.usecases.createhealthcareInstitution;

import com.pixeon.healthcare.models.HealthcareInstitution;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.CNPJEmptyException;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.CNPJInvalidException;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.NameCantEmptyException;

import java.math.BigDecimal;

public class CreateHealthcareInstitution {

    private HealthcareInstitutionService healthcareInstitutionService;

    public CreateHealthcareInstitution(HealthcareInstitutionService healthcareInstitutionService){
        this.healthcareInstitutionService = healthcareInstitutionService;
    }

    public HealthcareInstitution create(HealthcareInstitution healthcareInstitution) {
        validName(healthcareInstitution);
        validCNPJ(healthcareInstitution);

        healthcareInstitution.setCoins(new BigDecimal(20.0));
        return healthcareInstitutionService.save(healthcareInstitution);
    }

    private void validName(HealthcareInstitution healthcareInstitution){
        if (healthcareInstitution.getName() == null || healthcareInstitution.getName().isEmpty()){
            throw new NameCantEmptyException();
        }
    }

    private void validCNPJ(HealthcareInstitution healthcareInstitution){
        if (healthcareInstitution.getCnpj() == null || healthcareInstitution.getCnpj().isEmpty()){
            throw new CNPJEmptyException();
        }

        if (!ValidateCNPJ.isCNPJ(healthcareInstitution.getCnpj())){
            throw new CNPJInvalidException();
        }
    }
}
