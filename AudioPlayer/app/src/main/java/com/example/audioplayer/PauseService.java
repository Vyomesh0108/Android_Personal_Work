package com.example.audioplayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PauseService extends Service
{
    GlobalClass gc;

    @Override
    public int onStartCommand(Intent data,int sid,int flag)
    {
        gc = (GlobalClass)getApplication();

        gc.mp.pause();

        return START_NOT_STICKY;
        //return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
