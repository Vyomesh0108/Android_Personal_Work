package com.example.sensorapplication;





import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener
{

    TextView tv;
    SensorManager man;
    String data="";
    float px=0,py=0,pz=0;
    float x=0,y=0,z=0;
    boolean cx=true,cy=true,cz=true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        man = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> list = man.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sen :list)
        {
            data = data+sen.getName()+"\n";
        }

        tv.setText(data);


    }

    @Override

    protected  void onResume()
    {
        super.onResume();

        //man.registerListener(this,man.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);
        // man.registerListener(this,man.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL);
        man.registerListener(this,man.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override

    protected void onPause()
    {
        super.onPause();

        man.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY)
        {
            float val = sensorEvent.values[0];

            if(val==0)
            {
                tv.setText("THE OBJECT IS CLOSED TO DEVICE "+val);
            }
            else
            {
                tv.setText("THE OBJECT IS FAR FROM DEVICE "+val);
            }
        }

        if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT)
        {
            float val = sensorEvent.values[0];

            if(val<18)
            {
                tv.setText("NINI KRI JAVANI "+val);
            }
            else if(val<200)
            {
                tv.setText("GOOD EVENING "+val);
            }
            else if(val>500)
            {
                tv.setText("ITS A DAY TIME,"+val);
            }
        }
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            px=x;
            py=y;
            pz=z;

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            if(x<(px-20) || x>(px+20))
            {
                if(cx)
                {
                    tv.setBackgroundColor(Color.RED);
                    cx=false;
                }
                else
                {
                    tv.setBackgroundColor(Color.GREEN);
                    cx=true;
                }
            }
            else if(y<(py-20) || y>(py+20))
            {
                if(cy)
                {
                    tv.setBackgroundColor(Color.BLUE);
                    cy=false;
                }
                else
                {
                    tv.setBackgroundColor(Color.YELLOW);
                    cy=true;
                }

            }
            else if(z<(pz-20) || z>(pz+20))
            {
                if(cz)
                {
                    tv.setBackgroundColor(Color.MAGENTA);
                    cz=false;
                }
                else
                {
                    tv.setBackgroundColor(Color.CYAN);
                    cz=true;
                }

            }



        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}