package com.example.foodordersystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import org.w3c.dom.Text;

//rzp_test_K045hOu0KF1zbg

public class MainActivity extends Activity
{
    ElegantNumberButton e[] = new ElegantNumberButton[7];
    int id[]={R.id.pizza,R.id.burger,R.id.frankie,R.id.platter,R.id.coke,R.id.pepsi,R.id.water};
    TextView tv;
    int i,sum=0;
    int s[] = new int[7];
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.totAmt);
        bt = findViewById(R.id.bt);

       for(i=0;i<e.length;i++)
        {
            e[i]=findViewById(id[i]);
            e[i].setOnClickListener(new ElegantNumberButton.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View view)
                {
                    ElegantNumberButton enb =(ElegantNumberButton)view;

                    int price = Integer.parseInt(enb.getContentDescription().toString());
                    int qty = Integer.parseInt(enb.getNumber());
                    int index = Integer.parseInt(enb.getTooltipText().toString());

                    s[index] = price*qty;

                    sum=0;
                    for(i=0;i<s.length;i++)
                    {
                        sum = sum + s[i];
                    }

                    tv.setText("Total Amt = "+sum);

                }
            });

        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(getApplicationContext(),FinalPaymentActivity.class);
                ii.putExtra("pay",""+sum);
                startActivity(ii);

            }
        });
    }
}