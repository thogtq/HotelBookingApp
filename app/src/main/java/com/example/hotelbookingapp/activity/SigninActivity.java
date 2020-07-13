package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.asynctask.Signin;

public class SigninActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
         final EditText etUsername = (EditText)findViewById(R.id.editTextUsername);
         final EditText etPassword = (EditText)findViewById(R.id.editTextPassword);
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
                Signin signin = new Signin(SigninActivity.this,etUsername,etPassword);
                signin.execute(etUsername.getText().toString(),etPassword.getText().toString());
                //finishAffinity();
            }
        });
    }
}