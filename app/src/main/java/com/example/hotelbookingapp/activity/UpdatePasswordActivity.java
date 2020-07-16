package com.example.hotelbookingapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.UpdateInfo;
import com.example.hotelbookingapp.asynctask.UpdatePassword;

/**
 * Created by LeThien on 7/15/2020
 */
public class UpdatePasswordActivity extends AppCompatActivity {
    EditText etUsername,etPassword,etPasswordConf;
    String strUsername,strPassword,strPasswordConf;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        etUsername = (EditText)findViewById(R.id.et_update_username) ;
        etPassword = (EditText)findViewById(R.id.et_update_new_password) ;
        etPasswordConf = (EditText)findViewById(R.id.et_update_conf_password) ;

        Button updateBtn = (Button)findViewById(R.id.buttonUpdatePass);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strUsername = etUsername.getText().toString();
                strPassword = etPassword.getText().toString();
                strPasswordConf = etPasswordConf.getText().toString();
                new UpdatePassword(UpdatePasswordActivity.this).execute(Server.userToken,strUsername,strPassword,strPasswordConf);
            }
        });
    }
}
