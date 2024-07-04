package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends Activity
{
    TextView tvregister;
    EditText etemail,etpass,etname,etphone,etadd;
    Button btReg,btCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvregister = findViewById(R.id.tvregister);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        etphone = findViewById(R.id.etphone);
        etadd = findViewById(R.id.etadd);
        etname = findViewById(R.id.etname);
        btReg = findViewById(R.id.btReg);
        btCan = findViewById(R.id.btCan);

        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etemail.getText().toString();
                String pass = etpass.getText().toString();
                String name = etname.getText().toString();
                String phone = etphone.getText().toString();
                String add = etadd.getText().toString();

                Intent i = new Intent(register.this,registeroutput.class);
                i.putExtra("email",email);
                i.putExtra("pass",pass);
                i.putExtra("name",name);
                i.putExtra("phone",phone);
                i.putExtra("add",add);
                startActivity(i);

            }
        });

        btCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etemail.getText().clear();
                etpass.getText().clear();
                etname.getText().clear();
                etphone.getText().clear();
                etadd.getText().clear();
            }
        });
    }
}