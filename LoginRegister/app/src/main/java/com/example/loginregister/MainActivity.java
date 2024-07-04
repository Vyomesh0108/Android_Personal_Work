package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    TextView tv;
    EditText etEmail,etPass;
    Button btlog,btsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvlog);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btlog= findViewById(R.id.btlog);
        btsign = findViewById(R.id.btsign);

        btlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                if(email.equals("xyz@gmail.com") && pass.equals("234567"))
                {
                    Intent i = new Intent(getApplicationContext(),result.class);
                    i.putExtra("L1","Authorised user");
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(getApplicationContext(),result.class);
                    i.putExtra("L1","Unauthorised user");
                    startActivity(i);
                }
            }
        });

        btsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),register.class);
                startActivity(i);
            }
        });

    }
}