package com.example.hotelbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(3500);
                } catch (Exception e) {

                }
                finally
                {
                    Intent activitymoi=new Intent(LoadingActivity.this, SigninActivity.class);
                    startActivity(activitymoi);
                    finish();
                }
            }
        };
        bamgio.start();
    }
}