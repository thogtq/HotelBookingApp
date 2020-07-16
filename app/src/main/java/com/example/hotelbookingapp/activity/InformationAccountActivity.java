package com.example.hotelbookingapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;

/**
 * Created by LeThien on 7/15/2020
 */
public class InformationAccountActivity extends AppCompatActivity {
    private EditText etHoTen,etSdt,etEmail,etSex,etBrith,etAddress,etCmnd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_account);
        etHoTen = (EditText)findViewById(R.id.et_infor_hoten);
        etSdt = (EditText)findViewById(R.id.et_infor_sdt);
        etEmail = (EditText)findViewById(R.id.et_infor_email);
        etSex = (EditText)findViewById(R.id.et_infor_gioitinh);
        etBrith = (EditText)findViewById(R.id.et_infor_ngaysinh);
        etAddress = (EditText)findViewById(R.id.et_infor_diachi);
        etCmnd = (EditText)findViewById(R.id.et_infor_CMND);

        etHoTen.setEnabled(false);
        etSdt.setEnabled(false);
        etEmail .setEnabled(false);
        etSex.setEnabled(false);
        etBrith.setEnabled(false);
        etAddress.setEnabled(false);
        etCmnd.setEnabled(false);

        etHoTen.setText(Server.userName);
       etSdt.setText(Server.userPhone);
       etEmail.setText(Server.userEmail);
       etSex.setText(Server.userSex);
       etBrith.setText(Server.userBrith);
       etAddress.setText(Server.userAddress);
       etCmnd.setText(Server.userCmnd);

    }
}
