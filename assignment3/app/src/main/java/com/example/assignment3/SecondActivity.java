package com.example.assignment3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText city_editText = findViewById(R.id.city_editText);
        final EditText name_editText = findViewById(R.id.name_editText);
        final EditText sport_editText = findViewById(R.id.sport_editText);
        final EditText mvp_editText = findViewById(R.id.mvp_editText);
        final EditText stadium_editText = findViewById(R.id.stadium_editText);
        Button submit_btn = findViewById(R.id.submit_btn);
        Button exit_btn = findViewById(R.id.exit_btn);
        Button update_btn = findViewById(R.id.update_btn);
        Button delete_btn = findViewById(R.id.delete_btn);
        LinearLayout upper_linearlayout = findViewById(R.id.upper_linearlayout);
        LinearLayout lower_linearlayout = findViewById(R.id.lower_linearlayout);

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler databaseHandler2 = new DatabaseHandler(getApplicationContext());
                String item0 = city_editText.getText().toString();
                String item1 = name_editText.getText().toString();
                String item2 = sport_editText.getText().toString();
                String item3 = mvp_editText.getText().toString();
                String item4 = stadium_editText.getText().toString();
                if (item0.length() != 0 && item1.length() != 0) {
                    databaseHandler2.insertItem(item0, item1, item2, item3, item4);
                    city_editText.setText("");
                    name_editText.setText("");
                    sport_editText.setText("");
                    mvp_editText.setText("");
                    stadium_editText.setText("");
                } else if (item0.length() == 0 || item1.length() == 0) {
                    Toast.makeText(getApplicationContext(), "City and Name are required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = getIntent();
        String stringData0 = intent.getStringExtra("itemname0");
        String stringData1 = intent.getStringExtra("itemname1");
        String stringData2 = intent.getStringExtra("itemname2");
        String stringData3 = intent.getStringExtra("itemname3");
        String stringData4 = intent.getStringExtra("itemname4");
        String stringDataCommand = intent.getStringExtra("command");
        TextView textView0 = findViewById(R.id.city_editText);
        TextView textView1 = findViewById(R.id.name_editText);
        TextView textView2 = findViewById(R.id.sport_editText);
        TextView textView3 = findViewById(R.id.mvp_editText);
        TextView textView4 = findViewById(R.id.stadium_editText);
        textView0.setText(stringData0);
        textView1.setText(stringData1);
        textView2.setText(stringData2);
        textView3.setText(stringData3);
        textView4.setText(stringData4);

        if (stringDataCommand.equals("add")) {
            delete_btn.setVisibility(View.GONE);
            update_btn.setVisibility(View.GONE);
        }
        if (stringDataCommand.equals("ud")) {
            submit_btn.setVisibility(View.GONE);
            delete_btn.setEnabled(false);
            update_btn.setEnabled(false);
            upper_linearlayout.setBackgroundColor(Color.parseColor("#FF423D"));
            lower_linearlayout.setBackgroundColor(Color.parseColor("#AB62CE"));
        }


    }
}
