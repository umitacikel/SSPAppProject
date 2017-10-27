package com.example.yunas.sspappproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Opslag_helper extends SQLiteOpenHelper{
    public static final String Cops_DATABASE_NAME="c_opslag.db";
    public static final String Cops_TABLE_NAME="c_opslag";
    public static final String Cops_Col_1="ID";
    public static final String Cops_Col_2="Emnne";
    public static final String Cops_Col_3="Detaljer";

    public static final String Tops_DATABASE_NAME="t_opslag.db";
    public static final String Tops_TABLE_NAME="t_opslag";
    public static final String Tops_Col_1="ID";
    public static final String Tops_Col_2="Emnne";
    public static final String Tops_Col_3="Detaljer";




    public Opslag_helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Cops_TABLE_NAME + "("+ Cops_Col_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + Cops_Col_2 +" TEXT,"+ Cops_Col_3 + " TEXT)");
        db.execSQL("CREATE TABLE " + Tops_TABLE_NAME + "("+ Tops_Col_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + Tops_Col_2 +" TEXT,"+ Tops_Col_3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Cops_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + Tops_TABLE_NAME);
        onCreate(db);
    }


    public void addDataCops(String Emne, String Detaljer){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Cops_Col_2, Emne);
        contentValues.put(Cops_Col_3, Detaljer);

        db.insert(Cops_TABLE_NAME, null, contentValues);
    }

    public void addDataTops(String Emne, String Detaljer){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Tops_Col_2, Emne);
        contentValues.put(Tops_Col_3, Detaljer);

        db.insert(Tops_TABLE_NAME, null, contentValues);
    }
}
