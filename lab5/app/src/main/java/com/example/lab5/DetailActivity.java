package com.example.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String stringData = intent.getStringExtra("itemname");
        textView = findViewById(R.id.txt_view);
        textView.setText(stringData);

        stringData = intent.getStringExtra("imgid");
        Integer imageValue = new Integer(stringData);
        imageView = findViewById(R.id.img_view1);
        imageView.setImageResource(imageValue);
    }
}
