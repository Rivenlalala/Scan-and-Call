package com.riven.scanandcall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CallActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        EditText output=(EditText) findViewById(R.id.editText);
        Intent intent = getIntent();
        String text = intent.getStringExtra(OcrCaptureActivity.TextBlockObject);
        output.setText(text);
    }

    public void onCallClick(View view)
    {
        EditText output=(EditText) findViewById(R.id.editText);
        String number = output.getText().toString();
        Uri uri=Uri.parse("tel:" + number);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(uri);
        startActivity(intent);
    }

    public void onMsgClick(View view)
    {
        EditText output=(EditText) findViewById(R.id.editText);
        String number = output.getText().toString();
        String context="您好您的外卖到了";
        Uri uri=Uri.parse("smsto:" + number);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.putExtra("sms_body",context);
        intent.setType("vnd.android-dir/mms-sms");
        intent.setData(uri);
        startActivity(intent);
    }
}
