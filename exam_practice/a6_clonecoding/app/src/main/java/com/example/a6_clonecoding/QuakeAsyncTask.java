package com.example.a6_clonecoding;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

class QuakeAsyncTask extends AsyncTask<String, Void, List<String>> {
    Activity activity_;
    ListView linearLayoutListView;

    QuakeAsyncTask(Activity activity){
        this.activity_ = activity;
    }

    public List<String> doInBackground(String... stringurl){
        return Utils.fetchEarthquakeData(stringurl[0]);

    }

    public void onPostExecute(List<String> postExecuteResult){
        CustomListAdapter arrayAdapter = new CustomListAdapter(this.activity_, postExecuteResult);
        linearLayoutListView = (ListView) activity_.findViewById(R.id.earthquake_listview);
        linearLayoutListView.setAdapter(arrayAdapter);
        linearLayoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temp = view.findViewById(R.id.quakeitem_latitude_textview);
                String latitude = temp.getText().toString();
                temp = view.findViewById(R.id.quakeitem_longitude_textview);
                String longitude = temp.getText().toString();
                StringBuilder sb = new StringBuilder();
                sb.append("https://www.openstreetmap.org/?mlat=");
                sb.append(longitude);
                sb.append("&mlon=");
                sb.append(latitude);
                sb.append("#map=5/");
                sb.append(longitude);
                sb.append("/");
                sb.append(latitude);
                String URLstring = sb.toString();
                Intent intent = new Intent(activity_, WebViewActivity.class);
                intent.putExtra("URL_KEY", URLstring);
                activity_.startActivity(intent);
            }
        });
    }
}
