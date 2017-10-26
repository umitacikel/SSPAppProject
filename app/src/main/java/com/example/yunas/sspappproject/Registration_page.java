package com.example.yunas.sspappproject;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Registration_page extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _Reg_Button;
    EditText _FirstName, _LastName, _Password, _Email, _Phone;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        openHelper = new Registration_helper(getApplicationContext());
        _Reg_Button =(Button)findViewById(R.id.Reg_Button);
        _FirstName =(EditText)findViewById(R.id.FirstName);
        _LastName=(EditText)findViewById(R.id.LastName);
        _Password=(EditText)findViewById(R.id.Password);
        _Email= (EditText)findViewById(R.id.Email);
        _Phone = (EditText)findViewById(R.id.Phone);

        _Reg_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();

                String fName = _FirstName.getText().toString();
                String lName = _LastName.getText().toString();
                String pass = _Password.getText().toString();
                String Email = _Email.getText().toString();
                String Phone = _Phone.getText().toString();

                if(fName.length() != 2 || lName.length() != 2 || pass.equals("") || Email.equals("") || Phone.length() != 6){
                    Toast.makeText(getApplicationContext(), "Venligst udfyld alle felter", Toast.LENGTH_LONG).show();
                }else {
                    InsertData(fName, lName, pass, Email, Phone);
                }
            }
        });


    }

    public void InsertData(String fName, String lName, String pass, String Email, String Phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Registration_helper.COL_2, fName);
        contentValues.put(Registration_helper.COL_3, lName);
        contentValues.put(Registration_helper.COL_4, pass);
        contentValues.put(Registration_helper.COL_5, Email);
        contentValues.put(Registration_helper.COL_6, Phone);

        cursor = db.rawQuery("SELECT * FROM " + Registration_helper.TABLE_NAME +" WHERE Email = '" + Email + "'", null);

        if(cursor.getCount()==0){
            db.insert(Registration_helper.TABLE_NAME, null, contentValues);

            Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
            Intent gotoLogin = new Intent(this, Login_Activity.class);
            startActivity(gotoLogin);

        }else{
            Toast.makeText(getApplication(),"Fejl, Email findes allerede", Toast.LENGTH_LONG).show();
        }

    }


}

