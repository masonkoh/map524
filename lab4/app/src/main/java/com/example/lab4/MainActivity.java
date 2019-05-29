package com.example.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Integer[] arrayNumber = new Integer[99];
        for (int i = 1; i < 100; i++) {
            arrayNumber[i - 1] = 7 * i;
        }
        Log.d("MK_LOGCAT", "arrayAlphabet:" + Arrays.toString(arrayAlphabet));
        Log.d("MK_LOGCAT", "arrayNumber: " + Arrays.toString(arrayNumber));

        ArrayAdapter<String> arrayAdapterAlphabet = new ArrayAdapter<>(this, R.layout.mk_custom_layout1, arrayAlphabet);
        ListView listViewAlphabet = findViewById(R.id.arrayAlphabetList);
        listViewAlphabet.setAdapter(arrayAdapterAlphabet);

        ArrayAdapter<Integer> arrayAdapterNumber = new ArrayAdapter<>(this, R.layout.mk_custom_layout2, arrayNumber);
        GridView gridViewNumber = findViewById(R.id.arrayNumberList);
        gridViewNumber.setAdapter(arrayAdapterNumber);

    }
}
