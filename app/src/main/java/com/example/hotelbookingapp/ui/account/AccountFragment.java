package com.example.hotelbookingapp.ui.account;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.activity.InformationAccountActivity;
import com.example.hotelbookingapp.activity.UpdateInformationActivity;
import com.example.hotelbookingapp.activity.UpdatePasswordActivity;
import com.example.hotelbookingapp.ui.account.AccountViewModel;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        Button buttonInfor = root.findViewById(R.id.buttonInfor);
        Button buttonUpdateAccInfor = root.findViewById(R.id.buttonUpdateAccInfor);
        Button buttonUpdateAccPass = root.findViewById(R.id.buttonUpdateAccPass);
        buttonInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent informationActivity = new Intent(getContext(), InformationAccountActivity.class);
                startActivity(informationActivity);
            }
        });
        buttonUpdateAccInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateAccInforActivity = new Intent(getContext(), UpdateInformationActivity.class);
                startActivity(updateAccInforActivity);
            }
        });
        buttonUpdateAccPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateAccPassActivity = new Intent(getContext(), UpdatePasswordActivity.class);
                startActivity(updateAccPassActivity);
            }
        });
        /*final TextView textView = root.findViewById(R.id.text_account);
        accountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}
