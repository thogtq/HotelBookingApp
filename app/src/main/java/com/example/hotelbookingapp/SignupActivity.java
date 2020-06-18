package com.example.hotelbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView alreadyHaveAccountText = (TextView) findViewById(R.id.alreadyHaveAccount);
        alreadyHaveAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent activity_login=new Intent(SignupActivity.this, SigninActivity.class);
                //activity_login.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(activity_login);
                finishAffinity();
            }
        });

        Button buttonContinue = (Button) findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeFragment=new Intent(SignupActivity.this, MainActivity.class);
                //homeFragment.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                //homeFragment.putExtra("EXIT", true);
                startActivity(homeFragment);
                finishAffinity();

            }
        });
    }
}