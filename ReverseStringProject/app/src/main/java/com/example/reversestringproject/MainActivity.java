package com.example.reversestringproject;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
    TextView tv;
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et =  findViewById(R.id.etmsg);
        bt = findViewById(R.id.btrev);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = et.getText().toString();

                StringBuffer sb = new StringBuffer(msg);
                msg =  sb.reverse().toString();

                tv.setText(msg);

                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
    }
}