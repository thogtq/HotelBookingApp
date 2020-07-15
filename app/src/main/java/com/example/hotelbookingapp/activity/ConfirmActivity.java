package com.example.hotelbookingapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.BookHotel;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by LeThien on 7/14/2020
 */
public class ConfirmActivity extends AppCompatActivity {
    private String name,price,startDate,endDate,totalPrice,roomId;
    private EditText etHoten,etSdt,etStartDate,etEndDate,etTongTien,etDonGia,etName;
    private NumberFormat myFormat = NumberFormat.getInstance();
    private SimpleDateFormat df;
    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        etHoten = (EditText)findViewById(R.id.editTextTenKhachHangCancel) ;
        etSdt = (EditText)findViewById(R.id.editTextSdtCancel) ;
        etStartDate = (EditText)findViewById(R.id.editTextDateInCancel) ;
        etEndDate = (EditText)findViewById(R.id.editTextDateOutCancel) ;
        etTongTien = (EditText)findViewById(R.id.editTextThanhTienCancel) ;
        etDonGia = (EditText)findViewById(R.id.editTextDonGiaCancel) ;
        etName = (EditText)findViewById(R.id.editTextTenHotelCancel) ;
        df = new SimpleDateFormat("dd/MM/yyyy");
        Bundle extras = getIntent().getExtras();
        myFormat.setGroupingUsed(true);
        if (extras != null) {
           try{
               this.startDate = extras.getString("startDate");
               this.endDate = extras.getString("endDate");
               this.name = extras.getString("name");
               this.price = extras.getString("price");
               this.roomId = extras.getString("roomId");
               long msDiff = df.parse(this.endDate).getTime() - df.parse(this.startDate).getTime();
               long daysDiff = TimeUnit.DAYS.convert(msDiff, TimeUnit.MILLISECONDS);
               this.totalPrice =String.valueOf((daysDiff*Integer.parseInt(Objects.requireNonNull(extras.getString("price")))));
           }catch (Exception e){}

        }
        Button buttonConfirm = (Button)findViewById(R.id.buttonCancel);

        etHoten.setText(Server.userName);
        etSdt.setText(Server.userPhone);
        etName.setText(this.name);
        etDonGia.setText(myFormat.format(Integer.parseInt(Objects.requireNonNull(this.price)))+" VND/Đêm");
        etStartDate.setText(this.startDate);
        etEndDate.setText(this.endDate);
        etTongTien.setText(myFormat.format(Integer.parseInt(totalPrice)));

        etHoten.setEnabled(false);
        etSdt.setEnabled(false);
        etName.setEnabled(false);
        etDonGia.setEnabled(false);
        etStartDate.setEnabled(false);
        etEndDate.setEnabled(false);
        etTongTien.setEnabled(false);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new BookHotel(ConfirmActivity.this).execute(Server.userToken,startDate,endDate,totalPrice,roomId);
            }
        });
    }
}
