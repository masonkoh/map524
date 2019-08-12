package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText NumOfEarthquake_edittext;
    Spinner order_spinner;
    Button startdate_button;
    TextView startdate_textview;
    Button submit_button;
    String selectedSpinner_string;
    final int datePicker = 0;
    int day, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumOfEarthquake_edittext = findViewById(R.id.NumOfEarthquake_edittext);
        order_spinner = findViewById(R.id.order_spinner);
        startdate_button = findViewById(R.id.startdate_btn);
        startdate_textview = findViewById(R.id.startdate_textview);
        submit_button = findViewById(R.id.submit_btn);

        // variables for calendar(time) beginning
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year + "-" + (month + 1) + "-" + day);
        startdate_textview.setText(stringBuilder.toString());
        order_spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.asList(new String[]{"magnitude", "date"})));

        startdate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        order_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    selectedSpinner_string = "magnitude";
                    return;
                }
                selectedSpinner_string = "time";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("order", selectedSpinner_string);
                intent.putExtra("magnitude", NumOfEarthquake_edittext.getText().toString());
                intent.putExtra("start", startdate_textview.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case datePicker:
                return new DatePickerDialog(this, pickerListener, year, month, day);
        }
        return null;
    }

    DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int yearPar, int monthPar, int dayPar) {
            year = yearPar;
            month = monthPar;
            day = dayPar;
            startdate_textview.setText(year + "-" + (month + 1) + "-" + day);
        }
    };
}
