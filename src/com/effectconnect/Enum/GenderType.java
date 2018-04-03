package com.effectconnect.Enum;

public enum GenderType {
    MALE("m"),
    FEMALE("f")
    ;

    private final String gender;

    GenderType(final String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
