package com.example.localdatabaseapp;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDialog extends Dialog
{
    Context context;
    EditText etid,etna,etag;
    Button btupd,btcan;
    static String dbname="std.db";
    String dbpath ="/data/data/com.example.localdatabaseapp/databases/";
    SQLiteDatabase db;

    UpdateDialog(Context context)
    {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.updatedialog);

        etid = findViewById(R.id.etid);
        etna = findViewById(R.id.etna);
        etag = findViewById(R.id.etag);

        btupd = findViewById(R.id.btupd);
        btcan = findViewById(R.id.btcan);

        btupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    String mypath = dbpath + dbname;
                    db = SQLiteDatabase.openDatabase(mypath,null, SQLiteDatabase.OPEN_READONLY);
                }
                catch(Exception e)
                {
                    Toast.makeText(context,"DATABASE ERROR :"+e.getMessage(),Toast.LENGTH_LONG).show();
                }

                int id = Integer.parseInt(etid.getText().toString());
                String na = etna.getText().toString();
                int ag = Integer.parseInt(etag.getText().toString());

                db.execSQL("update into mytab values("+id+",'"+na+"',"+ag+")");

                db.close();

                Toast.makeText(context,"RECORD INSERTED SUCCESSFULLY...",Toast.LENGTH_LONG).show();
            }
        });

    }
}
