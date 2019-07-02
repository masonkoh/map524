package com.example.lab6;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
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
        final EditText editText_marks = findViewById(R.id.edittext_marks);
        Button button_add = findViewById(R.id.button_add);
        Button button_view = findViewById(R.id.button_view);
        Button button_find = findViewById(R.id.button_find);
        Button button_delete = findViewById(R.id.button_delete);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase1.execSQL("INSERT INTO IDNameGrade VALUES('" + editText_id.getText() + "','" + editText_name.getText() + "','" + editText_marks.getText() + "');");
                Log.d("mkTag", "data adding");
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("The following student was added");
                alertDialog.setMessage("ID: " + editText_id.getText() + " Name: " + editText_name.getText() + " Marks: " + editText_marks.getText());
                // for close button
                alertDialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                editText_id.setText("");
                editText_name.setText("");
                editText_marks.setText("");
            }
        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer content = new StringBuffer();
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade", null);
                String tempTitle = "No student records";

                while (cursorSelectAll.moveToNext()) {
                    content.append("ID: " + cursorSelectAll.getString(0) + " Name: " + cursorSelectAll.getString(1) + " Marks: " + cursorSelectAll.getString(2) + ".\n");
                    tempTitle = "The following students have been added";
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(tempTitle);
                alertDialog.setMessage(content);

                alertDialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();


            }
        });

        button_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer content = new StringBuffer();
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade WHERE ID = '" + editText_id.getText() + "';", null);
                String tempTitle = "This student doesn't exists";

                while (cursorSelectAll.moveToNext()) {
                    content.append("ID: " + cursorSelectAll.getString(0) + " Name: " + cursorSelectAll.getString(1) + " Marks: " + cursorSelectAll.getString(2) + ".\n");
                    tempTitle = "Students details are as follows";
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(tempTitle);
                alertDialog.setMessage(content);
                alertDialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                editText_id.setText("");
                editText_name.setText("");
                editText_marks.setText("");
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer content = new StringBuffer();
                Cursor cursorSelectAll = sqLiteDatabase1.rawQuery("SELECT * FROM IDNameGrade WHERE ID = '" + editText_id.getText() + "';", null);
                String tempTitle = "This student deosn't exist";

                while (cursorSelectAll.moveToNext()) {
                    content.append("ID: " + cursorSelectAll.getString(0) + " Name: " + cursorSelectAll.getString(1) + " Marks: " + cursorSelectAll.getString(2) + "\n");
                    tempTitle = "The following student has been deleted";
                }


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(tempTitle);
                alertDialog.setMessage(content);
                alertDialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();

                Cursor cursorSelectDelete = sqLiteDatabase1.rawQuery("DELETE FROM IDNameGrade WHERE ID = '" + editText_id.getText() + "';", null);
                while (cursorSelectDelete.moveToNext()) {
                    content.append("ID: " + cursorSelectDelete.getString(0) + " Name: " + cursorSelectDelete.getString(1) + " Marks: " + cursorSelectDelete.getString(2) + ".\n");
                }

                editText_id.setText("");
                editText_name.setText("");
                editText_marks.setText("");
            }
        });


    }
}
