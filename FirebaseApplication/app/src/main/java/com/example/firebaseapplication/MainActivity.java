package com.example.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends Activity
{
    FirebaseAuth fAuth;
    EditText etLoginEmail,etLoginPassword;
    Button btLoginLogin,btLoginSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);

        btLoginLogin = findViewById(R.id.btLoginLogin);
        btLoginSignUp = findViewById(R.id.btLoginSignUp);

        btLoginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);

            }
        });


        btLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = etLoginEmail.getText().toString();
                String pass = etLoginPassword.getText().toString();

                fAuth.signInWithEmailAndPassword(mail,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                Toast.makeText(getApplicationContext(),"AUTHORISED USER ...",Toast.LENGTH_LONG).show();
                                etLoginEmail.setText("");
                                etLoginPassword.setText("");

                                Intent intent = new Intent(getApplicationContext(),Menuzone.class);
                                startActivity(intent);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext(),"UNAUTHORISED USER ...",Toast.LENGTH_LONG).show();

                                etLoginEmail.setText("");
                                etLoginPassword.setText("");
                            }
                        });

            }
        });


    }
}