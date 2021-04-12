package com.example.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Price {
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private float price;
}
