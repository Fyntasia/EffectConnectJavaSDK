package com.effectconnect;

import com.effectconnect.Enum.ResponseResult;
import com.effectconnect.Response.ApiResponse;
import com.effectconnect.Response.EffectConnectError;
import com.effectconnect.examples.OrderCreate;

public class Main {
    public static void main(String[] args) {
        try {
            ApiSettings settings = new ApiSettings("yourPublicKey", "yourSecretKey");
            ApiResponse response = new OrderCreate().call(settings);
            if (response.getResponseCode() == 200) {
                if (response.getResponse().getResult() == ResponseResult.SUCCESS) {
                    if (response.getResponse().getContainer().hasProcessId()) {
                        System.out.println("Call successful, check processId `"+response.getResponse().getContainer().getProcessId()+"` for a status update.");
                    } else {
                        System.out.println("Handle success response");
                    }
                } else {
                    for (EffectConnectError error: response.getErrorContainer().getErrors()) {
                        System.out.println("Severity: "+error.getSeverity().toString()+"\nCode: "+error.getCode().toString()+"\nMessage: "+error.getMessage());
                    }
                }
            } else {
                // The api encountered a fatal error.
                System.out.println(response.getRawResponse());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
