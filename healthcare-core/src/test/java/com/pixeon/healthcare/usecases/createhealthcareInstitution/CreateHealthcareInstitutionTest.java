package com.pixeon.healthcare.usecases.createhealthcareInstitution;

import com.pixeon.healthcare.models.HealthcareInstitution;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.CNPJEmptyException;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.CNPJInvalidException;
import com.pixeon.healthcare.usecases.createhealthcareInstitution.exception.NameCantEmptyException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CreateHealthcareInstitutionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CreateHealthcareInstitution createHealthcareInstitution;

    @Before
    public void setUp() {
        this.createHealthcareInstitution = new CreateHealthcareInstitution(healthcareInstitution -> {
            healthcareInstitution.setId(1);
            return healthcareInstitution;
        });
    }

    @Test
    public void shouldCreateHealthcare() {
        HealthcareInstitution healthcareInstitution = new HealthcareInstitution.Builder()
                .name("Instituição de Saúde")
                .cnpj("42.094.340/0001-79")
                .build();

        healthcareInstitution = this.createHealthcareInstitution.create(healthcareInstitution);
        assertEquals(1, healthcareInstitution.getId());
        assertEquals("Instituição de Saúde", healthcareInstitution.getName());
        assertEquals("42.094.340/0001-79", healthcareInstitution.getCnpj());
        assertEquals(20.0d, healthcareInstitution.getCoins().doubleValue(), 1);
    }

    @Test
    public void shouldThrowExceptionWhenCreateHealthcareWithNameEmpty() {
        expectedException.expect(NameCantEmptyException.class);
        expectedException.expectMessage("Nome da instituição está em branco.");

        HealthcareInstitution healthcareInstitution = new HealthcareInstitution.Builder()
                .cnpj("42.094.340/0001-79")
                .build();

        this.createHealthcareInstitution.create(healthcareInstitution);
    }

    @Test
    public void shouldThrowExceptionWhenCreateHealthcareWithCNPJEmpty() {
        expectedException.expect(CNPJEmptyException.class);
        expectedException.expectMessage("CNPJ da instituição está em branco!");

        HealthcareInstitution healthcareInstitution = new HealthcareInstitution.Builder()
                .name("Instituição de Saúde")
                .build();

        this.createHealthcareInstitution.create(healthcareInstitution);
    }

    @Test
    public void shouldThrowExceptionWhenCreateHealthcareWithCNPJInvalid() {
        HealthcareInstitution healthcareInstitution = new HealthcareInstitution.Builder()
                .name("Instituição de Saúde")
                .cnpj("99.999.999/9999-99")
                .build();

        CNPJInvalidException exception = assertThrows(CNPJInvalidException.class,
                () -> this.createHealthcareInstitution.create(healthcareInstitution));

        assertEquals("CNPJ da instituição é inválido!", exception.getMessage());
    }

}
