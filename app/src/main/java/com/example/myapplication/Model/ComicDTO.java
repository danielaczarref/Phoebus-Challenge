package com.example.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class ComicDTO {
    @SerializedName("idComic")
    private String idComic;
    @SerializedName("digitalIdComic")
    private int digitalIdComic;
    @SerializedName("titleComic")
    private String titleComic;
    @SerializedName("issueNumber")
    private double issueNumber;
    @SerializedName("descComic")
    private String descComic;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("textObjects")
    private List<Text> textObjects;
    @SerializedName("resURIComic")
    private String resURIComic;
    @SerializedName("thumbnailComic")
    private Thumbnail thumbnailComic;
    @SerializedName("imagesList")
    private List<Thumbnail> imagesList;
    @SerializedName("format")
    private String format;
}
