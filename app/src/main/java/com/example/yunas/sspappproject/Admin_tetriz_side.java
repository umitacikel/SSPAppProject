package com.example.yunas.sspappproject;

import android.app.NotificationManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yunas.sspappproject.R;

public class Admin_tetriz_side extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _begivenhed_Emne, _begivenhed_Detaljer, _begivenhed_Sted, _begivenhed_Dato;
    Button _Opret_Beg, _Ann_Beg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tetriz_side);
        setTitle("Admin Cube Side");

        openHelper = new tetriz_Begivenhed_helper(getApplicationContext());
        db = openHelper.getWritableDatabase();

        Button tetriz_Begivenhed = (Button) findViewById(R.id.tetriz_begivenhed_btn);
        tetriz_Begivenhed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Admin_tetriz_side.this);
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

                            tetriz_Begivenhed_helper beghelp = new tetriz_Begivenhed_helper(getApplicationContext());
                            beghelp.tetriz_addData(_Emne, _Detaljer, _Sted, _Dato);
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




        Button opret_ops = (Button) findViewById(R.id.tetriz_opslag_btn);
        opret_ops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder tbuilder = new AlertDialog.Builder(Admin_tetriz_side.this);
                View tView = getLayoutInflater().inflate(R.layout.opslag_layout, null);

                tbuilder.setView(tView);
                final AlertDialog dialog = tbuilder.create();
                dialog.show();

                final EditText opslag_emne = (EditText) tView.findViewById(R.id.opslag_Emne);
                final EditText opslag_detaljer = (EditText) tView.findViewById(R.id.Opslag_detaljer);

                Button opslag_opret = (Button) tView.findViewById(R.id.opslag_opret);
                Button opslag_annu = (Button) tView.findViewById(R.id.Opslag_annu);

                opslag_opret.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String _opslag_emne = opslag_emne.getText().toString();
                        String _opslag_detaljer = opslag_detaljer.getText().toString();

                        if(_opslag_emne.length() != 0 && _opslag_detaljer.length() != 0){

                            Opslag_helper ops_help = new Opslag_helper(getApplicationContext(), Opslag_helper.Tops_TABLE_NAME, null, 1);
                            ops_help.addDataTops(_opslag_emne, _opslag_detaljer);
                            Toast.makeText(getApplicationContext(), "Opslag oprettet" , Toast.LENGTH_LONG).show();
                            dialog.hide();
                        }else if(_opslag_emne.length() == 0 || _opslag_detaljer.length() == 0){
                            Toast.makeText(getApplicationContext(), "Udfyld alle felter" , Toast.LENGTH_LONG).show();
                        }
                    }
                });
                opslag_annu.setOnClickListener(new View.OnClickListener() {
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
                .setContentTitle("Tetriz oprettede en ny begivenhed")
                .setContentText("Tjek begivenheder");

        NotificationManager nfhm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nfhm.notify(1, notificationbuilder.build());

    }
}
