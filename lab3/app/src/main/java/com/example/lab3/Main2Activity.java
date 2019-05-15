package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String tempString = intent.getStringExtra("firstExtra");

        Button homeBtn = (Button) findViewById(R.id.homeBtn);
        TextView usernameIsTextView = findViewById(R.id.usernameIsTextView);
        usernameIsTextView.setText("username is " + tempString);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
