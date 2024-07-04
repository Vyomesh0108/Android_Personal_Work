package com.example.sharedprefernceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    TextView tv;
    EditText etProdName,etProdPrice;
    Button btBuyNow;
    SharedPreferences shad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvLogin);
        etProdName = findViewById(R.id.etProdName);
        etProdPrice = findViewById(R.id.etProdPrice);
        btBuyNow = findViewById(R.id.btBuyNow);

        shad = getSharedPreferences("mycookie", Context.MODE_PRIVATE);

        //if it is opened very first time ,it will create new file
        //otherwise it will open existing file

        String pname = shad.getString("productName","no");
        //if first time open,it will get "no" as a default value
        int pprice = shad.getInt("productPrice",0);
        //if first time open ,it will get 0 as a default value

        if(pname.equals("no") && pprice==0)
        {
            tv.setText("WEL-COME TO PRODUCT ZONE , ENJOY YOUR FIRST VISIT");
        }
        else
        {
            tv.setText("WEL-COME CLIENT AGAIN");
            tv.setText(", YOUR LAST PURCHASE WAS : "+pname+" AT PRICE :"+pprice);
        }

        btBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pna = etProdName.getText().toString();
                int pr = Integer.parseInt(etProdPrice.getText().toString());

                SharedPreferences.Editor edit = shad.edit();

                edit.putString("productName",pna);
                edit.putInt("productPrice",pr);
                edit.commit();

                etProdName.setText("");
                etProdPrice.setText("");
            }
        });
    }
}