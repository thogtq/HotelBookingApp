package com.example.hotelbookingapp;
import android.util.Log;

import org.json.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
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
    public static String UserToken = "";
    public static final String ServerName = "http://192.168.1.2/";
    public static final String Login = ServerName+"api.php/?apicall=login";
    public static final String Register = ServerName+"api.php/?apicall=register";
    public static String sendHttpRequest(String requestURL, HashMap<String, String> postDataParams,String method){
        RequestHandler request = new RequestHandler();
        return request.sendHttpRequest(requestURL,postDataParams,method);
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
            }else {
                conn.disconnect();
                return "HTTP_ERROR";
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
