package com.example.hotelbookingapp.ui.calendar.tab.listHotelHoanTat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelbookingapp.R;
import com.example.hotelbookingapp.asynctask.DownloadImageTask;
import com.example.hotelbookingapp.listHotel.Hotel;

import java.util.List;

/**
 * Created by LeThien on 7/14/2020
 */
public class ListHotelHoanTatAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hotel> hotelList;

    public ListHotelHoanTatAdapter(Context context, int layout, List<Hotel> hotelList) {
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
        TextView txtTen= (TextView) convertView.findViewById(R.id.textViewTenListHotelHoanTat);
        TextView txtMoTa= (TextView) convertView.findViewById(R.id.textViewMotaListHotelHoanTat);
        TextView txtThanhTien= (TextView) convertView.findViewById(R.id.textViewThanhTienListHotelHoanTat);
        ImageView imgHinh= (ImageView) convertView.findViewById(R.id.imageViewHinhListHotelHoanTat);

        //Gán giá trị
        Hotel hotel= hotelList.get(position);

        txtTen.setText(hotel.getTen());
        txtMoTa.setText("Từ "+hotel.getNgayDen()+" đến "+hotel.getNgayDi());
        txtThanhTien.setText(hotel.getTongGia());
        new DownloadImageTask(imgHinh).execute(hotel.getUrlHinh());

        return convertView;
    }
}


