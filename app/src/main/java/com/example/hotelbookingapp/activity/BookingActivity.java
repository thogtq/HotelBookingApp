package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.DownloadImageTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Created by LeThien on 7/14/2020
 */
public class BookingActivity extends AppCompatActivity {
    private TextView tvTenKsPhong,tvThongTinKs,tvMoTa,tvGia,tvPhong;
    private ImageView imgRoom;
    private JSONObject roomInfo;
    private NumberFormat myFormat = NumberFormat.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        tvTenKsPhong = (TextView) findViewById(R.id.textViewTenBooking);
        tvThongTinKs = (TextView) findViewById(R.id.textViewDiaChiBooking);
        tvMoTa = (TextView) findViewById(R.id.textViewMoTaBooking);
        tvGia = (TextView) findViewById(R.id.textViewGiaBooking);
        tvPhong = (TextView) findViewById(R.id.tv_roomInfo);
        imgRoom = (ImageView) findViewById(R.id.imageViewHinhBooking);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                myFormat.setGroupingUsed(true);
               JSONArray jsonarrRoom = new JSONArray(extras.getString("roomInfo"));
                roomInfo = jsonarrRoom.getJSONObject(0);
                String strTenKsPhong = roomInfo.getString("TEN_KS") + "\n" + roomInfo.getString("TEN_PHONG");
                String strTTKS = "Địa chỉ: " + roomInfo.getString("DIA_CHI") + "\nSĐT: " + roomInfo.getString("SDT");
                String strMoTaVaChinhSach = roomInfo.getString("CHINH_SACH") + "\n" + roomInfo.getString("MO_TA");
                String strGia = "Giá : " + myFormat.format(roomInfo.getInt("GIA_PHONG")) + "VNĐ/Đêm";
                String strPhong = "Loại giường :" + roomInfo.getString("LOAI_GIUONG") + "\nDiện tích: " + roomInfo.getString("DIEN_TICH") + "m2";
                tvTenKsPhong.setText(strTenKsPhong);
                tvThongTinKs.setText(strTTKS);
                tvMoTa.setText(strMoTaVaChinhSach);
                tvPhong.setText(strPhong);
                tvGia.setText(strGia);
                new DownloadImageTask(imgRoom).execute(Server.roomImage + roomInfo.getString("MA_PHONG") + ".jpg");
            } catch (Exception e) {
            }
            Button buttonBooking = (Button) findViewById(R.id.buttonBooking);
            buttonBooking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent confirmActivity = new Intent(BookingActivity.this, ConfirmActivity.class);
                    startActivity(confirmActivity);
                }
            });
        }
    }
}
