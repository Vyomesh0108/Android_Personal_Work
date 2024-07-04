package com.example.percentageandgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etnum1,etnum2,etnum3,etnum4,etnum5;
    Button btn;
    TextView percent,grade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1 = findViewById(R.id.etnum1);
        etnum2 = findViewById(R.id.etnum2);
        etnum3 = findViewById(R.id.etnum3);
        etnum4 = findViewById(R.id.etnum4);
        etnum5 = findViewById(R.id.etnum5);
        btn = findViewById(R.id.btn);
        percent = findViewById(R.id.percent);
        grade = findViewById(R.id.grade);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String n1,n2,n3,n4,n5;

                n1=etnum1.getText().toString();
                n2=etnum2.getText().toString();
                n3=etnum3.getText().toString();
                n4=etnum4.getText().toString();
                n5=etnum5.getText().toString();

                int num1,num2,num3,num4,num5,total;
                float per;

                num1=Integer.parseInt(n1);
                num2=Integer.parseInt(n2);
                num3=Integer.parseInt(n3);
                num4=Integer.parseInt(n4);
                num5=Integer.parseInt(n5);

                total = num1+num2+num3+num4+num5;
                per = (float)total/5;

                percent.setText("Percentage is "+per);

                if(per>=90 && per<100)
                {
                    grade.setText("Grade is A+");

                    Toast.makeText(MainActivity.this, "Grade is A+", Toast.LENGTH_SHORT).show();
                }
                else if(per>=80 && per<90)
                {
                    grade.setText("Grade is A");

                    Toast.makeText(MainActivity.this, "Grade is A", Toast.LENGTH_SHORT).show();
                }
                else if(per>=75 && per<80)
                {
                    grade.setText("Grade is B+");

                    Toast.makeText(MainActivity.this, "Grade is B+", Toast.LENGTH_SHORT).show();
                }
                else if(per>=70 && per<75)
                {
                    grade.setText("Grade is B");

                    Toast.makeText(MainActivity.this, "Grade is B", Toast.LENGTH_SHORT).show();
                }
                else if(per>=65 && per<70)
                {
                    grade.setText("Grade is C+");

                    Toast.makeText(MainActivity.this, "Grade is C+", Toast.LENGTH_SHORT).show();
                }
                else if(per>=60 && per<65)
                {
                    grade.setText("Grade is C");

                    Toast.makeText(MainActivity.this, "Grade is C", Toast.LENGTH_SHORT).show();
                }
                else if(per>=55 && per<60)
                {
                    grade.setText("Grade is D+");

                    Toast.makeText(MainActivity.this, "Grade is D+", Toast.LENGTH_SHORT).show();
                }
                else if(per>=50 && per<55)
                {
                    grade.setText("Grade is D");

                    Toast.makeText(MainActivity.this, "Grade is D", Toast.LENGTH_SHORT).show();
                }
                else if(per>=45 && per<50)
                {
                    grade.setText("Grade is E+");

                    Toast.makeText(MainActivity.this, "Grade is E+", Toast.LENGTH_SHORT).show();
                }
                else if(per>=40 && per<45)
                {
                    grade.setText("Grade is E");

                    Toast.makeText(MainActivity.this, "Grade is E", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    grade.setText("Grade is F(Fail)");

                    Toast.makeText(MainActivity.this, "Grade is F(Fail)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}