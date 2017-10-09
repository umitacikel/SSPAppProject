package com.example.yunas.sspappproject;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class cube_begivenheder extends Fragment {



    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    public cube_begivenheder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cube_begivenheder, container, false);

        openHelper = new Registration_helper(getActivity().getApplicationContext(), Registration_helper.c_DATABASE_NAME);
        db = openHelper.getReadableDatabase();




        return v;
    }

}
