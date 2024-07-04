package com.example.localdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;

public class Show extends Activity
{
    static String dbname="std.db";
    String dbpath ="/data/data/com.example.localdatabaseapp/databases/";
    SQLiteDatabase db;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lv = findViewById(R.id.lv);

        try
        {
            String mypath = dbpath + dbname;

            db = SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"DATABASE READ ERROR",Toast.LENGTH_LONG).show();
        }

        Cursor cur = db.rawQuery("select * from mytab",null);

        Toast.makeText(getApplicationContext(),"TOTAL RECORDS : "+cur.getCount(),Toast.LENGTH_LONG).show();

        String data[] = new String[cur.getCount()];
        int i=0;

        while(cur.moveToNext())
        {
            int id = cur.getInt(cur.getColumnIndex("sid"));
            String na = cur.getString(cur.getColumnIndex("sna"));
            int age = cur.getInt(cur.getColumnIndex("sag"));

            data[i++] = ""+id+" , "+na+" , "+age;

        }
        db.close();

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        lv.setAdapter(ad);
    }
}