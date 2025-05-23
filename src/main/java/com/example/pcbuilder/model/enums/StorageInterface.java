package com.example.pcbuilder.model.enums;

public enum StorageInterface {
    SATA("SATA"),
    NVME("NVMe"),
    M_2("M.2");

    private final String value;

    StorageInterface(String value) {
        this.value = value;
    }

    public String getValue() {return value;}

    public static StorageInterface fromValue(String value) {
        for (StorageInterface storage : StorageInterface.values()) {
            if (storage.getValue().equalsIgnoreCase(value)) {
                return storage;
            }
        }
        throw new IllegalArgumentException("Невідоме значення StorageInterface: " + value);
    }
}
