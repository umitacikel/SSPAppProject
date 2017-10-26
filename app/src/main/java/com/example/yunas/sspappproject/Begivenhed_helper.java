package com.example.yunas.sspappproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Begivenhed_helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="begivenhed.db";
    public static final String c_TABLE_NAME="c_begivenhed";
    public static final String c_Col_1="ID";
    public static final String c_Col_2="Emnne";
    public static final String c_Col_3="Detaljer";
    public static final String c_Col_4="Dato";
    public static final String c_Col_5="Sted";





    public Begivenhed_helper(Context context) {
        super(context, c_TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + c_TABLE_NAME + "("+ c_Col_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + c_Col_2 +" TEXT,"+ c_Col_3 +" TEXT,"+ c_Col_4 +" TEXT,"+c_Col_5 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + c_TABLE_NAME);
        onCreate(db);

    }

    public void addData(String Emne, String Detaljer, String Sted, String Dato){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(c_Col_2, Emne);
        contentValues.put(c_Col_3, Detaljer);
        contentValues.put(c_Col_4, Sted);
        contentValues.put(c_Col_5, Dato);
        db.insert(c_TABLE_NAME, null, contentValues);
    }
}
