package com.example.pcbuilder.model.enums;

public enum CaseFormFactor {
    ATX("ATX"),
    MICRO_ATX("Micro-ATX"),
    MINI_ITX("Mini-ITX");

    private final String value;

    CaseFormFactor(String value) {
        this.value = value;
    }

    public String getValue() {return value;}

    public boolean fits(CaseFormFactor boardFormFactor) {
        return switch (this) {
            case ATX -> true; // вміщує все
            case MICRO_ATX -> boardFormFactor != CaseFormFactor.ATX; // Micro-ATX або менше
            case MINI_ITX -> boardFormFactor == CaseFormFactor.MINI_ITX; // лише Mini-ITX
        };
    }

    public static CaseFormFactor fromValue(String value) {
        for (CaseFormFactor form : CaseFormFactor.values()) {
            if (form.getValue().equalsIgnoreCase(value)) {
                return form;
            }
        }
        throw new IllegalArgumentException("Невідоме значення CaseFormFactor: " + value);
    }
}
