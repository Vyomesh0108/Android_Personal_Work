package com.example.sign_upactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnSignin,btnSign;

    public static final String main_key="myPref";
    public static final String name_key="nameKey";
    public static final String email_key="emailKey";
    public static final String password_key="passwordKey";
    public static final String contact_key="contactKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignin=findViewById(R.id.btnSignin);
        btnSign=findViewById(R.id.btnSign);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail,userPassword;
                userEmail=etEmail.getText().toString();
                userPassword=etPassword.getText().toString();

                SharedPreferences Preferences=getSharedPreferences(main_key,MODE_PRIVATE);
                String email = Preferences.getString(email_key,"");
                String password = Preferences.getString(password_key,"");
                String name = Preferences.getString(name_key,"");
                String contact = Preferences.getString(contact_key,"");

                if(userEmail.equals(email) && userPassword.equals(password))
                {
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra(name_key,name);
                    intent.putExtra(email_key,email);
                    intent.putExtra(password_key,password);
                    intent.putExtra(contact_key,contact);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Login Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}