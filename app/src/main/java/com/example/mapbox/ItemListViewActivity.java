package com.example.mapbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListViewActivity extends AppCompatActivity implements SelectListenerInterface{

    public static String baseURL="http://localhost:8080";

    RecyclerView recyclerView;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();

        Intent i = getIntent();

        getLocations();
    }

    public void getLocations()
    {
        RetrofitInstance.getRetrofitInstance(baseURL).apiInterface.getLocations().enqueue(new Callback<List<LocationResponse>>()
        {
            @Override
            public void onResponse(@NonNull Call<List<LocationResponse>> call, @NonNull Response<List<LocationResponse>> response)
            {

                if(response.isSuccessful())
                    Toast.makeText(getApplicationContext(), "CODE => "+response.code() , Toast.LENGTH_SHORT).show();

                if(!response.isSuccessful())
                    Toast.makeText(getApplicationContext(), "ERR_CODE => "+response.code() , Toast.LENGTH_SHORT).show();

                assert response.body() != null;
                for(LocationResponse lr: response.body())
                {
                    Log.d("DEBUG",lr.getTitle());
                    itemList.add(new Item(lr.getTitle()));
                }


                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new com.example.mapbox.MyAdapter(getApplicationContext(), itemList, com.example.mapbox.ItemListViewActivity.this));
            }
            @Override
            public void onFailure(@NonNull Call<List<LocationResponse>> call, @NonNull Throwable t)
            {
                Log.e("DEBUG", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), "DEBUG FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(Item item) {
        Toast.makeText(this, "CLICKED", Toast.LENGTH_SHORT).show();
    }
}