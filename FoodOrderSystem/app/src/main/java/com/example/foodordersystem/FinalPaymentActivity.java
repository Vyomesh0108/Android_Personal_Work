package com.example.foodordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class FinalPaymentActivity extends Activity  implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);

        Intent ii = getIntent();
        float pay = Float.parseFloat(ii.getStringExtra("pay"));

        Checkout checkout = new Checkout();

        checkout.setKeyID("rzp_test_K045hOu0KF1zbg");

        JSONObject jsonObject = new JSONObject();

        try
        {
            jsonObject.put("name","VRUTTI MISTRY");
            jsonObject.put("description","This is description");
            jsonObject.put("theme.color","#0093DD");
            jsonObject.put("currency","INR");
            jsonObject.put("amount",pay*100);
            jsonObject.put("prefile.contact","9427449491");
            jsonObject.put("prefile.email","vruttimistry18@gmail.com");

            checkout.open(this, jsonObject);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"\n PAYMENT ERROR : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void onPaymentSuccess(String s) {

    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}