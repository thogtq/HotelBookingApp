package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelSapToi.SapToiFragment;

/**
 * Created by LeThien on 7/15/2020
 */
public class CancelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        Button cancelButton = (Button) findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeFragment = new Intent(CancelActivity.this, MainActivity.class);
                startActivity(homeFragment);
                finishAffinity();
            }
        });
    }
}
