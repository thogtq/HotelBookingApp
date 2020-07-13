package com.example.hotelbookingapp.listHotel;

/**
 * Created by LeThien on 7/13/2020
 */
public class Hotel {
    private String Ten;
    private String Mota;
    private String Gia;
    private int Hinh;

    public Hotel(String ten, String mota, String gia, int hinh) {
        Ten = ten;
        Mota = mota;
        Gia = gia;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
