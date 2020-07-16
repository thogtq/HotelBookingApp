package com.example.hotelbookingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.UpdateInfo;

/**
 * Created by LeThien on 7/15/2020
 */
public class UpdateInformationActivity extends AppCompatActivity {
    private EditText etHoTen,etSdt,etEmail,etSex,etBrith,etAddress,etCmnd;
    private String strHoTen,strSdt,strEmail,strSex,strBrith,strAddress,strCmnd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);
        etHoTen = (EditText)findViewById(R.id.et_update_infor_hoten);
        etSdt = (EditText)findViewById(R.id.et_update_infor_sdt);
        etEmail = (EditText)findViewById(R.id.et_update_infor_email);
        etSex = (EditText)findViewById(R.id.et_update_infor_gioitinh);
        etBrith = (EditText)findViewById(R.id.et_update_infor_ngaysinh);
        etAddress = (EditText)findViewById(R.id.et_update_infor_diachi);
        etCmnd = (EditText)findViewById(R.id.et_update_infor_CMND);

        etHoTen.setEnabled(true);
        etSdt.setEnabled(true);
        etEmail .setEnabled(true);
        etSex.setEnabled(true);
        etBrith.setEnabled(true);
        etAddress.setEnabled(true);
        etCmnd.setEnabled(true);

        etHoTen.setText(Server.userName);
        etSdt.setText(Server.userPhone);
        etEmail.setText(Server.userEmail);
        etSex.setText(Server.userSex);
        etBrith.setText(Server.userBrith);
        etAddress.setText(Server.userAddress);
        etCmnd.setText(Server.userCmnd);

        Button updateBtn = (Button)findViewById(R.id.buttonUpdateInfor);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strHoTen = etHoTen.getText().toString();
                strSdt = etSdt.getText().toString();
                strEmail = etEmail.getText().toString();
                strBrith = etBrith.getText().toString();
                strAddress = etAddress.getText().toString();
                strCmnd = etCmnd.getText().toString();
                strSex = etSex.getText().toString();
                new UpdateInfo(UpdateInformationActivity.this).execute(Server.userToken,strHoTen,strCmnd,strEmail,strSdt,strSex,strBrith,strAddress);
            }
        });
    }
}
