package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menuzone extends Activity
{
    Button btInsert,btDelete,btUpdate,btShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuzone);

        btInsert = findViewById(R.id.btInsert);
        btDelete = findViewById(R.id.btDelete);
        btUpdate = findViewById(R.id.btUpdate);
        btShow = findViewById(R.id.btShow);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),ShowData.class);
                startActivity(intent);
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DeleteData.class);
                startActivity(intent);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),UpdateUser.class);
                startActivity(intent);
            }
        });

    }
}