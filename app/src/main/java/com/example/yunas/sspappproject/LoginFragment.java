package com.example.yunas.sspappproject;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Cursor cursor2;





    public LoginFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        View navHeader = inflater.inflate(R.layout.nav_header_main, container, false);

        openHelper = new Registration_helper(getActivity());
        db = openHelper.getReadableDatabase();

      final  ArrayList<String> bruger = new ArrayList<>();


        final    Button  _Login_Btn = (Button) v.findViewById(R.id.Login_Btn);
        final TextView _Login_Email = (EditText) v.findViewById(R.id.Login_Email);
        final  TextView _Login_Password = (EditText) v.findViewById(R.id.Login_Password);

        _Login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = _Login_Email.getText().toString();
                String Password = _Login_Password.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + Registration_helper.TABLE_NAME + " WHERE " + Registration_helper.COL_5 + "=? AND " + Registration_helper.COL_4 + "=?", new String[]{Email, Password});
                cursor2 = db.rawQuery("SELECT * FROM " + Registration_helper.TABLE_NAME + " WHERE " + Registration_helper.COL_5 + "=?", new String[]{Email});


                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getActivity(), "Login Succesfuldt", Toast.LENGTH_LONG).show();

                        Intent in = new Intent(getActivity(), MainActivity.class);
                        startActivity(in);


                        //Henter brugeren som er logget ind
                        while(cursor2.moveToNext()) {
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_1))));
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_2))));
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_3))));
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_4))));
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_5))));
                            bruger.add(new String(cursor2.getString(cursor2.getColumnIndex(Registration_helper.COL_6))));
                        }
                        cursor2.close();

                        Toast.makeText(getActivity(), bruger.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Person i Array", bruger.toString());
                        //-----------------------



                        //Gem Login knap


                    } else {
                        Toast.makeText(getActivity(), "Fejl, Prøv Igen", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });
        return v;
    }

}




