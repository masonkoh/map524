package com.example.lab7;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText_name_left = findViewById(R.id.editText_name_left);
        final EditText editText_dept_left = findViewById(R.id.editText_dept_left);
        final EditText editText_year_left = findViewById(R.id.editText_year_left);
        final EditText editText_name_right = findViewById(R.id.editText_name_right);
        final EditText editText_dept_right = findViewById(R.id.editText_dept_right);
        final EditText editText_year_right = findViewById(R.id.editText_year_right);
        final String[] itemNameLeft = new String[50];
        final String[] itemDeptLeft = new String[50];
        final String[] itemYearLeft = new String[50];
        final String[] itemNameRight = new String[50];
        final String[] itemDeptRight = new String[50];
        final String[] itemYearRight = new String[50];
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_add_left = findViewById(R.id.btn_add_left);
        Button btn_add_right = findViewById(R.id.btn_add_right);
        final SQLiteDatabase sqLiteDatabase1 = openOrCreateDatabase("L7db", Context.MODE_PRIVATE, null);
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS leftTable(name VARCHAR, dept VARCHAR, year VARCHAR);");
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS rightTable(name VARCHAR, dept VARCHAR, year VARCHAR);");

        btn_add_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO leftTable VALUES('" + editText_name_left.getText() + "', '" + editText_dept_left.getText() + "', '" + editText_year_left.getText() + "');");
                editText_name_left.setText("");
                editText_dept_left.setText("");
                editText_year_left.setText("");
            }
        });
        btn_add_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO rightTable VALUES('" + editText_name_right.getText() + "', '" + editText_dept_right.getText() + "', '" + editText_year_left.getText() + "');");
                editText_name_right.setText("");
                editText_dept_right.setText("");
                editText_year_right.setText("");
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM leftTable", null);
                int index = 0;
                while (cursorSelectAll.moveToNext()) {
                    itemNameLeft[index] = cursorSelectAll.getString(0);
                    itemDeptLeft[index] = cursorSelectAll.getString(1);
                    itemYearLeft[index] = cursorSelectAll.getString(2);
                    index++;
                }

                Cursor cursorSelectAll2 = sqLiteDatabase1.rawQuery("SELECT * FROM rightTable", null);
                int index2 = 0;
                while (cursorSelectAll2.moveToNext()) {
                    itemNameRight[index2] = cursorSelectAll2.getString(0);
                    itemNameLeft[index2] = cursorSelectAll2.getString(1);
                    itemNameLeft[index2] = cursorSelectAll2.getString(2);
                    index2++;
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("stringNameLeft", itemNameLeft);
                intent.putExtra("stringDeptLeft", itemDeptLeft);
                intent.putExtra("stringYearLeft", itemYearLeft);
                intent.putExtra("stringNameRight", itemNameRight);
                intent.putExtra("stringDeptRight", itemDeptRight);
                intent.putExtra("stringYearRight", itemYearRight);
                startActivity(intent);
            }
        });

    }
}

