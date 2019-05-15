package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button usernameBtn = (Button) findViewById(R.id.usernameBtn);
        Button passwordBtn = (Button) findViewById(R.id.passwordBtn);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        
    }
}
