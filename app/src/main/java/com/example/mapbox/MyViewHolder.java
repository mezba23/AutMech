package com.example.mapbox;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageButton btnCall;
    TextView nearestLOC;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        nearestLOC = itemView.findViewById(R.id.nearbyLOC);
        btnCall = itemView.findViewById(R.id.btnCall);
    }
}
