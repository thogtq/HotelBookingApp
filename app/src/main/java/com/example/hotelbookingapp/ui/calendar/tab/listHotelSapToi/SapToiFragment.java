package com.example.hotelbookingapp.ui.calendar.tab.listHotelSapToi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.activity.CancelActivity;
import com.example.hotelbookingapp.listHotel.Hotel;
import com.example.hotelbookingapp.listHotel.ListHotelAdapter;
import com.example.hotelbookingapp.ui.calendar.tab.listHotelSapToi.ListHotelSapToiAdapter;

import java.util.ArrayList;

public class SapToiFragment extends Fragment {
    View root;
    ListView listViewHotel;
    ArrayList<Hotel> arrayHotel;
    ListHotelSapToiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_calendar_sap_toi,container,false);
        listViewHotel = root.findViewById(R.id.listViewHotelSapToi);
        AnhXa();
        adapter = new ListHotelSapToiAdapter(getContext(), R.layout.row_list_hotel_sap_toi, arrayHotel);
        listViewHotel.setAdapter(adapter);
        listViewHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent cancelActivity = new Intent(getContext(), CancelActivity.class);
                startActivity(cancelActivity);
            }
        });
        return root;
    }
    private void AnhXa() {
        arrayHotel = new ArrayList<>();
        arrayHotel.add(new Hotel("Khách sạn A", "13/07/2020 - 16/07/2020", "1,200,000đ", R.drawable.ks_thuyduong));

    }
}
