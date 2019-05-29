package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Log.d("ㅅㅂMK_LOGCAT","arrayAlphabet:" + Arrays.toString(arrayAlphabet));
        Integer[] arrayNumber  = new Integer[99];

        for (int i = 1; i < 100; i++){
            arrayNumber[i-1] = 7 * i;
        }
        Log.d("ㅅㅂMK_LOGCAT", "arrayNumber: " + Arrays.toString(arrayNumber));

        ArrayAdapter<String>arrayAdapterAlphabet = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayAlphabet);
        ListView listViewAlphabet = findViewById(R.id.arrayAlphabetList);
        listViewAlphabet.setAdapter(arrayAdapterAlphabet);

        ArrayAdapter<Integer>arrayAdapterNumber = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arrayNumber);
        GridView gridViewNumber = findViewById(R.id.arrayNumberList);
        gridViewNumber.setAdapter(arrayAdapterNumber);

    }
}
