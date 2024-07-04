package com.example.positivenegativezero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etnum1;
    Button btn;
    TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1=findViewById(R.id.etnum1);
        btn=findViewById(R.id.btn);
        show=findViewById(R.id.show);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String n1;

                n1 = etnum1.getText().toString();

                int num1;

                num1 = Integer.parseInt(n1);

                if(num1>0)
                {
                    show.setText("Given Number is Positive");

                    Toast.makeText(MainActivity.this, "Given Number is Positive", Toast.LENGTH_SHORT).show();
                }
                else if(num1==0)
                {
                    show.setText("Given Number is Zero");

                    Toast.makeText(MainActivity.this, "Given Number is Zero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    show.setText("Given Number is Negative");

                    Toast.makeText(MainActivity.this, "Given Number is Negative", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}