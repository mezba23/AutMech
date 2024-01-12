package com.example.mapbox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiInterface {

    @GET("/list/")
    Call<List<LocationResponse>> getLocations();
}
