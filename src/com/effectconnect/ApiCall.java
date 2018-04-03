package com.effectconnect;

import com.effectconnect.Abstracts.CallType;
import com.effectconnect.Helper.ECFormatter;
import com.effectconnect.Response.ApiResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

final public class ApiCall {
    private static final String BASE_URL = "https://submit.effectconnect.com/v1";

    private ApiSettings settings;
    private CallType callType;
    private String callTime;

    public ApiCall(ApiSettings settings, CallType callType) {
        this.settings = settings;
        this.callType = callType;
        this.callTime = ECFormatter.formatDate(new Date());
    }

    public ApiResponse call() {
        try {
            URL url = new URL(BASE_URL+callType.getUri());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("KEY", this.settings.getPublicKey());
            connection.setRequestProperty("VERSION", callType.getVersion());
            connection.setRequestProperty("URI", callType.getUri());
            connection.setRequestProperty("RESPONSETYPE", "XML");
            connection.setRequestProperty("RESPONSELANGUAGE", "en");
            connection.setRequestProperty("TIME", this.callTime);
            connection.setRequestProperty("SIGNATURE", this._generateSignature());
            connection.setRequestMethod(this.callType.getMethod());
            connection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(this.callType.getPayload());
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = bufferedReader.readLine()) != null) {
                response.append(output);
            }
            bufferedReader.close();
            return new ApiResponse(connection.getResponseCode(), response.toString());
        } catch (IOException e) {
            return new ApiResponse(0, "");
        }
    }

    private String _generateSignature() {
        Integer size = this.callType.getPayload().length();
        String method = this.callType.getMethod();
        String uri = this.callType.getUri();
        String version = this.callType.getVersion();
        String time = this.callTime;
        String signatureData = size.toString()+method+uri+version+time;
        try {
            SecretKeySpec spec = new SecretKeySpec(this.settings.getSecretKey().getBytes(), "HmacSHA512");
            Mac sha512 = Mac.getInstance("HmacSHA512");
            sha512.init(spec);
            byte[] data = sha512.doFinal(signatureData.getBytes());

            return Base64.getEncoder().encodeToString(data);
        } catch (NoSuchAlgorithmException|InvalidKeyException e) {
            System.out.println("Error in generating signature: "+e.getMessage());
        }
        return "";
    }
}
