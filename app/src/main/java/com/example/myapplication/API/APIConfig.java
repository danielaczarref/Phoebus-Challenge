package com.example.myapplication.API;

import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Getter
@Setter
public class APIConfig {
    private static APIConfig singleton;
    private final String pubKey;
    private final String privKey;
    private final boolean debug;
    private final Retrofit retrofit;

    public APIConfig(String pubKey, String privKey, boolean debug, Retrofit retrofit) {
        this.pubKey = pubKey;
        this.privKey = privKey;
        this.debug = debug;
        this.retrofit = retrofit;
    }

    public static APIConfig withBuilder(String pubKey, String privKey) {
        if (singleton == null) {
            singleton = new Builder(pubKey, privKey).build();
        }
        return singleton;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Getter
    @Setter
    public static class Builder {
        private static final String API_URL = "https://gateway.marvel.com/v1/public/";
        private final String privKey;
        private final String pubKey;
        private boolean debug;
        private Retrofit retrofit;
        private String baseUrl = API_URL;
        private TimeUtil timeUtil = new TimeUtil();

        public Builder(String pubKey, String privKey) {
            if (pubKey == null) {
                throw new IllegalArgumentException("publicKey não pode ser nula");
            }

            if (privKey == null) {
                throw new IllegalArgumentException("privateKey não pode ser nula");
            }
            this.pubKey = pubKey;
            this.privKey= privKey;
        }

        public Builder retrofit(Retrofit retrofit) {
            if (retrofit == null) {
                throw new IllegalArgumentException("retrofit não pode ser nulo");
            }
            this.retrofit = retrofit;
            return this;
        }

        public Retrofit buildRetrofit() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor(pubKey, privKey, timeUtil));
            if (debug) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            OkHttpClient okHttpClient = builder.build();
            return new Retrofit.Builder().baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public APIConfig build() {
            if (retrofit == null) {
                retrofit = buildRetrofit();
            }
            return new APIConfig(pubKey, privKey, debug, retrofit);
        }
    }

}
