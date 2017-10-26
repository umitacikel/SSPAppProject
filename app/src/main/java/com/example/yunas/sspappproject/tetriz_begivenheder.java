package com.example.yunas.sspappproject;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class tetriz_begivenheder extends Fragment {

    ArrayList<String> Values = new ArrayList<>();
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;


    public tetriz_begivenheder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tetriz_begivenheder, container, false);
        openHelper = new tetriz_Begivenhed_helper(getActivity().getApplicationContext());
        db = openHelper.getReadableDatabase();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View mView = getActivity().getLayoutInflater().inflate(R.layout.begivenhed_popup, null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();
        final TextView _begivenhedpop = (TextView) mView.findViewById(R.id.beg_pop_beg);
        final TextView _detaljerpop = (TextView) mView.findViewById(R.id.beg_pop_detal);
        final TextView _stedpop = (TextView) mView.findViewById(R.id.beg_pop_sted);
        final TextView _datopop = (TextView) mView.findViewById(R.id.beg_pop_dato);

        final ListView listview = (ListView) v.findViewById(R.id.tetriz_beg_listview);
        final Cursor cursor = db.rawQuery("select * from "+ tetriz_Begivenhed_helper.t_TABLE_NAME,null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(tetriz_Begivenhed_helper.t_Col_1));
                String emne = cursor.getString(cursor.getColumnIndex(tetriz_Begivenhed_helper.t_Col_2));

                Values.add(id + "   " + emne);
                cursor.moveToNext();
            }
        }

        Collections.reverse(Values);
        final ArrayAdapter<String> adapter =  new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, Values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Integer> ID = new ArrayList<Integer>();
                ID.add(Integer.parseInt(adapter.getItem(position).substring(0,1)));
                final Cursor  cursor2 = db.rawQuery("SELECT * FROM "+ tetriz_Begivenhed_helper.t_TABLE_NAME + " WHERE ID=" + ID.get(0),null);
                Toast.makeText(getContext(),"før cursor2", Toast.LENGTH_LONG).show();

                if (cursor2.moveToNext()) {
                    dialog.show();
                    Toast.makeText(getContext(),"inde", Toast.LENGTH_LONG).show();

                    String _emne = cursor2.getString(cursor.getColumnIndex(Begivenhed_helper.c_Col_2));
                    String _detaljer = cursor2.getString(cursor.getColumnIndex(Begivenhed_helper.c_Col_3));
                    String _sted = cursor2.getString(cursor.getColumnIndex(Begivenhed_helper.c_Col_4));
                    String _dato = cursor2.getString(cursor.getColumnIndex(Begivenhed_helper.c_Col_5));

                    _begivenhedpop.setText(_emne);
                    _detaljerpop.setText(_detaljer);
                    _stedpop.setText(_sted);
                    _datopop.setText(_dato);

                }
                cursor2.close();

            }
        });

        return v;
    }

}
