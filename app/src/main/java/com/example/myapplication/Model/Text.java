package com.example.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Text {
    @SerializedName("typeText")
    private String typeText;
    @SerializedName("languageText")
    private String languageText;
    @SerializedName("text")
    private String text;
}
