package com.example.sumactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etNum1, etNum2;
    TextView tvans;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvans = findViewById(R.id.tvans);
        btnsubmit = findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String n1, n2;
                n1 = etNum1.getText().toString();
                n2 = etNum2.getText().toString();

                int num1, num2, sum;

                num1 = Integer.parseInt(n1);
                num2 = Integer.parseInt(n2);

                sum = num1 + num2;

                tvans.setText("Ans is "+sum);

                Toast.makeText(MainActivity.this, "Ans is "+sum, Toast.LENGTH_SHORT).show();
            }
        });
    }
}