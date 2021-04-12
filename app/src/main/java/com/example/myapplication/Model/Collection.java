package com.example.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Collection<T> {
    @SerializedName("offset")
    private int offset;
    @SerializedName("limit")
    private int limit;
    @SerializedName("total")
    private int total;
    @SerializedName("results")
    private List<T> results = new ArrayList<>();

    protected List<T> getResults() {
        return results;
    }
}
