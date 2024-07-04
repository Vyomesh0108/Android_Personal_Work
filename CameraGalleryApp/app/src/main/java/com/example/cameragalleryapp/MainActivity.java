package com.example.cameragalleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    ImageView iv;
    Button btCam,btGal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imgView);
        btCam = findViewById(R.id.btCapture);
        btGal = findViewById(R.id.btGallery);

        btCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i1,121);

            }
        });

        btGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i2,151);

            }
        });

    }

    @Override
    protected void onActivityResult(int reqCode,int resCode,Intent data)
    {
        if(reqCode==121)
        {
            if(resCode == RESULT_OK)
            {
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(bmp);
            }
        }
        else if(reqCode==151)
        {
            if(resCode==RESULT_OK)
            {
                Bitmap bmp = null;

                try
                {
                    bmp = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(),data.getData());
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"DIDN'T PICK THE IMAGE",Toast.LENGTH_LONG).show();
                }

                iv.setImageBitmap(bmp);

            }
        }
    }
}