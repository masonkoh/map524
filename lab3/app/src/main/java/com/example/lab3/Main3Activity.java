package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String tempString = intent.getStringExtra("secondExtra");

        Button homeBtn = (Button) findViewById(R.id.homeBtn);
        TextView passwordTextView = findViewById(R.id.passwordTextView);
        passwordTextView.setText("Password is " + tempString);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
