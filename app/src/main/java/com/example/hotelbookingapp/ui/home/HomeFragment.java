package com.example.hotelbookingapp.ui.home;

import android.app.DatePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.hotelbookingapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeFragment extends Fragment {

    protected HomeViewModel homeViewModel;
    protected Button buttonDateCheckIn;
    protected Button buttonDateCheckOut;
    protected ViewFlipper viewFlipper;

    private void DateChoose(final Button buttonDate){
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        final int month = calendar.get(Calendar.MONTH);
        final int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yearOfChoose, int monthOfChoose, int dayOfChoose) {
                calendar.set(yearOfChoose,monthOfChoose, dayOfChoose);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                buttonDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }
    private void ActionViewFlipper(){

        ImageView imageView2= new ImageView(getContext());
        imageView2.setImageResource(R.drawable.ad_02);
        //imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(imageView2);

        ImageView imageView3 = new ImageView(getContext());
        imageView3.setImageResource(R.drawable.ad_03);
        //imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(imageView3);

        //ImageView imageView4 = new ImageView(getContext());
        //imageView4.setImageResource(R.drawable.ad_04);
        //imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
        //viewFlipper.addView(imageView4);

        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }
 public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        buttonDateCheckIn=(Button) root.findViewById(R.id.buttonDateCheckIn);
        buttonDateCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateChoose(buttonDateCheckIn);
            }
        });

        buttonDateCheckOut=(Button) root.findViewById(R.id.buttonDateCheckOut);
        buttonDateCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateChoose(buttonDateCheckOut);
            }
        });
        //final TextView textView = root.findViewById(R.id.text_home);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        viewFlipper = (ViewFlipper) root.findViewById(R.id.viewFlipperAd);
        ActionViewFlipper();
        return root;
    }

}