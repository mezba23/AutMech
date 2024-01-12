package com.example.mapbox;

//import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.*;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    SelectListenerInterface onItemClickListener;

    public MyAdapter(Context context, List<Item> items, SelectListenerInterface listenerInterface) {
        this.context = context;
        this.items = items;
        this.onItemClickListener = listenerInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nearestLOC.setText(items.get(position).getTitle());

        // Get the context from the holder view
        Context context = holder.itemView.getContext();

        // Set an OnClickListener for the call button
        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement the call functionality here
                // You can use the item data associated with this position
                Toast.makeText(context, "calling...", Toast.LENGTH_SHORT).show();

                // Create an intent for the dial action
                //context.startActivity(new Intent(context, ItemListViewActivity.class));
                Intent intent = new Intent(Intent.ACTION_DIAL);

                // Set the data (phone number) for the intent
                intent.setData(Uri.parse("tel:" + "123456789")); // Replace with the actual phone number

                // Start the activity using the context
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
