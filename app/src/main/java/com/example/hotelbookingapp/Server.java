package com.example.hotelbookingapp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import org.json.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

final public class Server {
    public static String userToken = "";
<<<<<<< HEAD
    public static final String ServerName = "http://192.168.1.18/";
=======
    public static String userName ="";
    public static String userPhone = "";
    public static final String ServerName = "http://192.168.1.4/";
>>>>>>> 19920e222cf08cada92288b208a6cd99078f7526
    public static final String Login = ServerName+"api.php/?apicall=login";
    public static final String Register = ServerName+"api.php/?apicall=register";
    public static final String searchHotel = ServerName+"api.php/?apicall=search_hotel";
    public static final String roomImage = ServerName+"images/room/";
    public static final String getRoom = ServerName+"api.php/?apicall=get_room";
    public static final String bookHotel = ServerName+"api.php/?apicall=book_hotel";
    public static String sendHttpRequest(String requestURL, HashMap<String, String> postDataParams,String method){
        RequestHandler request = new RequestHandler();
        return request.sendHttpRequest(requestURL,postDataParams,method);
    }
    public Server(){

    }
}
class RequestHandler {
    String sendHttpRequest(String requestURL, HashMap<String, String> postDataParams,String method) {
        URL url;
        StringBuilder sb = new StringBuilder();
        HttpURLConnection conn;
        try {

            url = new URL(requestURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setRequestProperty("USER-AGENT","Mozilla/5.0");
            conn.setRequestProperty("ACCEPT-LANGUAGE","en-US,en;0.5");

            DataOutputStream dStream = new DataOutputStream(conn.getOutputStream());
            dStream.writeBytes(getDataString(postDataParams));
            dStream.flush();
            dStream.close();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                sb = new StringBuilder();
                String line="";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                conn.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private String getDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }
}
