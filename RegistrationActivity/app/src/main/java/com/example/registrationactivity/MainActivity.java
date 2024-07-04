package com.example.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText etname,etgen,etema,etmob,etpass,ethob1,ethob2,ethob3,ethob4;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=findViewById(R.id.etname);
        etgen=findViewById(R.id.etgen);
        etema=findViewById(R.id.etema);
        etmob=findViewById(R.id.etmob);
        etpass=findViewById(R.id.etpass);
        ethob1=findViewById(R.id.ethob1);
        ethob2=findViewById(R.id.ethob2);
        ethob3=findViewById(R.id.ethob3);
        ethob4=findViewById(R.id.ethob4);
        reg=findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String gender=etgen.getText().toString();
                String email=etema.getText().toString();
                String mobile=etmob.getText().toString();
                String password=etpass.getText().toString();
                String hobbies1=ethob1.getText().toString();
                String hobbies2=ethob2.getText().toString();
                String hobbies3=ethob3.getText().toString();
                String hobbies4=ethob4.getText().toString();

                Intent intent = new Intent(MainActivity.this,DataActivity.class);
                intent.putExtra("NAME",name);
                intent.putExtra("GENDER",gender);
                intent.putExtra("EMAIL",email);
                intent.putExtra("MOBILE",mobile);
                intent.putExtra("PASSWORD",password);
                intent.putExtra("HOBBIES1",hobbies1);
                intent.putExtra("HOBBIES2",hobbies2);
                intent.putExtra("HOBBIES3",hobbies3);
                intent.putExtra("HOBBIES4",hobbies4);
                startActivity(intent);
            }
        });
    }
}