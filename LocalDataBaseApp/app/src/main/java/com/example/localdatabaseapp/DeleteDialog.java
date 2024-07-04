package com.example.localdatabaseapp;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class DeleteDialog extends Dialog
{
    Context context;
    EditText etna;
    Button btdel,btcan;
    static String dbname = "std.db";
    String dbpath = "/data/data/com.example.localdatabaseapp/databases/";
    SQLiteDatabase db;

    DeleteDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.deletedialog);

        etna = findViewById(R.id.etna);

        btdel = findViewById(R.id.btdel);
        btcan = findViewById(R.id.btcan);

        btdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}