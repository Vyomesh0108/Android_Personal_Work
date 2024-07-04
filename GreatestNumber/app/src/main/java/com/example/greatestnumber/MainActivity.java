package com.example.greatestnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etnum1, etnum2;
    Button btn;
    TextView gtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1 = findViewById(R.id.etnum1);
        etnum2 = findViewById(R.id.etnum2);
        btn = findViewById(R.id.btn);
        gtn = findViewById(R.id.gtn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String n1, n2;

                n1 = etnum1.getText().toString();
                n2 = etnum2.getText().toString();

                int num1, num2;

                num1 = Integer.parseInt(n1);
                num2 = Integer.parseInt(n2);

                if(num1 > num2)
                {
                    gtn.setText("Greatest Number is "+num1);

                    Toast.makeText(MainActivity.this, "Greatest Number is "+num1, Toast.LENGTH_SHORT).show();
                }
                else if(num1 == num2)
                {
                    gtn.setText("Both Numbers are same no one is greatest");

                    Toast.makeText(MainActivity.this, "Both numbers are same no one is greatest", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    gtn.setText("Greatest Number is "+num2);

                    Toast.makeText(MainActivity.this, "Greatest Number is "+num2, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}