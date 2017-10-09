package com.example.yunas.sspappproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class Registration_helper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="ID";
    public static final String COL_2="FirstName";
    public static final String COL_3="LastName";
    public static final String COL_4="Password";
    public static final String COL_5="Email";
    public static final String COL_6="Phone";



    public static final String c_DATABASE_NAME="c_register.db";
    public static final String c_TABLE_NAME="c_register";
    public static final String c_Col_1="ID";
    public static final String c_Col_2="Emnne";
    public static final String c_Col_3="Detaljer";
    public static final String c_Col_4="Dato";
    public static final String c_Col_5="Sted";


    public Registration_helper(Context context, String dbName) {super(context, dbName , null, 1);}




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL("CREATE TABLE " + c_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Emne TEXT,Detaljer TEXT,Dato TEXT,Sted TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + c_TABLE_NAME);
        onCreate(db);
    }


}
