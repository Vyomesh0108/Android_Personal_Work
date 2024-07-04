package com.example.texttospeechproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener
{
    EditText et;
    Button b1,b2;
    TextView tv;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        tv = findViewById(R.id.tv);

        tts = new TextToSpeech(getApplicationContext(),this);

        tts.setSpeechRate(.7f);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = et.getText().toString();


                if(msg.equals(""))
                {
                    tts.speak("ENTER MESSAGE FIRST",TextToSpeech.QUEUE_ADD,null,null);
                }
                else
                {
                    tts.speak(msg,TextToSpeech.QUEUE_ADD,null,null);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);  //THIS IS TO CALL GOOGLE SPEECH API
                ii.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                // startActivity(ii); THIS IS USED TO LEAVE CURRENT ACTIVITY PERMANTELTY AND DOESNT RETURN BACK WITH RESULT
                startActivityForResult(ii,121);  //result lai ne pachu aau hoi to aa use thay
            }
        });
    }

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data)
    {
        if(reqCode==121 && resCode==RESULT_OK)
        {
            ArrayList<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String speech="";

            int i;
            for(i=0; i<list.size();i++)
            {
                speech = speech +list.get(i)+"\n";
            }

            tv.setText(speech);

            if(speech.indexOf("open browser")!=-1)
            {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yahoo.com"));
                startActivity(i1);
            }
            else if (speech.indexOf("open YouTube")!=-1)
            {
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(i2);
            }
            else if(speech.indexOf("call vyomesh")!=-1)
            {
                Intent i3 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"7990413172"));
                startActivity(i3);
            }
        }

    }


    @Override
    public void onInit(int i) {

    }
}