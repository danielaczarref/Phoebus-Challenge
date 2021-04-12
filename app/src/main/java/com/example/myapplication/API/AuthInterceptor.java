package com.example.myapplication.API;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private final String pubKey;
    private final String privKey;
    private final TimeUtil timeUtil;
    private final AuthGenerator authGenerator = new AuthGenerator();

    AuthInterceptor(String pubKey, String privKey, TimeUtil timeUtil) {
        this.pubKey = pubKey;
        this.privKey = privKey;
        this.timeUtil = timeUtil;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String timestamp = String.valueOf(timeUtil.currentTimeMillis());
        String hash = null;
        try {
            hash = authGenerator.generateHash(timestamp, pubKey, privKey);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        Request request = chain.request();
        HttpUrl httpUrl = request.url()
                .newBuilder()
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("apikey", pubKey)
                .addQueryParameter("hash", hash)
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);
    }
}
