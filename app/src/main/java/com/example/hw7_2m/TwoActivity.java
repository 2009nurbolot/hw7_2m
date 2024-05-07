package com.example.hw7_2m;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class TwoActivity extends AppCompatActivity {

    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actyvity_two);
        Intent intend = getIntent();
        int result = intend.getIntExtra("key",0);
        TextView textView = findViewById(R.id.explore_the);
        textView.setText(String.valueOf(result));



        TextView heart=findViewById(R.id.heart);
        AtomicReference<Boolean> heart2= new AtomicReference<>(false);
        heart.setOnClickListener(view -> {
            if (heart2.get() ==false){
                heart.setBackgroundResource(R.drawable.heart_two);
                heart2.set(true);
            } else if (heart2.get()==true) {
                heart.setBackgroundResource(R.drawable.heart);
                heart2.set(false);
            }
        });
    }

    

}