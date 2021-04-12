package com.example.myapplication.API;

import com.example.myapplication.Model.ComicsDTO;
import com.example.myapplication.Model.Response;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ComicREST {
    @GET("comics")
    Call<Response<ComicsDTO>> getComics(
            @QueryMap Map<String, Object> comic
    );

    @GET("comics/id")
    Call<Response<ComicsDTO>> getComic(
            @Path("id") String idComic
    );
}
