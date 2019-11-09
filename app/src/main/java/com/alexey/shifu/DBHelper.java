package com.alexey.shifu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "my_database";
    public static final String TABLE_NAME = "my_table";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FIRST_VOLUMES TEXT," +
                "SECOND_VOLUMES TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(String firstValue, String secondValue) {
        ContentValues cv = new ContentValues();
        cv.put("FIRST_VOLUMES", firstValue);
        cv.put("SECOND_VOLUMES", secondValue);

        this.getWritableDatabase().insert(TABLE_NAME, null, cv);
    }

    public String getFirstValue(int index) {
        Cursor cursor = this.getWritableDatabase().query(DBHelper.TABLE_NAME, null,
                "_id = ?", new String[] {index+""},
                null,null, null);
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndexOrThrow("FIRST_VOLUMES"));
        } else {
            return null;
        }
    }

    public String getSecondValue(int index) {
        Cursor cursor = this.getWritableDatabase().query(DBHelper.TABLE_NAME, null,
                "_id = ?", new String[] {index+""},
                null,null, null);
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndexOrThrow("SECOND_VOLUMES"));
        } else {
            return null;
        }
    }
}
