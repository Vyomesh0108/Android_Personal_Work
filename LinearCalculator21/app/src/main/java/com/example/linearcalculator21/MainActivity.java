package com.example.linearcalculator21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
    EditText et;
    Button b[] = new Button[19];
    int id[] = {R.id.btcan, R.id.btback, R.id.btper, R.id.btdiv,
                R.id.bt7,R.id.bt8,R.id.bt9,R.id.btmul,
                R.id.bt4,R.id.bt5,R.id.bt6,R.id.btmin,
                R.id.bt1,R.id.bt2,R.id.bt3,R.id.btplus,
                R.id.btdot,R.id.bt0,R.id.bteql};
    String no="";
    int s=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);

        for(int i=0;i<b.length;i++)
        {
            b[i] = findViewById(id[i]);

            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = (Button)v;

                    String lab = b.getText().toString();

                    if(lab.equals("+"))
                    {
                        s=s+Integer.parseInt(no);
                        no="";
                    }
                    else if(lab.equals("="))
                    {
                        et.setText(""+s);
                    }
                    else if(lab.equals("C"))
                    {
                        s=0;
                        no="";
                        et.setText("0");
                    }
                    else if(lab.equals("B"))
                    {
                        no = no.substring(0,no.length()-1);
                        et.setText(no);
                    }
                    else
                    {
                        no = no+b.getText().toString();
                        et.setText(no);
                    }

                }
            });
        }


    }
}