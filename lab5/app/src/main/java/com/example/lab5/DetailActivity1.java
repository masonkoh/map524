package com.example.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity1 extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String stringData1 = intent.getStringExtra("itemname1");
        String stringData2 = intent.getStringExtra("itemname2");
        String integerData1 = intent.getStringExtra("imgid");
        textView = findViewById(R.id.txt_view1);
        textView.setText(stringData1);


        Integer imageValue = new Integer(integerData1);
        imageView = findViewById(R.id.img_view1);
        imageView.setImageResource(imageValue);
    }
}
