package com.example.yunas.sspappproject;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class tetriz_opslag extends Fragment {

    ArrayList<String> Values = new ArrayList<>();
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    public tetriz_opslag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tetriz_opslag, container, false);

        openHelper = new Opslag_helper(getActivity().getApplicationContext(), Opslag_helper.Tops_TABLE_NAME, null, 1);
        db = openHelper.getReadableDatabase();

        final ListView listview = (ListView) v.findViewById(R.id.listview_tetrizOps);
        final Cursor cursor = db.rawQuery("select * from "+ Opslag_helper.Tops_TABLE_NAME,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(Opslag_helper.Tops_Col_2));
                String emne = cursor.getString(cursor.getColumnIndex(Opslag_helper.Tops_Col_3));

                Values.add(id + "\n"+ "\n"+ emne);
                cursor.moveToNext();
            }
        }
        Collections.reverse(Values);
        final ArrayAdapter<String> adapter =  new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, Values);
        listview.setAdapter(adapter);



        return v;
    }

}
