package com.example.customgridactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gvName;
    int[] image={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.horse,R.drawable.linux,R.drawable.bmw_};
    String[] name={"This is Deer","This is Dog","This is Elephant","This is Horse","This is Linux","This is BMW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvName=findViewById(R.id.gvName);

        MyAdapter1 myAdapter1 = new MyAdapter1(image,name,MainActivity.this);
        gvName.setAdapter(myAdapter1);

        gvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,GridDataActivity.class);
                intent.putExtra("T1",name[position]);
                intent.putExtra("I1",image[position]);
                startActivity(intent);
            }
        });
    }
}