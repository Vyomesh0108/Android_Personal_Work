package com.example.firebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowData extends Activity
{
    ListView lv;
    DatabaseReference dbref;
    ArrayList<User> userlist = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        lv = findViewById(R.id.lv);

        dbref = FirebaseDatabase.getInstance().getReference("user");

        dbref.addValueEventListener(new ValueEventListener() {
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
}