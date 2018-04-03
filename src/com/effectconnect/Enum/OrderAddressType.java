package com.effectconnect.Enum;

public enum OrderAddressType {
    SHIPPING("shipping"),
    BILLING("billing")
    ;

    private final String type;

    OrderAddressType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
