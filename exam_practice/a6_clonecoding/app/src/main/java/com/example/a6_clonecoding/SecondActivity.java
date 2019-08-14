package com.example.a6_clonecoding;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    String URL_ = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=7&starttime=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String order = intent.getStringExtra("order");
        String limit = intent.getStringExtra("limit");
        String start = intent.getStringExtra("start");
        StringBuilder s = new StringBuilder();
        s.append(this.URL_);
        s.append(start);
        s.append("&limit=");
        s.append(limit);
        s.append("&orderby=");
        s.append(order);
        String URL_ = s.toString();
        QuakeAsyncTask quakeAsyncTask = new QuakeAsyncTask(this);
        quakeAsyncTask.execute(new String[]{URL_});


    }
}
