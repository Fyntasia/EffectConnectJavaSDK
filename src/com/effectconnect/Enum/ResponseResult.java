package com.effectconnect.Enum;

public enum ResponseResult {
    SUCCESS("Success"),
    WARNING("Warning"),
    ERROR("Error")
    ;

    private final String result;

    ResponseResult(final String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}
