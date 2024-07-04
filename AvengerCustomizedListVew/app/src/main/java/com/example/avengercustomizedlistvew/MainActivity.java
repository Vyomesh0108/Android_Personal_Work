package com.example.avengercustomizedlistvew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    ListView lv;
    Avenger avg;
    List<Avenger> list = new ArrayList<Avenger>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        list.add(new Avenger(R.drawable.caption2, "Caption America", "Shield;"));
        list.add(new Avenger(R.drawable.ironman,"Iron Man","Armour"));
        list.add(new Avenger(R.drawable.hulk,"hulk","Power"));
        list.add(new Avenger(R.drawable.thor,"Thor","Storm Breaker"));
        list.add(new Avenger(R.drawable.spidy,"Spider","Web"));
        list.add(new Avenger(R.drawable.panther,"Black Panther","Vibranium"));
        list.add(new Avenger(R.drawable.black,"Black Window","Karate"));
        list.add(new Avenger(R.drawable.witch,"Wanda","Magic"));
        list.add(new Avenger(R.drawable.ant,"Ant Man","Nano Techo"));
        list.add(new Avenger(R.drawable.marvel,"Captain Marvel","Binary Ignintion"));
        list.add(new Avenger(R.drawable.strange,"hawk","Arrow"));
        list.add(new Avenger(R.drawable.hawkeye,"Wanda","Magic"));

        CustomAdapter ca = new CustomAdapter(this,R.layout.customziedlistview,list);
        lv.setAdapter(ca);

    }
}