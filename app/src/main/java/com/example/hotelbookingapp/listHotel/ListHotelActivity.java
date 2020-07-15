package com.example.hotelbookingapp.listHotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.activity.BookingActivity;
import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.asynctask.GetRoom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LeThien on 7/13/2020
 */
public class ListHotelActivity extends AppCompatActivity {
    ListView listViewHotel;
    ArrayList<Hotel> arrayHotel;
    ListHotelAdapter adapter;
    private JSONArray listHotel;
    private String startDate,endDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotel);

        //Get data from main activity
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
          try{
              this.listHotel = new JSONArray(extras.getString("listHotel"));
              this.startDate =extras.getString("startDate");
              this.endDate = extras.getString("endDate");
              AnhXa();
              adapter = new ListHotelAdapter(this, R.layout.row_list_hotel, arrayHotel);
              listViewHotel.setAdapter(adapter);
              listViewHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      Hotel tempHotel =arrayHotel.get(position);
                      new GetRoom(ListHotelActivity.this).execute(tempHotel.getMaPhong(),startDate,endDate);
                      //position trả về vị trí click ->0
                  }
              });
          }catch (Exception e){}
            //The key argument here must match that used in the other activity
        }
    }
    private void AnhXa() throws JSONException {
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        listViewHotel = (ListView) findViewById(R.id.listViewHotel);
        arrayHotel = new ArrayList<>();
        for(int i =0;i<listHotel.length();i++){
            JSONObject row = listHotel.getJSONObject(i);
            arrayHotel.add(new Hotel(row.getString("ma_phong"),
                    row.getString("ten_ks")+"\n"+row.getString("ten_phong"),
                    "Loại giường: "+row.getString("loai_giuong")+"\nDiện tích : "+row.getInt("dien_tich")+"m2\n"+row.getString("ten"),
                    myFormat.format(row.getInt("gia_phong"))+"VNĐ/đêm"));
        }
    }

}
