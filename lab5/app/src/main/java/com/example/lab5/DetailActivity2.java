package com.example.lab5;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Intent intent = getIntent();
        String stringData1 = intent.getStringExtra("itemname1");
        String stringData2 = intent.getStringExtra("itemname2");
        String stringData3 = intent.getStringExtra("itemname3");
        String integerData = intent.getStringExtra("imgid");
        Integer imageValue = Integer.valueOf(integerData);

        TextView textview1 = findViewById(R.id.textview1_rightside);
        TextView textview2 = findViewById(R.id.textview2_rightside);
        TextView textview3 = findViewById(R.id.textview3_rightside);
        ImageView imageView = findViewById(R.id.imageview_rightside);


        textview1.setText(stringData1);
        textview2.setText(stringData2);
        textview3.setText(stringData3);
        imageView.setImageResource(imageValue);

    }
}
