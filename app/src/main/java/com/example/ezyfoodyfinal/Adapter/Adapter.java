package com.example.ezyfoodyfinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfoodyfinal.DetailActivity;
import com.example.ezyfoodyfinal.Models.MainModel;
import com.example.ezyfoodyfinal.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder>{

    ArrayList<MainModel> foodlist;
    Context context;

    public Adapter(ArrayList<MainModel> foodlist, Context context) {
        this.foodlist = foodlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_food,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = foodlist.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.name.setText(model.getFoodName());
        holder.price.setText(model.getFoodPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getFoodName());
                intent.putExtra("price",model.getFoodPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView name, price;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.images);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}

