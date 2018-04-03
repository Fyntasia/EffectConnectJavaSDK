package com.effectconnect.Abstracts;

abstract public class CallType {

    protected String method;

    protected String payload;

    abstract public String getUri();

    abstract public String getVersion();

    final public String getMethod() {
        return this.method;
    }

    final public String getPayload() {
        return this.payload;
    }
}
