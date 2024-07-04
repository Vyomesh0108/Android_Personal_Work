package com.example.sign_upactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    Button btnLogout;
    public static final String main_key="myPref";
    public static final String name_key="nameKey";
    public static final String email_key="emailKey";
    public static final String password_key="passwordKey";
    public static final String contact_key="contactKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout=findViewById(R.id.btnLogout);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);

        Intent intent = getIntent();
        String name = intent.getStringExtra(name_key);
        tv1.setText("Name : "+name);

        String email = intent.getStringExtra(email_key);
        tv2.setText("Email : "+email);

        String pass = intent.getStringExtra(password_key);
        tv3.setText("Password : "+pass);

        String contact = intent.getStringExtra(contact_key);
        tv4.setText("Mobile no : "+contact);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.commit();
                finish();
                moveTaskToBack(true);
            }
        });
    }
}