package com.effectconnect.Enum;

public enum ErrorSeverity {
    WARNING("Warning"),
    ERROR("Error")
    ;

    private final String severity;

    ErrorSeverity(final String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return severity;
    }
}
