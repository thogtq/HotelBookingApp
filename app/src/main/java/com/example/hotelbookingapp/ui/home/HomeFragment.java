package com.example.hotelbookingapp.ui.home;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.asynctask.SearchHotel;
import com.example.hotelbookingapp.listHotel.ListHotelActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class HomeFragment extends Fragment {

    protected HomeViewModel homeViewModel;
    protected Button buttonDateCheckIn;
    protected Button buttonDateCheckOut;
    protected ViewFlipper viewFlipper;
    protected  Button buttonSearch;
    private String strLocation, strStartDate,  strEndDate,  strAdultNum,strChildNum,returnMsg;
    //private JSONArray returnData;
    private AlertDialog alertDialog;
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
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

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

        buttonSearch = (Button) root.findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            //Params for buttonSearch
            @Override
            public void onClick(View v) {
                strLocation = ((EditText)root.findViewById(R.id.et_location)).getText().toString();
                strStartDate =buttonDateCheckIn.getText().toString();
                strEndDate =buttonDateCheckOut.getText().toString();
                strAdultNum =((EditText)root.findViewById(R.id.editTextAdults)).getText().toString();
                strChildNum = ((EditText)root.findViewById(R.id.editTextChidren)).getText().toString();
                //listHotelActivity.putExtra("test",teststr);
                //homeFragment.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                //homeFragment.putExtra("EXIT", true);

                //Date compare
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try{
                    Date dateStart = sdf.parse(strStartDate);
                    Date dateEnd = sdf.parse(strEndDate);
                    if (dateEnd.after(dateStart)) {
                        //Async Task
                        new SearchHotel(getContext()).execute(strLocation,strStartDate,strEndDate,strAdultNum,strChildNum);
                    }else{
                        alertDialog = new AlertDialog.Builder(Objects.requireNonNull(getContext())).create();
                        alertDialog.setTitle("Thông báo");
                        alertDialog.setMessage("Ngày đi không được nhỏ hơn ngày đến");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }catch (Exception e){}

            }
        });
        viewFlipper = (ViewFlipper) root.findViewById(R.id.viewFlipperAd);
        ActionViewFlipper();
        return root;
    }

}