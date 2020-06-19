package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.example.hotelbookingapp.MainActivity;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.SigninActivity;
import com.example.hotelbookingapp.SignupActivity;

import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Signin extends AsyncTask<String,Long,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context,base;
    private boolean result;
    public Signin(Context context){
        this.context = context;
        this.result = false;
    }
    @Override
    protected Void doInBackground(String... params) {
        try{
            HashMap<String,String> data = new HashMap<String,String>();
            data.put("username",params[0]);
            data.put("password",params[1]);
            // private EditText etUsername;
            JSONObject arrRes = new JSONObject(Server.sendHttpRequest(Server.Login, data, "POST"));
            if(arrRes.getString("status").equals("true")){
                this.result=true;
            }else{
                this.result = false;
            }
        }catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(this.result){
            Toast.makeText(this.context,"Đăng nhập thành công !",Toast.LENGTH_LONG).show();
            Intent homeFragment =new Intent(this.context, MainActivity.class);
            this.context.startActivity(homeFragment);
        }else {
            Toast.makeText(this.context,"Sai tên đăng nhập hoặc mật khẩu !",Toast.LENGTH_LONG).show();
           try{ Thread.sleep(1000);}catch (Exception e){}
            this.context.startActivity(new Intent(this.context,SigninActivity.class));
        }
    }
}
