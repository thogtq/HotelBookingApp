package com.example.hotelbookingapp.listHotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

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

        AnhXa();
        adapter = new ListHotelAdapter(this, R.layout.row_list_hotel, arrayHotel);
        listViewHotel.setAdapter(adapter);

    }

    private void AnhXa() {
        listViewHotel = (ListView) findViewById(R.id.listViewHotel);
        arrayHotel = new ArrayList<>();
        arrayHotel.add(new Hotel("Khách sạn A", "Vũng tàu", "400,000đ/đêm", R.drawable.ks_thuyduong));
        arrayHotel.add(new Hotel("Khách sạn B", "Vũng tàu", "500,000đ/đêm", R.drawable.ks_summer));
        arrayHotel.add(new Hotel("Khách sạn C", "Vũng tàu", "600,000đ/đêm", R.drawable.ks_phungha));
        arrayHotel.add(new Hotel("Khách sạn D", "Vũng tàu", "400,000đ/đêm", R.drawable.ks_thuyduong));
        arrayHotel.add(new Hotel("Khách sạn E", "Vũng tàu", "500,000đ/đêm", R.drawable.ks_summer));
        arrayHotel.add(new Hotel("Khách sạn E", "Vũng tàu", "600,000đ/đêm", R.drawable.ks_phungha));
    }

}
