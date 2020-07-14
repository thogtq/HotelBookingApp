package com.example.hotelbookingapp.listHotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hotelbookingapp.Server;
import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.asynctask.DownloadImageTask;

import java.util.List;

/**
 * Created by LeThien on 7/13/2020
 */
public class ListHotelAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hotel> hotelList;

    public ListHotelAdapter(Context context, int layout, List<Hotel> hotelList) {
        this.context = context;
        this.layout = layout;
        this.hotelList = hotelList;
    }

    @Override
    /**Trả về số dòng của listview*/
    public int getCount() {
        return hotelList.size();
    }

    @Override
    /**Không dùng */
    public Object getItem(int position) {
        return null;
    }

    @Override
    /**Không dùng */
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        //Ánh xạ convertView
        TextView txtTen= (TextView) convertView.findViewById(R.id.textViewTen);
        TextView txtMoTa= (TextView) convertView.findViewById(R.id.textViewMota);
        TextView txtGia= (TextView) convertView.findViewById(R.id.textViewGia);
        ImageView imgHinh= (ImageView) convertView.findViewById(R.id.imageViewHinh);

        //Gán giá trị
        Hotel hotel= hotelList.get(position);

        txtTen.setText(hotel.getTen());
        txtMoTa.setText(hotel.getMota());
        txtGia.setText(hotel.getGia());
        new DownloadImageTask(imgHinh).execute(hotel.getUrlHinh());
        return convertView;
    }
}

