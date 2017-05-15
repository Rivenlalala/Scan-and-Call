package com.riven.scanandcall;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.vision.text.TextRecognizer;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                 ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
             }
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 2);
        }
    }

    public void onCameraClick(View view)
    {
        Intent intent = new Intent(this,OcrCaptureActivity.class);
        startActivity(intent);
    }

    public void onSettingClick(View view)
    {
        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
}
