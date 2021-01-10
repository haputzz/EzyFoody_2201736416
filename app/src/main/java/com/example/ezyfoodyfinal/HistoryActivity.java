package com.example.ezyfoodyfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ezyfoodyfinal.Adapter.AdapterHistory;
import com.example.ezyfoodyfinal.Models.HistoryModel;
import com.example.ezyfoodyfinal.Models.OrderModel;
import com.example.ezyfoodyfinal.databinding.ActivityHistoryBinding;

import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {

    ActivityHistoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HistoryDBHelper helper = new HistoryDBHelper(this);
        ArrayList<HistoryModel> FoodList = helper.getHistory();

        AdapterHistory adapter = new AdapterHistory(FoodList, this);

        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    public void Home(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
//        finish();

    }
}