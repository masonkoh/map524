package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*

Objective - become familiar with Java and XML
The user first types a username and password
The user then clicks on one of the buttons
The button text will change, based on the username and /or password

*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button loginBtn = (Button) findViewById(R.id.loginBtn);
//
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                EditText loginEditText = (EditText) findViewById(R.id.loginEditText);
//                Toast.makeText(getApplicationContext(), "Username: ", Toast.LENGTH_SHORT).show();
//
//
////                loginBtn.setText(loginEditText.getText().toString()); // just inclass note
//            }
//        });
    }
}
