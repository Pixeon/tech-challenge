package com.pixeon.healthcare.models;

import java.math.BigDecimal;

public class HealthcareInstitution {

    private int id;
    private String name;
    private String cnpj;
    private BigDecimal coins;

    public HealthcareInstitution(int id, String name, String cnpj, BigDecimal coins) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.coins = coins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getCoins() {
        return coins;
    }

    public void setCoins(BigDecimal coins) {
        this.coins = coins;
    }

    public static class Builder {
        private int id;
        private String name;
        private String cnpj;
        private BigDecimal coins;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder coins(BigDecimal coins) {
            this.coins = coins;
            return this;
        }

        public HealthcareInstitution build() {
            return new HealthcareInstitution(id, name, cnpj, coins);
        }
    }
}
