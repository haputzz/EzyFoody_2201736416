package com.example.ezyfoodyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView saldo;
    String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saldo = (TextView)findViewById(R.id.saldo);
            if(getIntent().hasExtra("EXTRA_SALDO")){
                money = getIntent().getStringExtra("EXTRA_SALDO");
            }

            saldo.setText(money);


    }

    public void moveFood(View view){
        Intent intent = new Intent(this, foodlist.class);
        startActivity(intent);
    }

        public void moveSnack(View view){
        Intent intent = new Intent(this, snacklist.class);
        startActivity(intent);
    }

    public void moveDrink(View view){
        Intent intent = new Intent(this, drinklist.class);
        startActivity(intent);
    }

    public void moveOrder(View view){
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
    }

    public void moveTopup(View view){
        Intent intent = new Intent(this, TopupActivity.class);
        startActivity(intent);
    }

    public void moveLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void moveHistory(View view){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

}