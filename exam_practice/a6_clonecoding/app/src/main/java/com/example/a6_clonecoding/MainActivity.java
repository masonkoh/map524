package com.example.a6_clonecoding;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    String TAG = "MKLOG";

    Button submit_button;
    Button StartDate_button;

    // about spinner
    Spinner orderby_spinner;
    String spinnerSelected = "magnitude";

    EditText numberOfEarthquakes_edittext;
    TextView date_textview;
    int day, month, year;


    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int _year, int _month, int _dayOfMonth) {
            year = _year;
            month = _month;
            day = _dayOfMonth;
            TextView textView = date_textview;
            StringBuilder s = new StringBuilder();
            s.append(year);
            String str = "-";
            s.append(str);
            s.append(month +1);
            s.append(str);
            s.append(day);
            textView.setText(s.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.StartDate_button = findViewById(R.id.StartDate_button);
        this.numberOfEarthquakes_edittext = findViewById(R.id.numberOfEarthquakes_edittext);
        this.orderby_spinner = findViewById(R.id.orderby_spinner);
        this.submit_button = findViewById(R.id.submit_button);

        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DATE);
        this.date_textview = findViewById(R.id.date_textview);
        StringBuilder s = new StringBuilder();
        s.append(this.year);
        String str = "-";
        s.append(str);
        s.append(this.month + 1);
        s.append(str);
        s.append(this.day);
        date_textview.setText(s.toString());

        // this button.setonclicklistener will not work without 'public Dialog onCreateDialog' and 'DatePickerDialog.OnDateSetListener' setup!

        this.StartDate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        // making 'arrayAdapter' for the spinner!
        ArrayAdapter<String> orderByAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"magnitude", "date"});
        orderby_spinner.setAdapter(orderByAdapter);
        orderby_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
//                    spinnerSelected = "magnitude";
                    return;
                }
                spinnerSelected = "time";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("order", spinnerSelected);
                intent.putExtra("limit", numberOfEarthquakes_edittext.getText().toString());
                intent.putExtra("start", date_textview.getText().toString());
                startActivity(intent);
            }
        });



    }


    public Dialog onCreateDialog(int id){
        if(id != 0){
            return null;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this.dateSetListener, this.year, this.month, this.day);
        return datePickerDialog;
    }
}
