package com.example.hotelbookingapp.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.CancelBooking;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelSapToi.SapToiFragment;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by LeThien on 7/15/2020
 */
public class CancelActivity extends AppCompatActivity {
    private String name,price,startDate,endDate,totalPrice,maDp;
    private EditText etHoten,etSdt,etStartDate,etEndDate,etTongTien,etDonGia,etName;
    private NumberFormat myFormat = NumberFormat.getInstance();
    private SimpleDateFormat df;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        etHoten = (EditText)findViewById(R.id.editTextTenKhachHangCancel) ;
        etSdt = (EditText)findViewById(R.id.editTextSdtCancel) ;
        etStartDate = (EditText)findViewById(R.id.editTextDateInCancel) ;
        etEndDate = (EditText)findViewById(R.id.editTextDateOutCancel) ;
        etTongTien = (EditText)findViewById(R.id.editTextThanhTienCancel) ;
        etDonGia = (EditText)findViewById(R.id.editTextDonGiaCancel) ;
        etName = (EditText)findViewById(R.id.editTextTenHotelCancel) ;
        Button cancelButton = (Button) findViewById(R.id.buttonCancel);

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try{
                this.startDate = extras.getString("ngayDen");
                this.endDate = extras.getString("ngayDi");
                this.name = extras.getString("tenKs");
                this.price = extras.getString("donGia");
                this.maDp = extras.getString("maDp");
                this.totalPrice =extras.getString("tongTien");
            }catch (Exception e){}
        }
        etHoten.setText(Server.userName);
        etSdt.setText(Server.userPhone);
        etName.setText(name);
        etDonGia.setText(price);
        etStartDate.setText(startDate);
        etEndDate.setText(endDate);
        etTongTien.setText(totalPrice);
        etHoten.setEnabled(false);
        etSdt.setEnabled(false);
        etName.setEnabled(false);
        etDonGia.setEnabled(false);
        etStartDate.setEnabled(false);
        etEndDate.setEnabled(false);
        etTongTien.setEnabled(false);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(CancelActivity.this).create();
                alertDialog.setTitle("Yêu cầu xác nhận");
                alertDialog.setMessage("Bạn thực sự muốn huỷ đơn đặt phòng này ?");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                new CancelBooking(CancelActivity.this).execute(Server.userToken,maDp);
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }
}
