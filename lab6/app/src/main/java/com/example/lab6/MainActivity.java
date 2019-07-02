package com.example.lab6;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
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

        final SQLiteDatabase sqLiteDatabase1 = openOrCreateDatabase("IDNameGrade", Context.MODE_PRIVATE, null);
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS IDNameGrade(ID VARCHAR, Name VARCHAR, GRADE VARCHAR);");
        Log.d("mkTag", "SQL(sqLiteDatabase1) created!!!!@#!@#");
        final EditText editText_id = findViewById(R.id.edittext_id);
        final EditText editText_name = findViewById(R.id.edittext_name);
        final EditText edittext_marks = findViewById(R.id.edittext_marks);
        Button button_add = findViewById(R.id.button_add);
        Button button_view = findViewById(R.id.button_view);
        Button button_find = findViewById(R.id.button_find);
        Button button_delete = findViewById(R.id.button_delete);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO IDNameGrade VALUES('"+ editText_id.getText() + "','"+ editText_name.getText() + "','"+edittext_marks.getText()+"');");
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("The following student was added");
                alertDialog.setMessage("ID: " + editText_id.getText() + " Name: " + editText_name.getText() + " Marks: " + edittext_marks.getText());
                // for close button
                alertDialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                editText_id.setText("");
                editText_name.setText("");
                edittext_marks.setText("");
            }
        });
    }
}
