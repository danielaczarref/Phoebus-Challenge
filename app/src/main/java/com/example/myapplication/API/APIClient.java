package com.example.myapplication.API;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class APIClient {

    private final APIConfig apiConfig;

    public APIClient(APIConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public <T> T getApi(Class<T> apiREST) {
        if (apiConfig != null) {
            return apiConfig.getRetrofit().create(apiREST);
        }
        return null;
    }


    public <T> T executar(Call<T> call) throws ApiException {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new ApiException("Network error", e);
        }
        if (response.isSuccessful()) {
            return response.body();
        } else {
            parseErr(response);
            return null;
        }
    }

    private void parseErr(Response response) throws ApiException {
        String code = "";
        String desc = "";
        if (response.errorBody() != null) {
            Gson gson = new Gson();
            try {
                String errBody  = response.errorBody().string();
                Error error = gson.fromJson(errBody, Error.class);
                code = error.getCode();
                desc = error.getMsg();
                if (desc == null || "".equals(desc)) {
                    desc = error.getStatus();
                }
            } catch (IOException e) {

            }
        }

        throw new ApiException(response.code(), code, desc, null);
    }
}
