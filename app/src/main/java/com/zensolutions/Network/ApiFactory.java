package com.zensolutions.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.zensolutions.Network.URL.BASE_URL;

public class ApiFactory {
    public static RedditService create(){
        Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();
        Retrofit retrofit= new Retrofit.Builder().baseUrl(BASE_URL)
                                        .addConverterFactory(ScalarsConverterFactory.create())
                                        .addConverterFactory(GsonConverterFactory.create(gson))
                                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                        .build();
        return retrofit.create(com.zensolutions.Network.RedditService.class);
    }
}
