package com.example.hotelbookingapp.listHotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotelbookingapp.activity.BookingActivity;
import com.example.hotelbookingapp.R;

import java.util.ArrayList;

/**
 * Created by LeThien on 7/13/2020
 */
public class ListHotelActivity extends AppCompatActivity {
    ListView listViewHotel;
    ArrayList<Hotel> arrayHotel;
    ListHotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotel);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("test");
            //The key argument here must match that used in the other activity
            Toast toast = Toast.makeText(getApplicationContext(),
                    value,
                    Toast.LENGTH_SHORT);

            toast.show();
        }

        AnhXa();
        adapter = new ListHotelAdapter(this, R.layout.row_list_hotel, arrayHotel);
        listViewHotel.setAdapter(adapter);
        listViewHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position trả về vị trí click ->0
                Intent bookingActivity = new Intent(ListHotelActivity.this, BookingActivity.class);
                startActivity(bookingActivity);
            }
        });

    }

    private void AnhXa() {
        listViewHotel = (ListView) findViewById(R.id.listViewHotel);
        arrayHotel = new ArrayList<>();
        arrayHotel.add(new Hotel("Bình Minh Hotel \n Phòng Deluxe Premium", "Loại giường: 2 giường đôi \nDiện tích : 36m2\nVũng tàu", "400,000đ/đêm", R.drawable.ks_thuyduong));
        arrayHotel.add(new Hotel("Khách sạn B", "Vũng tàu", "500,000đ/đêm", R.drawable.ks_summer));
        arrayHotel.add(new Hotel("Khách sạn C", "Vũng tàu", "600,000đ/đêm", R.drawable.ks_phungha));
        arrayHotel.add(new Hotel("Khách sạn D", "Vũng tàu", "400,000đ/đêm", R.drawable.ks_thuyduong));
        arrayHotel.add(new Hotel("Khách sạn E", "Vũng tàu", "500,000đ/đêm", R.drawable.ks_summer));
        arrayHotel.add(new Hotel("Khách sạn E", "Vũng tàu", "600,000đ/đêm", R.drawable.ks_phungha));
    }

}
