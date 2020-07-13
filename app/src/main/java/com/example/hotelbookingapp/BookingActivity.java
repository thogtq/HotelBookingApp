package com.example.hotelbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by LeThien on 7/14/2020
 */
public class BookingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Button buttonBooking = (Button) findViewById(R.id.buttonBooking);
        buttonBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmActivity = new Intent(BookingActivity.this, ConfirmActivity.class);
                startActivity(confirmActivity);
            }
        });
    }
}
