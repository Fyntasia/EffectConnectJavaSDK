package com.effectconnect;

final public class ApiSettings {
    private String publicKey;
    private String secretKey;

    ApiSettings(String publicKey, String secretKey) throws Exception {
        this.publicKey = publicKey;
        this.secretKey = secretKey;

        if (this.publicKey.length() != 24) {
            throw new Exception("Invalid length for public key.");
        }
        if (this.secretKey.length() != 32) {
            throw new Exception("Invalid length for secret key.");
        }
    }

    final String getPublicKey() {
        return this.publicKey;
    }

    final String getSecretKey() {
        return this.secretKey;
    }
}
