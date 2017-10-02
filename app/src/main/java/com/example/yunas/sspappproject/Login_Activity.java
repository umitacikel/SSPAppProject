package com.example.yunas.sspappproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity {


    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Cursor cursor2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);


        openHelper = new Registration_helper(getApplicationContext());
        db = openHelper.getReadableDatabase();

        final ArrayList<String> bruger = new ArrayList<>();


        final Button _Login_Btn = (Button)findViewById(R.id.Login_Btn);
        final TextView _Login_Email = (EditText)findViewById(R.id.Login_Email);
        final  TextView _Login_Password = (EditText)findViewById(R.id.Login_Password);

        _Login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = _Login_Email.getText().toString();
                String Password = _Login_Password.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + Registration_helper.TABLE_NAME + " WHERE " + Registration_helper.COL_5 + "=? AND " + Registration_helper.COL_4 + "=?", new String[]{Email, Password});
                cursor2 = db.rawQuery("SELECT * FROM " + Registration_helper.TABLE_NAME + " WHERE " + Registration_helper.COL_5 + "=?", new String[]{Email});


                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Succesfuldt", Toast.LENGTH_LONG).show();

                        Intent in = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(in);


                        //Henter brugeren som er logget ind
                        while(cursor2.moveToNext()) {
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_1)));
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_2)));
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_3)));
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_4)));
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_5)));
                            bruger.add(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_6)));
                        }
                        cursor2.close();

                        Toast.makeText(getApplicationContext(), bruger.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Person i Array", bruger.toString());
                        //-----------------------



                        //Gem Login knap


                    } else {
                        Toast.makeText(getApplicationContext(), "Fejl, Prøv Igen", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });

    }

    public void gotoRegi(View view) {
        Intent gotoregistration = new Intent(this, Registration_page.class);
        startActivity(gotoregistration);
    }

}

