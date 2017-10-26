package com.example.yunas.sspappproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class tetriz_Begivenhed_helper extends SQLiteOpenHelper {
    public static final String t_DATABASE_NAME="tetriz_begivenhed.db";
    public static final String t_TABLE_NAME="t_begivenhed";
    public static final String t_Col_1="ID";
    public static final String t_Col_2="Emnne";
    public static final String t_Col_3="Detaljer";
    public static final String t_Col_4="Dato";
    public static final String t_Col_5="Sted";



    public tetriz_Begivenhed_helper(Context context) {super(context, t_TABLE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + t_TABLE_NAME + "("+ t_Col_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + t_Col_2 +" TEXT,"+ t_Col_3 +" TEXT,"+ t_Col_4 +" TEXT,"+ t_Col_5 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + t_TABLE_NAME);
        onCreate(db);
    }


    public void tetriz_addData(String Emne, String Detaljer, String Sted, String Dato){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(t_Col_2, Emne);
        contentValues.put(t_Col_3, Detaljer);
        contentValues.put(t_Col_4, Sted);
        contentValues.put(t_Col_5, Dato);
        db.insert(t_TABLE_NAME, null, contentValues);
    }
}
