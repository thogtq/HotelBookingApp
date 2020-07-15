package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hotelbookingapp.R;

/**
 * Created by LeThien on 7/16/2020
 */
public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView textViewHaveAcc = (TextView) findViewById(R.id.forgotAlreadyHaveAccount);
        textViewHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinActivity = new Intent(ForgotPasswordActivity.this, SigninActivity.class);
                startActivity(signinActivity);
                finishAffinity();
            }
        });
    }
}
