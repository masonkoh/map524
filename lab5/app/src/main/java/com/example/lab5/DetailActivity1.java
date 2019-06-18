package com.example.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity1 extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        Intent intent = getIntent();
        String stringData1 = intent.getStringExtra("itemname1");
        String stringData2 = intent.getStringExtra("itemname2");
        String integerData1 = intent.getStringExtra("imgid");
        textView1 = findViewById(R.id.txt_view1);
        textView2 = findViewById(R.id.txt_view2);
        textView1.setText(stringData1);
        textView2.setText(stringData2);

        Integer imageValue = new Integer(integerData1);
        imageView = findViewById(R.id.img_view1);
        imageView.setImageResource(imageValue);
    }/**/
}
