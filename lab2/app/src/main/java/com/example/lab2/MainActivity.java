package com.example.lab2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button usernameBtn = (Button) findViewById(R.id.usernameBtn);
        final Button passwordBtn = (Button) findViewById(R.id.passwordBtn);
        final Button usernameAndPasswordBtn = (Button) findViewById(R.id.usernameAndPasswordBtn);

        usernameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.IDEditText);
                usernameBtn.setText(user.getText().toString());
            }
        });
        passwordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.passwordEditText);
                passwordBtn.setText(user.getText().toString());
            }
        });
        usernameAndPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user1 = (EditText) findViewById(R.id.IDEditText);
                EditText user2 = (EditText) findViewById(R.id.passwordEditText);

                usernameAndPasswordBtn.setText(user1.getText().toString() + " AND " + user2.getText().toString());
            }
        });

    }
}
