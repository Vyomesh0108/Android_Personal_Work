package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentOutput extends AppCompatActivity
{
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_output);

        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExplicitIntentOutput.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
