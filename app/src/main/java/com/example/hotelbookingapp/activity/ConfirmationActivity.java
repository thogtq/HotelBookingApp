package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hotelbookingapp.R;

/**
 * Created by LeThien on 7/14/2020
 */
public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Button buttonDone = (Button)findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMainActivity = new Intent(ConfirmationActivity.this, MainActivity.class);
                startActivity(backMainActivity);
                finishAffinity();
            }
        });
    }
}
