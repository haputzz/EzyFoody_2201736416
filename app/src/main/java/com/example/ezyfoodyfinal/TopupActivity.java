package com.example.ezyfoodyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TopupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
    }

    public void goBack(View view){
        TextView textviewsaldo = (TextView) findViewById(R.id.editTextNumber);
        String saldo = textviewsaldo.getText().toString();
        int muni = Integer.parseInt(saldo);
        if(muni>2000001){
            Toast.makeText(TopupActivity.this,"max 2.000.000",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, MainActivity.class);

            intent.putExtra("EXTRA_SALDO",saldo);

            startActivity(intent);
        }

    }
}