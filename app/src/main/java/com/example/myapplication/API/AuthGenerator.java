package com.example.myapplication.API;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthGenerator {

    String generateHash(String timeStamp, String pubKey, String privKey) throws ApiException {
        try {
            String val = timeStamp + pubKey + privKey;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(val.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i < bytes.length; ++i) {
                stringBuilder.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1,3));
            }
            return stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new ApiException("Não é possível gerar a API key", e);
        }
    }
}
