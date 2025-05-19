package com.example.pcbuilder.model.enums;

public enum PSUInterface implements IStringRepresentable {
    ATX_24_PIN("ATX 24-pin"),
    EPS_8_PIN("EPS 8-pin"),
    PCIE_8_PIN("PCIe 8-pin"),
    SATA_POWER("SATA Power");

    private final String value;

    PSUInterface(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}

