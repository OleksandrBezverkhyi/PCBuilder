package com.example.pcbuilder.model.enums;

public enum GPUInterface implements IStringRepresentable {

    PCI_EXPRESS_3_0("PCI Express 3.0"),
    PCI_EXPRESS_4_0("PCI Express 4.0"),
    PCI_EXPRESS_5_0("PCI Express 5.0");

    private final String value;

    GPUInterface(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
