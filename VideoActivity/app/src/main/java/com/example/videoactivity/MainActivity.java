package com.example.videoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoV = findViewById(R.id.videoV);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoV);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.lion);

        videoV.setMediaController(mediaController);

        videoV.setVideoURI(uri);

        videoV.requestFocus();
        videoV.start();

        videoV.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Thank you...", Toast.LENGTH_SHORT).show();
            }
        });

        videoV.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}