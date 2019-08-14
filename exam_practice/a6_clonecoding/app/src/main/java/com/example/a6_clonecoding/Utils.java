package com.example.a6_clonecoding;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Utils {

    public static List<String> fetchEarthquakeData(String requestUrl) {
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(createUrl(requestUrl));
        } catch (IOException e) {
            Log.e("loge", "Error closing input stream", e);
        }
        return extractFeatureFromJson(jsonResponse);
    }

    private static URL createUrl(String stringUrl) {
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {

            }
        }catch (IOException e ){

        }finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            if(inputStream != null){
                inputStream.close();
            }
            return jsonResponse;
        }
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<String> extractFeatureFromJson(String earthquakeJSON) {
        String SEPARATOR = "@@";
        if (TextUtils.isEmpty(earthquakeJSON)) {
            return null;
        }
        List<String> quakeList = new ArrayList<>();
        try {
            JSONArray arr = new JSONObject(earthquakeJSON).getJSONArray("features");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject eQuake = arr.getJSONObject(i);
                JSONObject properties = eQuake.getJSONObject("properties");
                String title = properties.getString("title");
                String magnitude = properties.getString("mag");
                String time = properties.getString("time");
                String url = properties.getString("url");
                JSONArray coordinates = eQuake.getJSONObject("geometry").getJSONArray("coordinates");
                String latitude = coordinates.getString(0);
                String lng = coordinates.getString(1);
                StringBuilder sb = new StringBuilder();
                sb.append(title);
                sb.append(SEPARATOR);
                sb.append(time);
                sb.append(SEPARATOR);
                sb.append(url);
                sb.append(SEPARATOR);
                sb.append(latitude);
                sb.append(SEPARATOR);
                sb.append(lng);
                sb.append(SEPARATOR);
                sb.append(magnitude);
                quakeList.add(sb.toString());
            }
            return quakeList;
        } catch (JSONException e) {
            return null;
        }
    }


}
