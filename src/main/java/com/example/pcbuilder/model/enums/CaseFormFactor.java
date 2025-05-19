package com.example.pcbuilder.model.enums;

public enum CaseFormFactor implements IStringRepresentable  {
    ATX("ATX"),
    MICRO_ATX("Micro-ATX"),
    MINI_ITX("Mini-ITX");

    private final String value;

    CaseFormFactor(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
