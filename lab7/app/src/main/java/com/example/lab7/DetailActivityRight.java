package com.example.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivityRight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_right);

        Intent intent = getIntent();
        String stringDataName = intent.getStringExtra("itemname2");
        String stringDataDept = intent.getStringExtra("itemdept2");
        String stringDataYear = intent.getStringExtra("itemyear2");
        TextView textViewName = findViewById(R.id.textview_name_right);
        TextView textViewDept = findViewById(R.id.textview_dept_right);
        TextView textViewYear = findViewById(R.id.textview_year_right);
        textViewName.setText(stringDataName);
        textViewDept.setText(stringDataDept);
        textViewYear.setText(stringDataYear);
    }
}
