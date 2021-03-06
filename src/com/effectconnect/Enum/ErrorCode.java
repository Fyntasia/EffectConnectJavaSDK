package com.effectconnect.Enum;

public enum ErrorCode {
    CRITICAL_SYSTEM_FAILURE("E-000"),
    AUTHENTIFICATION_FAILED("E-100"),
    INVALID_SIGNATURE("E-101"),
    INSUFFICIENT_ACCESS("E-102"),
    INVALID_REQUEST("E-200"),
    INVALID_PROPERTY("E-201"),
    INVALID_SHOP_DATA("E-202"),
    INVALID_ROUTE("E-300"),
    SERVERURI_REQUESTURI_FAIL("E-301"),
    EMPTY_SERVER_URI("E-302"),
    EMPTY_REQUEST_URI("E-303"),
    INVALID_ENDPOINT("E-400"),
    MISSING_IDENTIFIER("E-401"),
    INVALID_ACTION("E-402"),
    INVALID_DATA("E-500"),
    INVALID_FIELD("E-501"),
    MISSING_FIELD("E-502"),
    UNEXPECTED_VALUE("E-503"),
    NOT_FOUND("E-600"),
    MISSING_PAYLOAD("E-700"),
    PROCESS_PAYLOAD_ERROR("E-701"),
    PAYLOAD_UPLOAD_ERROR("E-702"),
    INVALID_PAYLOAD("E-703"),
    INVALID_XML("E-704"),
    KEYPAIR_ERROR("E-800"),
    KEYPAIR_EXISTS("E-801"),
    KEYPAIR_GENERATION("E-802"),
    KEYPAIR_INVALID_SINGLE_CHANNEL("E-803"),
    KEYPAIR_PERMISSION_REVOKED("E-804"),
    KEYPAIR_NO_PERMISSION("E-805"),
    KEYPAIR_SINGLE_CHANNEL_REQUIRED("E-806"),
    KEYPAIR_INVALID("E-807"),
    INTERNAL_ERROR("E-900"),
    TRANSFORMER_FAILURE("E-901"),
    OBJECT_EXISTS("E-902"),
    OBJECT_UNVIABLE("E-903"),
    CANNOT_WRITE_FILE("E-904"),
    CANNOT_PROCESS_FILE("E-905"),
    INVALID_LOCALE("W-100"),
    DEPRECATED_ENDPOINT("W-300"),
    DEPRECATED_ENDPOINT_VERSION("W-301"),
    NO_FILE_FOR_PAYLOAD("W-700"),
    OBJECT_EXISTS_WARNING("W-802")
    ;
    private final String errorCode;

    ErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return errorCode;
    }
}
