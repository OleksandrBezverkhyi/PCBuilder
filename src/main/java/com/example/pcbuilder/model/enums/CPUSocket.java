package com.example.pcbuilder.model.enums;

public enum CPUSocket implements IStringRepresentable {
    LGA1151("LGA 1151"),
    LGA1200("LGA 1200"),
    LGA1700("LGA 1700"),
    AM4("AM4"),
    AM5("AM5"),
    TR4("TR4"),
    sTRX4("sTRX4");

    private final String value;

    CPUSocket(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}