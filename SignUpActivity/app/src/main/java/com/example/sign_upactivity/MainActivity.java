package com.example.sign_upactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName,etEmail,etPassword,etNumber;
    Button btnSign;

    public static final String main_key="myPref";
    public static final String name_key="nameKey";
    public static final String email_key="emailKey";
    public static final String password_key="passwordKey";
    public static final String contact_key="contactKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etNumber=findViewById(R.id.etNumber);

        btnSign=findViewById(R.id.btnSign);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
                String name,email,password,contact;
                name=etName.getText().toString();
                email=etEmail.getText().toString();
                password=etPassword.getText().toString();
                contact=etNumber.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(name_key,name);
                editor.putString(email_key,email);
                editor.putString(password_key,password);
                editor.putString(contact_key,contact);

                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}