package com.example.hotelbookingapp.listHotel;

import android.annotation.SuppressLint;

import com.example.hotelbookingapp.Server;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * Created by LeThien on 7/13/2020
 */
public class Hotel {
    private String maPhong;
    private String Ten;
    private String Mota;
    private String Gia;
    private int Hinh;
    private String urlHinh;
    private String TongGia,ngayDen,ngayDi;
    public Hotel(String maPhong, String ten, String ngayDen, String ngayDi, String Gia , String TongGia) {
        this.maPhong = maPhong;
        Ten = ten;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.TongGia = TongGia;
        this.Gia = Gia;
        this.urlHinh = Server.roomImage+this.maPhong+".jpg";
    }
    public Hotel(String maPhong,String ten, String mota, String gia) {
        this.maPhong = maPhong;
        Ten = ten;
        Mota = mota;
        Gia = gia;
        this.urlHinh = Server.roomImage+this.maPhong+".jpg";
    }
    public Hotel(String maPhong,String ten, String mota, String gia,int Hinh) {
        this.maPhong = maPhong;
        Ten = ten;
        Mota = mota;
        Gia = gia;
        Hinh =Hinh;
    }
    public Hotel(String ten, String mota, String gia,int Hinh) {
        this.maPhong = maPhong;
        Ten = ten;
        Mota = mota;
        Gia = gia;
        Hinh =Hinh;
    }
    public String getMaPhong() {
        return this.maPhong;
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

    public String getUrlHinh() {
        return urlHinh;
    }
    public int getHinh() {
        return Hinh;
    }
    public void setHinh(int hinh) {
        Hinh = hinh;
    }
    public void setTongGia (String TongGia){
        this.TongGia = TongGia;
    }
    public String getTongGia (){
        return this.TongGia;
    }
    public String getNgayDen (){
       return this.ngayDen;
    }
    public String getNgayDi (){
        return this.ngayDi;
    }
}
