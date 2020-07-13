package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.asynctask.Signup;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText etHoTen = (EditText)findViewById(R.id.et_signup_hoten);
        final EditText etUsername = (EditText)findViewById(R.id.et_signup_username);
        final EditText etEmail = (EditText)findViewById(R.id.et_signup_email);
        final EditText etSdt = (EditText)findViewById(R.id.et_signup_phone);
        final EditText etPassword = (EditText)findViewById(R.id.et_signup_password);
        final EditText etConfPassword = (EditText)findViewById(R.id.et_signup_conf_password);
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
                //homeFragment.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                //homeFragment.putExtra("EXIT", true);
                new Signup(SignupActivity.this).execute(
                        etHoTen.getText().toString(), //0
                        etUsername.getText().toString(),//1
                        etEmail.getText().toString(),//2
                        etSdt.getText().toString(),//3
                        etPassword.getText().toString(),//4
                        etConfPassword.getText().toString()//5
                );

            }
        });
    }
}