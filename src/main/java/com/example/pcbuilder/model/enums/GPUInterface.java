package com.example.pcbuilder.model.enums;

public enum GPUInterface {

    PCI_EXPRESS_3_0("PCI Express 3.0"),
    PCI_EXPRESS_4_0("PCI Express 4.0"),
    PCI_EXPRESS_5_0("PCI Express 5.0");

    private final String value;

    GPUInterface(String value) {
        this.value = value;
    }

    public String getValue() {return value;}

    public boolean isCompatibleWith(GPUInterface gpuInterface) {
        return this.ordinal() >= gpuInterface.ordinal();
    }

    public static GPUInterface fromValue(String value) {
        for (GPUInterface gpu : GPUInterface.values()) {
            if (gpu.getValue().equalsIgnoreCase(value)) {
                return gpu;
            }
        }
        throw new IllegalArgumentException("Невідоме значення GPUInterface: " + value);
    }
}
