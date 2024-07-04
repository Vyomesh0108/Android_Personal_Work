package com.example.registrationactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity
{
    TextView tvans,tvans1,tvans2,tvans3,tvans4,tvans5,tvans6,tvans7,tvans8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvans=findViewById(R.id.tvans);
        tvans1=findViewById(R.id.tvans1);
        tvans2=findViewById(R.id.tvans2);
        tvans3=findViewById(R.id.tvans3);
        tvans4=findViewById(R.id.tvans4);
        tvans5=findViewById(R.id.tvans5);
        tvans6=findViewById(R.id.tvans6);
        tvans7=findViewById(R.id.tvans7);
        tvans8=findViewById(R.id.tvans8);

        Intent intent = getIntent();
        String nm = intent.getStringExtra("NAME");
        String ge = intent.getStringExtra("GENDER");
        String em = intent.getStringExtra("EMAIL");
        String mb = intent.getStringExtra("MOBILE");
        String ps = intent.getStringExtra("PASSWORD");
        String h1 = intent.getStringExtra("HOBBIES1");
        String h2 = intent.getStringExtra("HOBBIES2");
        String h3 = intent.getStringExtra("HOBBIES3");
        String h4 = intent.getStringExtra("HOBBIES4");


        tvans.setText("Welcome "+nm);
        tvans1.setText("Gender : "+ge);
        tvans2.setText("Email : "+em);
        tvans3.setText("Mobile No. : "+mb);
        tvans4.setText("Password : "+ps);
        tvans5.setText("Hobbies1 : "+h1);
        tvans6.setText("Hobbies2 : "+h2);
        tvans7.setText("Hobbies3 : "+h3);
        tvans8.setText("Hobbies4 : "+h4);
    }
}
