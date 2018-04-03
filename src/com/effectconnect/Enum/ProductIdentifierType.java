package com.effectconnect.Enum;

public enum ProductIdentifierType {
    ID("ID"),
    EAN("EAN"),
    SKU("SKU")
    ;
    private final String type;

    ProductIdentifierType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
