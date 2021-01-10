package com.example.ezyfoodyfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ezyfoodyfinal.Adapter.Adapter;
import com.example.ezyfoodyfinal.Models.MainModel;
import com.example.ezyfoodyfinal.databinding.ActivityDrinklistBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class drinklist extends AppCompatActivity {

    ActivityDrinklistBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrinklistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> FoodList = new ArrayList<>();

        FoodList.add(new MainModel(R.drawable.drink1, "drink 1","50000"));
        FoodList.add(new MainModel(R.drawable.drink2, "drink 2","60000"));
        FoodList.add(new MainModel(R.drawable.drink3, "drink 3","80000"));
        FoodList.add(new MainModel(R.drawable.drink4, "drink 4","100000"));
        FoodList.add(new MainModel(R.drawable.drink5, "drink 5","300000"));
        FoodList.add(new MainModel(R.drawable.drink2, "drink 6","50000"));
        FoodList.add(new MainModel(R.drawable.drink1, "drink 7","60000"));
        FoodList.add(new MainModel(R.drawable.drink4, "drink 8","80000"));
        FoodList.add(new MainModel(R.drawable.drink3, "drink 9","100000"));
        FoodList.add(new MainModel(R.drawable.drink5, "drink 10","300000"));

        Adapter adapter = new Adapter(FoodList, this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
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
                startActivity(new Intent(drinklist.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}