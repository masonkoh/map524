package com.example.lab3;

import android.content.Intent;
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

        Button usernameBtn = (Button) findViewById(R.id.usernameBtn);
        Button passwordBtn = (Button) findViewById(R.id.passwordBtn);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        final EditText IDEditText = (EditText) findViewById(R.id.IDEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        usernameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("firstExtra", IDEditText.getText().toString());
                startActivity(intent);

            }
        });
        passwordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
