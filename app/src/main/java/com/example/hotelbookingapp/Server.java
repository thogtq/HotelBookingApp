package com.example.hotelbookingapp;

public interface Server {
    public final String ServerName = "192.168.1.2/";
    public final String Login = ServerName+"api.php/?apicall=login";
    public final String Register = ServerName+"api.php/?apicall=register";
}
