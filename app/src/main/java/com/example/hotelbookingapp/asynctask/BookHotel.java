package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.activity.BookingActivity;
import com.example.hotelbookingapp.activity.ConfirmActivity;
import com.example.hotelbookingapp.activity.ConfirmationActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class BookHotel extends AsyncTask<String,Long,Void>  {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private int result;
    private String message,startDate,endDate;
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
    private JSONArray returnData;
    @SuppressLint("StaticFieldLeak")

    public BookHotel(Context context){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
    }

    @Override
    protected Void doInBackground(String... params) {
        HashMap<String,String> sendData = new HashMap<String,String>();
        sendData.put("token",params[0]);
        sendData.put("start_date",params[1]);
        sendData.put("end_date",params[2]);
        sendData.put("total_price",params[3]);
        sendData.put("room_id",params[4]);
        String resString = Server.sendHttpRequest(Server.bookHotel, sendData, "POST");
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
            Intent confirmationActivity = new Intent(this.context, ConfirmationActivity.class);
            this.context.startActivity(confirmationActivity);
            this.activity.finishAffinity();
        }
    }
}
