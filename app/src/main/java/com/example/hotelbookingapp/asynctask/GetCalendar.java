package com.example.hotelbookingapp.asynctask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.activity.BookingActivity;
import com.example.hotelbookingapp.activity.CancelActivity;
import com.example.hotelbookingapp.listHotel.Hotel;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelDaHuy.ListHotelDaHuyAdapter;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelHoanTat.ListHotelHoanTatAdapter;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelSapToi.ListHotelSapToiAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GetCalendar extends AsyncTask<String,Long,Void> {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private int result;
    private String message,status;
    @SuppressLint("StaticFieldLeak")
    private Activity activity;
    private JSONArray returnData;
    @SuppressLint("StaticFieldLeak")

    ListHotelHoanTatAdapter adapterDone;
    ListHotelSapToiAdapter adapterPending;
    ListHotelDaHuyAdapter adapterCanceled;

    ListView listViewHotel;
    ArrayList<Hotel> arrHotel;
    //Constructor List Pending
    public GetCalendar(Context context,ListHotelSapToiAdapter adapterPending,ListView listViewHotel){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
        this.listViewHotel = listViewHotel;
        this.adapterPending = adapterPending;
    }
    //Constructor List Done
    public GetCalendar(Context context, ListHotelHoanTatAdapter adapterDone, ListView listViewHotel){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
        this.listViewHotel = listViewHotel;
        this.adapterDone = adapterDone;
    }
    //Constructor List Canceled
    public GetCalendar(Context context, ListHotelDaHuyAdapter adapterCanceled, ListView listViewHotel){
        this.activity = (Activity) context;
        this.context = context;
        this.result = 0;
        this.message="empty";
        this.listViewHotel = listViewHotel;
        this.adapterCanceled = adapterCanceled;
    }

    @Override
    protected Void doInBackground(String... params) {
        this.status = params[0];
        HashMap<String,String> sendData = new HashMap<String,String>();
        sendData.put("status",status);
        sendData.put("token",Server.userToken);
        String resString = Server.sendHttpRequest(Server.getCalendar, sendData, "POST");
        if(resString.equals("")){
            this.result = 0;
            message = "Không thể kết nối máy chủ !";
        }else{
            JSONObject arrRes = null;
            try {
                NumberFormat myFormat = NumberFormat.getInstance();
                myFormat.setGroupingUsed(true);
                arrRes = new JSONObject(resString);
                if(arrRes.getInt("status") == 1){
                    this.result = 1;
                    this.returnData = arrRes.getJSONArray("list_hotel");
                    this.message = "Success";
                    arrHotel = new ArrayList<>();
                    //Loop
                    for(int i =0;i<this.returnData.length();i++){
                        JSONObject row = this.returnData.getJSONObject(i);
                        Hotel  temp = new Hotel(
                                row.getString("ma_phong"),
                                row.getString("ten_ks")+"\n"+row.getString("ten_phong"),
                                row.getString("ngay_den"),
                                row.getString("ngay_di"),
                                myFormat.format(row.getInt("gia_phong")),myFormat.format(row.getInt("tong_tien")) );
                        arrHotel.add(temp);
                    }
                    //End loop
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
            if(this.status.equals("pending")){
                adapterPending =new ListHotelSapToiAdapter(this.context, R.layout.row_list_hotel_sap_toi, this.arrHotel);
                listViewHotel.setAdapter(adapterPending);
                listViewHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent cancelActivity = new Intent(context, CancelActivity.class);
                        context.startActivity(cancelActivity);
                    }
                });
            }else if(this.status.equals("done")){
                adapterDone =new ListHotelHoanTatAdapter(this.context, R.layout.row_list_hotel_hoan_tat, this.arrHotel);
                listViewHotel.setAdapter(adapterDone);
            }else if(this.status.equals("canceled")){
                adapterCanceled =new ListHotelDaHuyAdapter(this.context, R.layout.row_list_hotel_da_huy, this.arrHotel);
                listViewHotel.setAdapter(adapterCanceled);
            }

        }
    }

}
