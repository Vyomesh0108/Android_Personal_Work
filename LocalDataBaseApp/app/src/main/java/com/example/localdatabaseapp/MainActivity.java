package com.example.localdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    Button bsh,bins,bupd,bdel;
    static String dbname="std.db";
    String dbpath ="/data/data/com.example.localdatabaseapp/databases/";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsh = findViewById(R.id.bsh);
        bins = findViewById(R.id.bin);
        bupd = findViewById(R.id.bup);
        bdel = findViewById(R.id.bdel);

        MySqliterOpenHelper ms =  new MySqliterOpenHelper(this);
        ms.checkDatabase();

        bsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(getApplicationContext(),Show.class);
                startActivity(ii);
            }
        });

        bins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InsertDialog dial = new InsertDialog(MainActivity.this);
                dial.show();

            }
        });

        bupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpdateDialog dial = new UpdateDialog(MainActivity.this);
                dial.show();
            }
        });
    }
}