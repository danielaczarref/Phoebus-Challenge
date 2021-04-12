package com.example.myapplication.Model;

import android.util.Size;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Thumbnail {
    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    @Override
    public String toString() {
        return "path='" + path + '\'' + ", extension='" + extension + "/'";
    }
}
