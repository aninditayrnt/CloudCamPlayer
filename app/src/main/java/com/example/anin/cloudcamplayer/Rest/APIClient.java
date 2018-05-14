package com.example.anin.cloudcamplayer.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String url = "https://api.dev.st-av.net/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
