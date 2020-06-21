package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.example.hotelbookingapp.MainActivity;
import com.example.hotelbookingapp.Server;


import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

public class Signin extends AsyncTask<String,Long,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context,base;
    private int result;
    @SuppressLint("StaticFieldLeak")
    private EditText etUsername,etPassword;

    public Signin(Context context,EditText etUsername,EditText etPassword){
        this.etUsername = etUsername;
        this.etPassword = etPassword;
        this.context = context;
        this.result = 0;
    }
    @Override
    protected Void doInBackground(String... params) {
        try{
            HashMap<String,String> data = new HashMap<String,String>();
            data.put("username",params[0]);
            data.put("password",params[1]);
            // private EditText etUsername;
            String resString = Server.sendHttpRequest(Server.Login, data, "POST");
            if(resString.equals("")){
                this.result = -1;
            }else{
                JSONObject arrRes = new JSONObject(resString);
                if(arrRes.getString("status").equals("true") && !arrRes.getString("token").equals("") ){
                    this.result = 1;
                    Server.userToken = arrRes.getString("token");
                }else{
                    this.result = 0;
                }
            }
        }catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(this.result == 1){
            Toast.makeText(this.context,"Đăng nhập thành công !",Toast.LENGTH_LONG).show();
            Intent homeFragment =new Intent(this.context, MainActivity.class);
            this.context.startActivity(homeFragment);
            ((Activity)this.context).finishAffinity();
        }else if(this.result == 0) {
            Toast.makeText(this.context,"Sai tên đăng nhập hoặc mật khẩu !",Toast.LENGTH_LONG).show();
            this.etUsername.setText("");
            this.etPassword.setText("");
        }else{
            Toast.makeText(this.context,"Lỗi kết nối !",Toast.LENGTH_LONG).show();
            this.etUsername.setText("");
            this.etPassword.setText("");
        }
    }
}
