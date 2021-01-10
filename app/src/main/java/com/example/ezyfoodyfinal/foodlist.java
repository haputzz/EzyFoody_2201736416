package com.example.ezyfoodyfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ezyfoodyfinal.Adapter.Adapter;
import com.example.ezyfoodyfinal.Models.MainModel;
import com.example.ezyfoodyfinal.databinding.ActivityFoodlistBinding;

import java.util.ArrayList;

public class foodlist extends AppCompatActivity {

    ActivityFoodlistBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> FoodList = new ArrayList<>();

        FoodList.add(new MainModel(R.drawable.burger, "burger 1","50000"));
        FoodList.add(new MainModel(R.drawable.burger2, "burger 2","60000"));
        FoodList.add(new MainModel(R.drawable.chicken, "chicken","80000"));
        FoodList.add(new MainModel(R.drawable.pizza, "pizza 1","100000"));
        FoodList.add(new MainModel(R.drawable.pizza2, "pizza 2","300000"));
        FoodList.add(new MainModel(R.drawable.burger, "burger 1","50000"));
        FoodList.add(new MainModel(R.drawable.burger2, "burger 2","60000"));
        FoodList.add(new MainModel(R.drawable.chicken, "chicken","80000"));
        FoodList.add(new MainModel(R.drawable.pizza, "pizza 1","100000"));
        FoodList.add(new MainModel(R.drawable.pizza2, "pizza 2","300000"));

        Adapter adapter = new Adapter(FoodList, this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(foodlist.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
