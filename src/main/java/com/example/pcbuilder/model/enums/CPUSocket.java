package com.example.pcbuilder.model.enums;

public enum CPUSocket{
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

    public String getValue() {return value;}

    public static CPUSocket fromValue(String value) {
        for (CPUSocket socket : CPUSocket.values()) {
            if (socket.getValue().equalsIgnoreCase(value)) {
                return socket;
            }
        }
        throw new IllegalArgumentException("Невідоме значення сокета: " + value);
    }

}