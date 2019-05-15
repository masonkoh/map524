package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        String tempString1 = intent.getStringExtra("firstExtra");
        String tempString2 = intent.getStringExtra("secondExtra");

        Button homeBtn = (Button) findViewById(R.id.homeBtn);
        TextView usernameIsTextView = findViewById(R.id.usernameIsTextView);
        TextView passwordTextView = findViewById(R.id.passwordTextView);
        usernameIsTextView.setText("username is " + tempString1);
        passwordTextView.setText("Password is " + tempString2);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
