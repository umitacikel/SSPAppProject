package com.example.yunas.sspappproject;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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

        openHelper = new Begivenhed_helper(getApplicationContext());
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

                        if(_Emne.length() !=0 && _Detaljer.length() !=0 && _Sted.length() !=0 && _Dato.length() !=0){

                            Begivenhed_helper beghelp = new Begivenhed_helper(getApplicationContext());
                            beghelp.addData(_Emne, _Detaljer, _Sted, _Dato);
                            Toast.makeText(getApplicationContext(), "Begivenhed oprettet" , Toast.LENGTH_LONG).show();
                            dialog.hide();
                            begivenhedNotifikation();

                        }else if(_Emne.length() ==0 || _Detaljer.length() ==0 || _Sted.length() ==0 || _Dato.length() ==0){
                            Toast.makeText(getApplicationContext(), "Udfyld venligst alle felter" , Toast.LENGTH_LONG).show();
                        }
                    }
                });

                _Ann_Beg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });

            }

        });

    }

    public void begivenhedNotifikation(){


        NotificationCompat.Builder notificationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ssplogo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ssplogo))
                .setContentTitle("Cube oprettede en ny begivenhed")
                .setContentText("Tjek begivenheder");

        NotificationManager nfhm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nfhm.notify(1, notificationbuilder.build());

    }



}
