package com.example.explicitdata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentDataOutput extends AppCompatActivity
{
    TextView tvname;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_data_output);

        tvname=findViewById(R.id.tvname);

        Intent intent = getIntent();
        String nm = intent.getStringExtra("NAME");

        tvname.setText("Welcome "+nm);
    }
}
