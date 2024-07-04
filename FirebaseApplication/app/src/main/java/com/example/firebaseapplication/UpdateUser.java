package com.example.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateUser extends Activity
{
    Spinner spin;
    EditText etUpdPass,etUpdName,etUpdMobile;
    Button btUpdUpdate,btUpdCan;
    DatabaseReference dbRef, dbUpd;
    String mail,uId;
    List<String> maillist= new ArrayList<String>();
    List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        spin = findViewById(R.id.spUserUpdMail);
        etUpdName = findViewById(R.id.etUpdateName);
        etUpdMobile = findViewById(R.id.etUpdateMobile);
        etUpdPass = findViewById(R.id.etUpdatePassword);

        btUpdUpdate = findViewById(R.id.btUpdateUpd);
        btUpdCan = findViewById(R.id.btUpdateCan);

        dbRef = FirebaseDatabase.getInstance().getReference("user");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                userList.clear();
                maillist.clear();

                for (DataSnapshot snap : snapshot.getChildren())
                {
                    User u1 = snap.getValue(User.class);

                    maillist.add(u1.getEmail());
                    userList.add(u1);
                }
                ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,maillist);
                spin.setAdapter(ad);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                User u1 = userList.get(i);

                mail = u1.getEmail();
                uId = u1.getUid();

                etUpdPass.setText(u1.getPassword());
                etUpdName.setText(u1.getName());
                etUpdMobile.setText(u1.getMobile());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btUpdUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = etUpdPass.getText().toString();
                String name = etUpdName.getText().toString();
                String mobile = etUpdMobile.getText().toString();

                dbUpd = FirebaseDatabase.getInstance().getReference("user");

                dbUpd.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        for (DataSnapshot snap : snapshot.getChildren())
                        {
                            User u1 = snap.getValue(User.class);

                            if (u1.getEmail().equals(mail))
                            {
                                dbUpd = FirebaseDatabase.getInstance().getReference("user").child(uId);

                                User upd = new User(uId,name,mobile,mail,pass);

                                dbUpd.setValue(upd);
                                Toast.makeText(getApplicationContext(),"RECORD UPDATED SUCCESSFULLY..",Toast.LENGTH_LONG).show();
                                break;
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        btUpdCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}