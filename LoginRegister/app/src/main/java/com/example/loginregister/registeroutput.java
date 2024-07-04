package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class registeroutput extends Activity
{

    TextView tvDetail,email,pass,name,phone,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeroutput);

        tvDetail = findViewById(R.id.tvDetail);
        email = findViewById(R.id.email);
        pass =  findViewById(R.id.pass);
        phone = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        add = findViewById(R.id.add);

        String ema,password,phne,na,addr;
        Intent i = getIntent();
        ema = i.getStringExtra("email");
        email.setText("Email : "+ema);

        password = i.getStringExtra("password");
        pass.setText("Password : "+password);

        na = i.getStringExtra("name");
        name.setText("Name :"+na);

        phne = i.getStringExtra("phone");
        phone.setText("Phone : "+phne);

        addr = i.getStringExtra("add");
        add.setText("addresss: "+addr);




    }
}