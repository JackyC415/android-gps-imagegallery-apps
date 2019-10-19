package com.jackyzchen.cmpe277_lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBController extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "order.db";

    private static final String TABLE_REGISTRATION = "registration_table";
    private static final String TABLE = "test_table";

    private static final String R_PID = "r_pid";
    private static final String R_USERNAME = "r_username";
    private static final String R_PASSWORD = "r_password";
    private static final String R_EMAIL = "r_email";

    public DBController(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL("create table " + TABLE_REGISTRATION + " (r_pid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, r_username TEXT UNIQUE, r_password TEXT NOT NULL, r_email TEXT UNIQUE)");
            Log.d("TAG", "Table Created Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);
        onCreate(sqLiteDatabase);
        Log.d("TAG", "Table Dropped Successfully!");
    }


    public void insertRegistration(RegisterField register) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(R_USERNAME, register.getUsername());
        values.put(R_PASSWORD, register.getPassword());
        values.put(R_EMAIL, register.getEmail());

        sqLiteDatabase.insert(TABLE_REGISTRATION, null, values);
        Log.d("TAG", "User Registered Successfully!");
        sqLiteDatabase.close();
    }

    public String authenticate(String input) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select R_USERNAME, R_PASSWORD from " + TABLE_REGISTRATION, null);
        String username, password = "";
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                if (username.equals(input)) {
                    password = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return password;
    }
}
