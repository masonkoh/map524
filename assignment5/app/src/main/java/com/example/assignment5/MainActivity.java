package com.example.assignment5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView earthquakelist_listview;
    String earthquakeAPI_string = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&limit=20&minmagnitude=6&orderby=time";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        earthquake_asynctask task = new earthquake_asynctask();
        task.execute(earthquakeAPI_string);

    }

    // https://stackoverflow.com/questions/9671546/asynctask-android-example
    class earthquake_asynctask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected List<String> doInBackground(String... earthquakeAPI_string) {
            return Utils.fetchEarthquakeData(earthquakeAPI_string[0]);
        }

        public void onPostExecute(List<String> postExecuteResult) {
            CustomListAdapter arrayAdapter = new CustomListAdapter(MainActivity.this, postExecuteResult);

            earthquakelist_listview = findViewById(R.id.earthquakelist_listview);
            earthquakelist_listview.setAdapter(arrayAdapter);
            earthquakelist_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

        }
    }

    class CustomListAdapter extends ArrayAdapter<String> {
        Activity context;
        List<String> itemname1;

        public CustomListAdapter(Activity activity, List<String> itemnameA) {
            super(activity, R.layout.earthquake_listdetail, itemnameA);
            this.context = activity;
            this.itemname1 = itemnameA;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.earthquake_listdetail, null, true);
            String earthInfo[] = itemname1.get(position).split("@@");
            TextView textInfo1 = rowView.findViewById(R.id.listdetail1_textview);
            textInfo1.setText(earthInfo[0]);
            TextView textInfo2 = rowView.findViewById(R.id.listdetail2_textview);
            textInfo2.setText(new Date(Long.parseLong(earthInfo[1])).toString());


            if (position % 2 == 0) {
                textInfo1.setBackgroundColor(Color.parseColor("#98CE00"));
            }
            if (position % 2 == 0) {
                textInfo2.setBackgroundColor(Color.parseColor("#98CE00"));
            }




            return rowView;

        }
    }

}
