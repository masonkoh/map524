package com.example.assignment3;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, "spinnerExample", null, 1);
        // mknote: why is name "spinnerExample"?
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

    public void insertItem(String itemA, String itemB, String itemC, String itemD, String itemE) {
        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name0", itemA);
        values.put("name1", itemB);
        values.put("name2", itemC);
        values.put("name3", itemD);
        values.put("name4", itemE);
        db3.insert("items", null, values);
        db3.close();
    }

    public List<String> getAllItems0(){
        List<String> listItem2 = new ArrayList<>();
        String selectQuery = "SELECT * FROM items";
        SQLiteDatabase db4 = this.getReadableDatabase();
        Cursor cursor = db4.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{

            }
        }
    }



}
