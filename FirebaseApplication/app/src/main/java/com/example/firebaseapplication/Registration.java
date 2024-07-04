package com.example.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Registration extends Activity
{
    EditText etRegistrationMail,etRegistrationPassword,etRegistrationName,etRegistrationMobile;
    Button btRegistrationSubmit,btRegistrationCancel;

    FirebaseAuth fAuth;
    DatabaseReference dbRef;
    ArrayList<User> userlist = new ArrayList<User>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etRegistrationMail = findViewById(R.id.etRegistrationEmail);
        etRegistrationName = findViewById(R.id.etRegistrationName);
        etRegistrationMobile = findViewById(R.id.etRegistrationMobile);
        etRegistrationPassword = findViewById(R.id.etRegistrationPassword);

        btRegistrationSubmit = findViewById(R.id.btRegistrationSubmit);
        btRegistrationCancel = findViewById(R.id.btRegistrationCancel);

        fAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference("user");

        lv = findViewById(R.id.lvReal);


        btRegistrationSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String mail = etRegistrationMail.getText().toString();
                final String pass = etRegistrationPassword.getText().toString();
                final String name = etRegistrationName.getText().toString();
                final String mob = etRegistrationMobile.getText().toString();

                fAuth.createUserWithEmailAndPassword(mail, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                String uid = dbRef.push().getKey();

                                User u1 = new User(uid,name,mob,mail,pass);
                                dbRef.child(uid).setValue(u1);

                                Toast.makeText(getApplicationContext(),"USER REGISTERED SUCCESSFULLY",Toast.LENGTH_LONG).show();

                                dbRef.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot)
                                    {
                                        userlist.clear();

                                        for (DataSnapshot snap : snapshot.getChildren())
                                        {
                                            User u1 = snap.getValue(User.class);

                                            userlist.add(u1);
                                        }

                                        ArrayAdapter<User> ad = new ArrayAdapter<User>(getApplicationContext(), android.R.layout.simple_list_item_1,userlist);
                                        lv.setAdapter(ad);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext(),"USER REGISTERATION FAIL"+e.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        });

            }
        });

        btRegistrationCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etRegistrationMail.setText("");
                etRegistrationPassword.setText("");
                etRegistrationName.setText("");
                etRegistrationMobile.setText("");
            }
        });
    }
}