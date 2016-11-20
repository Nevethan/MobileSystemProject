package com.example.bruger.mobilesystemproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nevethan on 20-11-2016.
 */

public class DatabaseManager extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, password TEXT NOT NULL)";

    SQLiteDatabase db;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = "DROP TABLE IF EXITS " + TABLE_NAME;
        db.execSQL(q);
        this.onCreate(db);
    }

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void insert(User user) {
        db = this.getWritableDatabase();

        String q = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(q, null);

        int count = cursor.getCount();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,count);
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }


    public String searchDb(String username) {
        db = this.getReadableDatabase();
        String q = "SELECT username, password FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(q, null);

        String user, pass;

        pass = " ";

        if (cursor.moveToFirst()) {

            do {
                user = cursor.getString(0);


                if (user.equals(username)) {
                    pass = cursor.getString(1);
                    break;
                }
            }

            while (cursor.moveToNext());
        }
        return pass;
    }

}
