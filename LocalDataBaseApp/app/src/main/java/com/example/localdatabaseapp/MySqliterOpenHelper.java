package com.example.localdatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MySqliterOpenHelper extends SQLiteOpenHelper
{
    static String dbname="std.db";
    String dbpath ="/data/data/com.example.localdatabaseapp/databases/";
    SQLiteDatabase db;
    Context cont;

    MySqliterOpenHelper(Context cont)
    {
        super(cont,dbname,null,1);
        this.cont = cont;
    }

    void checkDatabase()
    {
        String mypath = dbpath+dbname;

        try
        {
            db = SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch (Exception e)
        {
            Toast.makeText(cont,"DATABASE DOESN'T EXISTS",Toast.LENGTH_LONG).show();
        }

        if(db==null)
        {
            this.getReadableDatabase();  //it will create empty database
            this.close();

            try
            {
                InputStream is = cont.getAssets().open("std.db");
                OutputStream os = new FileOutputStream(mypath);

                byte b[] = new byte[1024];
                int length;

                while((length = is.read(b))>0)
                {
                    os.write(b,0,length);
                }

                is.close();
                os.close();

                Toast.makeText(cont,"DATABASE CREATED SUCCESSFULLY...",Toast.LENGTH_LONG).show();
            }
            catch(Exception e)
            {
                Toast.makeText(cont,"DATABASE CREATION ERROR..",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(cont,"DATABASE ALREADY EXISTS....",Toast.LENGTH_LONG).show();
            db.close();
        }
    }


   @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

   }

   @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1){

   }
}
