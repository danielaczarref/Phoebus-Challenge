package com.example.myapplication.API;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Error {
    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private String status;
    @SerializedName("msg")
    private String msg;

    public String getCode(){
        return code;
    }

    public String getStatus(){
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
