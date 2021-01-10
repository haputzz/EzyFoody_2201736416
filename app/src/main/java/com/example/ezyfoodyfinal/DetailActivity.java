package com.example.ezyfoodyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfoodyfinal.databinding.ActivityDetailBinding;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    int quantity = 0;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        count = (TextView)findViewById(R.id.counted);

        final int image = getIntent().getIntExtra("image",0);
        final String name = getIntent().getStringExtra("name");
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));

        binding.imageItem.setImageResource(image);
        binding.itemName.setText(name);
        binding.itemPrice.setText(String.format("%d",price));

//        String paydate = "1/8/2021";

        DBHelper helper = new DBHelper(this);
        HistoryDBHelper helperhistory= new HistoryDBHelper(this);

        binding.payBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertOrder(name,price,image,binding.address.getText().toString(),binding.counted.getText().toString());
                boolean inserted = helperhistory.insertHistory(name,price,image,binding.address.getText().toString(),binding.counted.getText().toString(),"1/8/2021");
                if(isInserted && inserted){
                    Toast.makeText(DetailActivity.this, "data success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DetailActivity.this, "error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void add(View view){
        quantity++;
        count.setText(Integer.toString(quantity));
    }

    public void minus(View view){
        quantity--;
        count.setText(Integer.toString(quantity));
    }
}