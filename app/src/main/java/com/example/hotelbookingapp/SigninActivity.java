package com.example.hotelbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView forgetPasswordText = (TextView) findViewById(R.id.forgetPassword);
        forgetPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_signup=new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(activity_signup);
                //finish();
            }
        });

        TextView dontHaveAccountText = (TextView) findViewById(R.id.dontHaveAccount);
        dontHaveAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_signup=new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(activity_signup);
                //finish();
            }
        });

        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent homeFragment =new Intent(SigninActivity.this, MainActivity.class);
                startActivity(homeFragment);
                finishAffinity();
            }
        });
    }
}