package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelbookingapp.activity.MainActivity;
import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

public class Signup extends AsyncTask<String,Long,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
    private int result;
    private String message;

    public Signup(Context context){
        this.context = context;
        this.activity = (Activity)context;
        this.result = 0;
        this.message = "";
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(this.context,"Đang xử lý thông tin...",Toast.LENGTH_LONG).show();
    }
    @Override
    protected Void doInBackground(String... params) {
        try{
            HashMap<String,String> data = new HashMap<String,String>();
            data.put("ho_ten",params[0]);
            data.put("username",params[1]);
            data.put("email",params[2]);
            data.put("sdt",params[3]);
            data.put("password",params[4]);
            if(!params[4].equals(params[5])){
                this.result = 0;
                this.message = "Mật khẩu không khớp";
                return null;
            }
                String resString = Server.sendHttpRequest(Server.Register, data, "POST");
           if(resString.equals("")){
                this.result = -1;
            }else{
                JSONObject arrRes = new JSONObject(resString);
                if(arrRes.getString("status").equals("true")){
                    this.result = 1;
                    HashMap<String,String> data_login = new HashMap<String,String>();
                    data_login.put("username",params[1]);
                    data_login.put("password",params[4]);
                    JSONObject resob =new JSONObject(Server.sendHttpRequest(Server.Login, data_login, "POST"));
                    Server.userToken = resob.getString("token");
                    Server.userName = arrRes.getJSONObject("user_data").getString("HO_TEN");
                    Server.userPhone = arrRes.getJSONObject("user_data").getString("SDT");
                }else{
                    this.result = 0;
                    this.message = arrRes.getString("message");
                }
            }
        }catch (Exception e){}
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(this.result == 1){
            AlertDialog alertDialog = new AlertDialog.Builder(this.context).create();
            alertDialog.setTitle("Thông báo");
            alertDialog.setMessage("Đăng kí thành công !");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Intent homeFragment =new Intent(this.context, MainActivity.class);
            this.context.startActivity(homeFragment);
            this.activity.finishAffinity();
        }else if(this.result == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this.context).create();
            alertDialog.setTitle("Thông báo");
            alertDialog.setMessage(this.message);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            EditText etPassword = (EditText)activity.findViewById(R.id.et_signup_password);
            etPassword.setText("");
            EditText etConfPassword = (EditText)activity.findViewById(R.id.et_signup_conf_password);
            etConfPassword.setText("");
            EditText etUsername = (EditText)activity.findViewById(R.id.et_signup_username);
            etUsername.setText("");
        }else{
            Toast.makeText(this.context,"Lỗi kết nối !",Toast.LENGTH_LONG).show();
        }
    }
}
