package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity
{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.result);

        Intent i1 = getIntent();

        String ans = i1.getStringExtra("answer");

        tv.setText("YOUS ANSWER IS  = "+ans);
    }
}