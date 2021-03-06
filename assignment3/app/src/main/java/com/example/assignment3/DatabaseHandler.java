package com.example.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {/**/
    public DatabaseHandler(Context context) {
        super(context, "mkTempName", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("CREATE TABLE items (id INTEGER PRIMARY KEY, name0 TEXT, name1 TEXT, name2 TEXT, name3 TEXT, name4 TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db2);
    }

    public void insertItem(String itemCity, String itemName, String itemSport, String itemMvp, String itemStadium) {
        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name0", itemCity);
        values.put("name1", itemName);
        values.put("name2", itemSport);
        values.put("name3", itemMvp);
        values.put("name4", itemStadium);
        db3.insert("items", null, values);
        db3.close();
    }

    public List<String> getAllItems0() {
        List<String> listItem = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                listItem.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db4.close();
        return listItem;
    }

    public List<String> getAllItems1() {
        List<String> listItem = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                listItem.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db4.close();
        return listItem;
    }


    public List<String> getAllItems2() {
        List<String> listItem = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                listItem.add(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db4.close();
        return listItem;
    }

    public List<String> getAllItems3() {
        List<String> listItem = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                listItem.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db4.close();
        return listItem;
    }

    public List<String> getAllItems4() {
        List<String> listItem = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                listItem.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db4.close();
        return listItem;
    }


}
