package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result extends Activity
{
    TextView tvres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvres = findViewById(R.id.tvres);

        Intent i = getIntent();

        String output = i.getStringExtra("L1");
        tvres.setText(output);

    }
}