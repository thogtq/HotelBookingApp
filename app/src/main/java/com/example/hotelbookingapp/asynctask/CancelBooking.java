package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.activity.CancelActivity;
import com.example.hotelbookingapp.activity.ConfirmationActivity;
import com.example.hotelbookingapp.activity.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class CancelBooking extends AsyncTask<String,Long,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private int result;
    private String message,token,maDp;
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
    @SuppressLint("StaticFieldLeak")

    public CancelBooking(Context context){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
    }

    @Override
    protected Void doInBackground(String... params) {
        HashMap<String,String> sendData = new HashMap<String,String>();
        sendData.put("token",params[0]);
        sendData.put("maDp",params[1]);
        String resString = Server.sendHttpRequest(Server.cancelBooking, sendData, "POST");
        if(resString.equals("")){
            this.result = 0;
            message = "Không thể kết nối máy chủ !";
        }else{
            JSONObject arrRes = null;
            try {
                arrRes = new JSONObject(resString);
                if(arrRes.getInt("status") == 1){
                    this.result = 1;
                    this.message = "Success";
                }else{
                    result = 0;
                    message = arrRes.getString("message");
                }
            } catch (Exception e) {

            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(this.result == 0){
            AlertDialog alertDialog = new AlertDialog.Builder(Objects.requireNonNull(this.context)).create();
            alertDialog.setTitle("Thông báo lỗi");
            alertDialog.setMessage(message);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(Objects.requireNonNull(this.context)).create();
            alertDialog.setTitle("Thông báo");
            alertDialog.setMessage("Huỷ thành công !");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Intent homeFragment = new Intent(context, MainActivity.class);
            context.startActivity(homeFragment);
            activity.finishAffinity();
        }
    }
}
