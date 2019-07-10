package com.example.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivityLeft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_left);

        Intent intent = getIntent();
        String stringDataName = intent.getStringExtra("itemname");
        String stringDataDept = intent.getStringExtra("itemdept");
        String stringDataYear = intent.getStringExtra("itemyear");
        TextView textViewName = findViewById(R.id.textview_name_left);
        TextView textViewDept = findViewById(R.id.textview_dept_left);
        TextView textViewYear = findViewById(R.id.textview_year_left);
        textViewName.setText(stringDataName);
        textViewDept.setText(stringDataDept);
        textViewYear.setText(stringDataYear);
    }
}
