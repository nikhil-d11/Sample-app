package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle extras = getIntent().getExtras();
        String text=extras.getString("title");
        Log.d("testing title",""+text);
        setTitle(text);

        Button button=findViewById(R.id.button_share_intent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "choose one"));
                startActivity(intent);
            }
        });



        Button button2=findViewById(R.id.button_open_browser);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.dream11.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button button_mainactivity=findViewById(R.id.button_mainactivity);
        button_mainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShareActivity.this,MainActivity.class);
                Random rand = new Random();
                i.putExtra("data",rand.nextInt(5000));
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
    }
}