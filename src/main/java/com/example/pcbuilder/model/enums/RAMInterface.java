package com.example.pcbuilder.model.enums;

public enum RAMInterface {
    DDR3("DDR3"),
    DDR4("DDR4"),
    DDR5("DDR5");

    private final String value;

    RAMInterface(String value) {
        this.value = value;
    }

    public String getValue() {return value;}

    public static RAMInterface fromValue(String value) {
        for (RAMInterface ram : RAMInterface.values()) {
            if (ram.getValue().equalsIgnoreCase(value)) {
                return ram;
            }
        }
        throw new IllegalArgumentException("Невідоме значення RAMInterface: " + value);
    }
}
