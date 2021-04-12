package com.example.myapplication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String imageRes;
    private String comicTitle;
    private String comicDesc;

    public Item(String imageRes, String comicTitle, String comicDesc) {
        this.imageRes = imageRes;
        this.comicTitle = comicTitle;
        this.comicDesc = comicDesc;
    }
}
