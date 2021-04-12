package com.example.myapplication.Model;

import java.util.List;

public class ComicsDTO extends Collection<ComicDTO> {

    public List<ComicDTO> getComics() {
        return getResults();
    }
}
