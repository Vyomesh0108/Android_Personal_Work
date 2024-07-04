package com.example.audioplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity
{
    ImageButton btpl,btpa,btop,btst;
    TextView tv;
    SeekBar sb;
   // MediaPlayer mp=null;
    GlobalClass gc;
    int duration = 0;
    boolean finish=false;
    boolean pausefinish=false;
    int current =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //it doesn't create object but it returns object by android at the time application starts
        gc = (GlobalClass)getApplication();

        tv = findViewById(R.id.tv);
        sb = findViewById(R.id.sb);

        btop = findViewById(R.id.btop);
        btpa = findViewById(R.id.btpa);
        btpl = findViewById(R.id.btpl);
        btst = findViewById(R.id.btst);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                current = sb.getProgress();
                current = current*1000;
                gc.mp.seekTo(current);
                tv.setText(""+current+"/"+duration);

            }
        });

        btpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gc.mp!=null) {
                    gc.mp.start();
                    pausefinish=false;
                }
            }
        });

        btpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gc.mp!=null)
                {
                    gc.mp.pause();
                    pausefinish=true;
                }
            }
        });

        btst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gc.mp!=null)
                {
                    gc.mp.stop();
                    finish=true;
                    pausefinish=true;
                    gc.mp=null;
                    sb.setProgress(0);
                    duration=0;
                    current=0;
                    tv.setText("0/0");
                }
            }
        });

        btop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(Intent.ACTION_GET_CONTENT); //USE TO FETCH ANY TYPE OF CONTENT FILE FROM CLIENTS DEVICE
                ii.setType("audio/*");  //ii.setType("video/*")  //ii.setType("image/*")""
                startActivityForResult(Intent.createChooser(ii,"SELECT YOUR SONG"),151);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityResult(int reqCode,int result,Intent data)
    {
        if(reqCode==151 && result == RESULT_OK)
        {
            Uri uri = data.getData();  //Uri is used to store location for given content
            gc.mp = MediaPlayer.create(getApplicationContext(),uri);
            gc.mp.start();

            duration = gc.mp.getDuration();
            duration= duration/ 1000; //to convert millisec to seconds
            sb.setMax(duration);
            tv.setText("0/"+duration);

            finish = false;
            pausefinish = false;

            notifyMe(uri);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(!finish)
                    {
                        try{Thread.sleep(1000); }
                        catch(Exception e) { }

                        if(!pausefinish)
                        {
                            current = gc.mp.getCurrentPosition();
                            current = current / 1000;
                            sb.setProgress(current);

                            tv.post(new Runnable() {
                                @Override
                                public void run() {

                                    tv.setText(""+current+"/"+duration);

                                }
                            });

                            if(current>duration)
                            {
                                pausefinish =true;
                                finish = true;
                                duration = 0;
                                current =0;
                                sb.setProgress(0);
                                gc.mp=null;

                                tv.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        tv.setText("0/0");

                                    }


                                });
                            }
                        }
                    }

                }
            }).start();


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void notifyMe(Uri uri)
    {
        String path = uri.getPath();
        int p = path.lastIndexOf("/");
        String song =path.substring(p+1);

        //used to create channel for notification with unquie id
        NotificationChannel channel = new NotificationChannel("1001","AUDIO", NotificationManager.IMPORTANCE_HIGH);

        //used to create intent for activity  but to call later so keep it pending
        Intent i1 = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi1 = PendingIntent.getActivity(this,0,i1,0);

        Intent i2 = new Intent(getApplicationContext(),PauseService.class);
        PendingIntent pi2 = PendingIntent.getService(this,0,i2,0);

        //used to build view for notification
        NotificationCompat.Builder not = new NotificationCompat.Builder(getApplicationContext(),"1001")
                .setContentTitle(song)
                .setContentText("FAVOURITE SONGS")
                .setSmallIcon(R.drawable.play)
                .setContentIntent(pi1)
                .addAction(android.R.drawable.ic_media_pause,"Pause",pi2);

        NotificationManager manage =  getSystemService(NotificationManager.class);

        manage.createNotificationChannel(channel);

        manage.notify(123,not.build());

    }
}