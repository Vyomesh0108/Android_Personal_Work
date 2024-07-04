package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
   EditText etn1,etn2;
   Button btplus,btmin,btmul,btdiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // used to connect current java file respective xml file

        etn1 = findViewById(R.id.etn1);
        etn2 = findViewById(R.id.etn2);
        btplus = findViewById(R.id.btplus);
        btmin = findViewById(R.id.btmin);
        btmul = findViewById(R.id.btmul);
        btdiv = findViewById(R.id.btdiv);

        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int n1 = Integer.parseInt(etn1.getText().toString());
                int n2 = Integer.parseInt(etn2.getText().toString());

                int add = n1+n2;

                Toast.makeText(getApplicationContext(), "ADDITION = "+add,Toast.LENGTH_LONG).show();

                Intent i1 = new Intent(getApplicationContext(),ResultActivity.class);  // intent is used to call another activity or screen
                i1.putExtra( "answer", ""+add);  //used to pass data
                startActivity(i1);  //used to call activity

            }
        });


         btmin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 int n1 = Integer.parseInt(etn1.getText().toString());
                 int n2 = Integer.parseInt(etn2.getText().toString());

                 int min = n1-n2;

                 Toast.makeText(getApplicationContext(), "SUBTRACTION = "+min,Toast.LENGTH_LONG).show();

                 Intent i1 = new Intent(getApplicationContext(),ResultActivity.class);  // intent is used to call another activity or screen
                 i1.putExtra( "answer", ""+min);  //used to pass data
                 startActivity(i1);  //used to call activity


             }
         });


         btmul.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 int n1 = Integer.parseInt(etn1.getText().toString());
                 int n2 = Integer.parseInt(etn2.getText().toString());

                 int mul = n1*n2;

                 Toast.makeText(getApplicationContext(), "MULTIPLICATION = "+mul,Toast.LENGTH_LONG).show();

                 Intent i1 = new Intent(getApplicationContext(),ResultActivity.class);  // intent is used to call another activity or screen
                 i1.putExtra( "answer", ""+mul);  //used to pass data
                 startActivity(i1);  //used to call activity


             }
         });

         btdiv.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 int n1 = Integer.parseInt(etn1.getText().toString());
                 int n2 = Integer.parseInt(etn2.getText().toString());

                 int div = n1/n2;

                 Toast.makeText(getApplicationContext(), "DIVISION= "+div,Toast.LENGTH_LONG).show();

                 Intent i1 = new Intent(getApplicationContext(),ResultActivity.class);  // intent is used to call another activity or screen
                 i1.putExtra( "answer", ""+div);  //used to pass data
                 startActivity(i1);  //used to call activity


             }
         });


    }
}