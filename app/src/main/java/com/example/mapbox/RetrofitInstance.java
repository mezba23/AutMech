package com.example.mapbox;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance
{
    public static RetrofitInstance retrofitInstance;
    ApiInterface apiInterface;

    public RetrofitInstance(String url)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface=retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getRetrofitInstance(String url)
    {
        if(retrofitInstance==null)
            retrofitInstance = new RetrofitInstance(url);

        return retrofitInstance;
    }

}
