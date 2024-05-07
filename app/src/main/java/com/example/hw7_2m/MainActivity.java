package com.example.hw7_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, result;
    private Boolean isOparationClick;
    private String opeation;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.btn_next);
    }

    //button.setOnClickListener(v -> {
    //  Intent intent = new Intent(MainActivity.this, TwoActivity.class);
    //intent.putExtra("key", result);
    // startActivity(intent);
    // finish();
    //});
    public void onNumberClick(View view) {
        if (view.getId() == R.id.ubrat) {
            textView.setText("0");
        } else {
            String text = ((Button) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOparationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }
        }
        button.setVisibility(View.GONE);
        isOparationClick = false;
    }

    public void onOperationClick(View view) {
        button.setVisibility(View.GONE);
        if (view.getId() == R.id.plus) {
            first = Integer.valueOf(textView.getText().toString());
            opeation = "+";

        } else if (view.getId() == R.id.delenie) {
            first = Integer.valueOf(textView.getText().toString());
            opeation = "/";

        } else if (view.getId() == R.id.minus) {
            first = Integer.valueOf(textView.getText().toString());
            opeation = "-";

        } else if (view.getId() == R.id.umnozhit) {
            first = Integer.valueOf(textView.getText().toString());
            opeation = "*";

        } else if (view.getId() == R.id.ravno) {
            second = Integer.valueOf(textView.getText().toString());
            if (opeation.equals("+")) {
                result = first + second;
                textView.setText(result.toString());
            } else if (opeation.equals("-")) {
                result = first - second;
                textView.setText(result.toString());
            } else if (opeation.equals("*")) {
                result = first * second;
                textView.setText(result.toString());
            } else if (opeation.equals("/")) {
                if (second == 0) {
                    textView.setText("Error");
                } else {
                    result = first / second;
                }
            }
            textView.setText(result.toString());
            button.setVisibility(View.VISIBLE);

            button.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                intent.putExtra("key", result.toString());
                startActivity(intent);
                finish();
            });

        }
        isOparationClick = true;
    }

}

