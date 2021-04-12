package com.example.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private T response;

    public Response() {

    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public T getResponse() {
        return response;
    }

    public Response(Response response) {
        code = response.getCode();
        status = response.getStatus();
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
