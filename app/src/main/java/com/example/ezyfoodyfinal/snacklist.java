package com.example.ezyfoodyfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ezyfoodyfinal.Adapter.Adapter;
import com.example.ezyfoodyfinal.Models.MainModel;
import com.example.ezyfoodyfinal.databinding.ActivitySnacklistBinding;

import java.util.ArrayList;

public class snacklist extends AppCompatActivity {

    ActivitySnacklistBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySnacklistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> FoodList = new ArrayList<>();

        FoodList.add(new MainModel(R.drawable.cake1, "cake1","50000"));
        FoodList.add(new MainModel(R.drawable.choco, "choco","60000"));
        FoodList.add(new MainModel(R.drawable.icecream3, "ice cream mint","80000"));
        FoodList.add(new MainModel(R.drawable.icecream, "ice cream vanilla","100000"));
        FoodList.add(new MainModel(R.drawable.icecream2, "ice cream strawberry","300000"));
        FoodList.add(new MainModel(R.drawable.choco, "choco chips","50000"));
        FoodList.add(new MainModel(R.drawable.icecream, "ice cream fruity","60000"));
        FoodList.add(new MainModel(R.drawable.cake1, "cake 2","80000"));
        FoodList.add(new MainModel(R.drawable.icecream3, "ice cream orange","100000"));
        FoodList.add(new MainModel(R.drawable.icecream2, "ice cream lemon","300000"));

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
                startActivity(new Intent(snacklist.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}