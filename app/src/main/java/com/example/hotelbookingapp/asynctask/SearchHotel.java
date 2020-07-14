package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.activity.MainActivity;
import com.example.hotelbookingapp.listHotel.ListHotelActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class SearchHotel extends AsyncTask <String,Long,Void>{
    @SuppressLint("StaticFieldLeak")
    private Context context,base;
    private int result;
    private String message;
    private Activity activity;
    private JSONArray returnData;
    @SuppressLint("StaticFieldLeak")

    public SearchHotel(Context context){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
    }
    @Override
    protected Void doInBackground(String... params) {

        //Prepare data to send to server
        HashMap<String,String> sendData = new HashMap<String,String>();
        sendData.put("loc",params[0]);
        sendData.put("start_date",params[1]);
        sendData.put("end_date",params[2]);
        sendData.put("adult_num",params[3]);
        sendData.put("child_num",params[4]);
        //Send data and get server res
        String resString = Server.sendHttpRequest(Server.searchHotel, sendData, "POST");
        if(resString.equals("")){
            this.result = 0;
            message = "Không thể kết nối máy chủ !";
        }else{
            JSONObject arrRes = null;
            try {
                arrRes = new JSONObject(resString);
                if(arrRes.getInt("status") == 1){
                    this.result = 1;
                    this.returnData = arrRes.getJSONArray("list_data");
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
            Intent listHotelActivity=new Intent(this.activity, ListHotelActivity.class);
            listHotelActivity.putExtra("listHotel",returnData.toString());
            context.startActivity(listHotelActivity);
        }
    }
}
