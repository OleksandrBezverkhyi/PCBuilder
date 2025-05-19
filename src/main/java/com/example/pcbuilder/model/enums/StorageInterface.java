package com.example.pcbuilder.model.enums;

public enum StorageInterface implements IStringRepresentable {
    SATA("SATA"),
    NVME("NVMe"),
    M_2("M.2");

    private final String value;

    StorageInterface(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
