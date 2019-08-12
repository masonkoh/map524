package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView earthquakelist_listview;
    String earthquakeAPI_string = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&limit=20&minmagnitude=6&orderby=time";
    List<String> returnArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Intent intent = getIntent();
        String intentedData1 = intent.getStringExtra("order");
        String intentedData2 = intent.getStringExtra("start");
        String intentedData3 = intent.getStringExtra("magnitude");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(earthquakeAPI_string + intentedData2 + "&limit=" + intentedData3 + "&orderby=" + intentedData1);
        this.earthquakeAPI_string = stringBuilder.toString();
        new earthquake_asynctask().execute(new String[]{this.earthquakeAPI_string});


    }

    class earthquake_asynctask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... stringurl) {
            returnArray = Utils.fetchEarthquakeData(stringurl[0]);
            return returnArray;
        }


    }


}
