package com.example.audioactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btStart,btStop,btPause;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStart = findViewById(R.id.btStart);
        btPause = findViewById(R.id.btPause);
        btStop = findViewById(R.id.btStop);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.audio);

        btStart.setOnClickListener(this);
        btPause.setOnClickListener(this);
        btStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btStart:
                mediaPlayer.start();
                break;

            case R.id.btPause:
                mediaPlayer.pause();
                break;

            case R.id.btStop:
                mediaPlayer.stop();
                break;
        }
    }
}