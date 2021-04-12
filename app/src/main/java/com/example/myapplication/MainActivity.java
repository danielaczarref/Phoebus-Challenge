package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.API.APIConfig;
import com.example.myapplication.API.ApiException;
import com.example.myapplication.API.ComicClient;
import com.example.myapplication.Model.ComicsDTO;
import com.example.myapplication.Model.Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pubKey = "309bcf661d6538f7982c1da6a5890bd8";
        String privKey =  "60e3c913e299cc90ff3a7371cb3b4fd564cd95b4";
        APIConfig apiConfig = new APIConfig.Builder(pubKey, privKey).build();

        try {
            ComicClient comicClient = new ComicClient(apiConfig);
            Response<ComicsDTO> comicsDTOResponse = comicClient.getAll(0, 15);
            System.out.println(comicsDTOResponse.toString());
        } catch (ApiException e) {
            System.out.println("Um erro ae: " + e);
            e.printStackTrace();
        }

        ArrayList<Item> itemArrayList = new ArrayList<>();
    }
}