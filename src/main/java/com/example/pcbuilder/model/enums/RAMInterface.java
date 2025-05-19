package com.example.pcbuilder.model.enums;

public enum RAMInterface implements IStringRepresentable {
    DDR3("DDR3"),
    DDR4("DDR4"),
    DDR5("DDR5");

    private final String value;

    RAMInterface(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
