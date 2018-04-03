package com.effectconnect.Enum;

public enum FeeType {
    COMMISSION_TYPE("commission"),
    SHIPPING_TYPE("shipping"),
    TRANSACTION_TYPE("transaction")
    ;
    private final String type;

    FeeType(final String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
