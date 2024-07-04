package com.example.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DeleteData extends Activity
{
    Spinner spin;
    Button btDel;
    DatabaseReference dbRef;
    List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        btDel = findViewById(R.id.btDelete);
        spin = findViewById(R.id.spinner);

        dbRef = FirebaseDatabase.getInstance().getReference("user");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
               list.clear();

               for (DataSnapshot snap : snapshot.getChildren())
               {
                   User u1 = snap.getValue(User.class);

                   list.add(u1.getEmail());
               }
                ArrayAdapter<String> ad = new ArrayAdapter<String >(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                        spin.setAdapter(ad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = spin.getSelectedItem().toString();

                Query q = dbRef.orderByChild("email").equalTo(mail);

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot snap : snapshot.getChildren())
                        {
                            snap.getRef().removeValue();
                        }

                        Toast.makeText(getApplicationContext(),"DELETED SUCCESSFULLY",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}