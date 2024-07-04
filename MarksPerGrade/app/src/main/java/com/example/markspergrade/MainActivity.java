package com.example.markspergrade;

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
    EditText etmrk1,etmrk2,etmrk3;
    Button btper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmrk1 = findViewById(R.id.etmrk1);
        etmrk2 = findViewById(R.id.etmrk2);
        etmrk3 = findViewById(R.id.etmrk3);
        btper = findViewById(R.id.btper);

        btper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int mrk1 = Integer.parseInt(etmrk1.getText().toString());
                int mrk2 = Integer.parseInt(etmrk2.getText().toString());
                int mrk3 = Integer.parseInt(etmrk3.getText().toString());


                int total =mrk1+mrk2+mrk3;
                float per =(float)total/3;

                if(per>=90 && per<100)
                {
                    String grade ="A+";
                    Toast.makeText(MainActivity.this, "GRADE A+", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if (per>=80 && per<90)
                {
                    String grade ="A";
                    Toast.makeText(MainActivity.this, "GRADE A", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if (per>=70 && per<80)
                {
                    String grade ="B+";
                    Toast.makeText(MainActivity.this, "GRADE B+", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if (per>=60 && per<70)
                {
                    String grade ="B";
                    Toast.makeText(MainActivity.this, "GRADE B", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if (per>=50 && per<60)
                {
                    String grade ="C+";
                    Toast.makeText(MainActivity.this, "GRADE C+", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if(per>=40 && per<50)
                {
                    String grade ="C";
                    Toast.makeText(MainActivity.this, "GRADE C", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
                else if(per>=30 && per<40)
                {
                    String grade ="D";
                    Toast.makeText(MainActivity.this, "GRADE D", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("per",""+per);
                    intent.putExtra("grade",""+grade);
                    startActivity(intent);

                }
            }
        });

    }
}