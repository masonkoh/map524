package com.example.myapplication;

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

    public static List<String> fetchEarthquakeData(String earthquakeAPI_string) {
        URL url = createURL(earthquakeAPI_string);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.d("MKLOG< E R R O R: ", "fetchEarthquakeData: ");
        }
        return extractFeatureFromJson(jsonResponse);
    }

    public static URL createURL(String earthquakeAPI_string) {
        URL url = null;
        try {
            url = new URL(earthquakeAPI_string);
        } catch (MalformedURLException e) {
            Log.d("MKLOG < E R R O R>: ", "bad url...!");
        }
        return url;
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
            Log.d("mklog", url.toString());
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            } else {
                Log.d("MKLOG <E R R O R>: ", "makeHttpRequest: " + httpURLConnection.getResponseCode());
            }
        } catch (IOException e) {
// implement later
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();

            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;

    }

    public static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output_StringBuilder = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader reader_InputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader_BufferedReader = new BufferedReader(reader_InputStreamReader);
            String line_String = reader_BufferedReader.readLine();
            while (line_String != null) {
                output_StringBuilder.append(line_String);
                line_String = reader_BufferedReader.readLine();
            }
        }
        return output_StringBuilder.toString();
    }

    private static List<String> extractFeatureFromJson(String earthquakejson_String) {
        if (TextUtils.isEmpty(earthquakejson_String)) {
            return null;
        }
        List<String> earthquake_listString = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(earthquakejson_String);
            JSONArray earthquake_jsonarray = baseJsonResponse.getJSONArray("features");
            for (int i = 0; i < earthquake_jsonarray.length(); i++) {
                JSONObject currentEarthQuake = earthquake_jsonarray.getJSONObject(i);
                JSONObject properties = currentEarthQuake.getJSONObject("properties");
                String title = properties.getString("title");
                String time = properties.getString("time");
                String url = properties.getString("url");
                earthquake_listString.add(title + "__" + time + "__" + url);
            }
            return earthquake_listString;
        } catch (JSONException e) {

        }
        return null;
    }


}
