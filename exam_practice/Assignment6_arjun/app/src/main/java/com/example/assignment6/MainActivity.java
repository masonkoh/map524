package com.example.assignment6;

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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    Button startDateButton;
    String spinnerSelected = "magnitude";
    Spinner orderBySpinner;
    int day;
    int month;
    int year;
    TextView dateTextView;
    EditText numberOfEathquakesEditText;

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int dateYear, int monthOfYear, int dayOfMonth) {
            year = dateYear;
            month = monthOfYear;
            day = dayOfMonth;
            TextView textView = dateTextView;
            StringBuilder s = new StringBuilder();
            s.append(year);
            String str = "-";
            s.append(str);
            s.append(month + 1);
            s.append(str);
            s.append(day);
            textView.setText(s.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(1);
        this.month = calendar.get(2);
        this.day = calendar.get(5);
        this.dateTextView = findViewById(R.id.dateTextView);
        StringBuilder s = new StringBuilder();
        s.append(this.year);
        String str = "-";
        s.append(str);
        s.append(this.month + 1);
        s.append(str);
        s.append(this.day);
        dateTextView.setText(s.toString());
        this.startDateButton = findViewById(R.id.startDateButton);
        this.startDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        this.numberOfEathquakesEditText = findViewById(R.id.numberOfEathquakesEditText);
        this.orderBySpinner = findViewById(R.id.orderBySpinner);
        this.submitButton = findViewById(R.id.submitButton);
        ArrayAdapter<String> orderByAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"magnitude", "date"});
        orderBySpinner.setAdapter(orderByAdapter);
        orderBySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinnerSelected = "magnitude";
                    return;
                }
                spinnerSelected = "time";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("order", spinnerSelected);
                intent.putExtra("limit", numberOfEathquakesEditText.getText().toString());
                intent.putExtra("start", dateTextView.getText().toString());
                startActivity(intent);
            }
        });
    }

    public Dialog onCreateDialog(int id) {
        if (id != 0) {
            return null;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this.dateSetListener, this.year, this.month, this.day);
        return datePickerDialog;
    }

}
