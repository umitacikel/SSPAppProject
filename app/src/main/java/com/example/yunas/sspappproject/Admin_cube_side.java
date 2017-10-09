package com.example.yunas.sspappproject;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.yunas.sspappproject.R;

import java.util.ArrayList;

public class Admin_cube_side extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _begivenhed_Emne, _begivenhed_Detaljer, _begivenhed_Sted, _begivenhed_Dato;
    Button _Opret_Beg, _Ann_Beg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cube_side);
        setTitle("Admin Cube Side");

        openHelper = new Registration_helper(getApplicationContext(), Registration_helper.c_DATABASE_NAME);
        db = openHelper.getWritableDatabase();




        Button cube_Begivenhed = (Button) findViewById(R.id.Cube_begivenhed);
        cube_Begivenhed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(Admin_cube_side.this);
                View mView = getLayoutInflater().inflate(R.layout.begivenhed_layout, null);

                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();



                 _begivenhed_Emne = (EditText) mView.findViewById(R.id.Begivenhed_Emne);
                 _begivenhed_Detaljer = (EditText) mView.findViewById(R.id.Begivenhed_Detaljer);
                 _begivenhed_Sted = (EditText) mView.findViewById(R.id.Begivenhed_Sted);
                 _begivenhed_Dato = (EditText) mView.findViewById(R.id.Begivenhed_Dato);
                 _Opret_Beg = (Button) mView.findViewById(R.id.Begivenhed_Opret_Btn);
                 _Ann_Beg = (Button) mView.findViewById(R.id.Begivenhed_annu_Btn);


                _Opret_Beg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                         String _Emne = _begivenhed_Emne.getText().toString();
                         String _Detaljer = _begivenhed_Detaljer.getText().toString();
                         String _Sted = _begivenhed_Sted.getText().toString();
                         String _Dato = _begivenhed_Dato.getText().toString();

                        c_insertdata(_Emne, _Detaljer, _Sted, _Dato);
                        Toast.makeText(getApplicationContext(), "Begivenhed oprettet" , Toast.LENGTH_LONG).show();
                        dialog.hide();
                    }
                });

            }

        });

    }




    public void c_insertdata(String _Emne, String _Detaljer, String _Sted, String _Dato){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Registration_helper.c_Col_2, _Emne);
        contentValues.put(Registration_helper.c_Col_3, _Detaljer);
        contentValues.put(Registration_helper.c_Col_4, _Sted);
        contentValues.put(Registration_helper.c_Col_5, _Dato);
        db.insert(Registration_helper.c_TABLE_NAME, null, contentValues);
    }
}
