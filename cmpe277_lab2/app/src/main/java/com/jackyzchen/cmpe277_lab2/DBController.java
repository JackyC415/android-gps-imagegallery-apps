package com.jackyzchen.cmpe277_lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBController extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OrderNow";

    private static final String TABLE_REGISTRATION = "registration_table";

    private static final String R_PID = "registration_pid";
    private static final String R_USERNAME = "registration_username";
    private static final String R_PASSWORD = "registration_password";
    private static final String R_EMAIL = "registration_email";

    public DBController(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL("create table " + TABLE_REGISTRATION + " (R_PID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, R_USERNAME TEXT UNIQUE, R_PASSWORD TEXT NOT NULL, R_EMAIL TEXT UNIQUE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.d("TAG", "Tables Created Successfully!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRATION);
        onCreate(sqLiteDatabase);
        Log.d("TAG", "Tables Dropped Successfully!!!");
    }


    public void insertRegistration(RegisterField register) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(R_USERNAME, register.getUsername());
        values.put(R_PASSWORD, register.getPassword());
        values.put(R_EMAIL, register.getEmail());

        sqLiteDatabase.insert(TABLE_REGISTRATION, null, values);
        Log.d("TAG", "Registration Data Inserted Successfully!!!");
        sqLiteDatabase.close();
    }
}
