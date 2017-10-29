package com.example.yunas.sspappproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pub_Folder extends Fragment implements View.OnClickListener {


    public Pub_Folder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pub_folder, container, false);

        View btnPdf1 = (Button) v.findViewById(R.id.BtnPdf1);
        btnPdf1.setOnClickListener((View.OnClickListener) this);

        View btnPdf2 = (Button) v.findViewById(R.id.BtnPdf2);
        btnPdf2.setOnClickListener((View.OnClickListener) this);

        View btnPdf3 = (Button) v.findViewById(R.id.BtnPdf3);
        btnPdf3.setOnClickListener((View.OnClickListener) this);

        return v;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.BtnPdf1) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + "https://ssp.helsingor.dk/media/7790188/blanket-til-indstilling-til-fritidspas.pdf"), "text/html");

            startActivity(intent);

        }
        if (v.getId() == R.id.BtnPdf2) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + "https://ssp.helsingor.dk/media/11910860/antiradikaliseringsfolder.pdf"), "text/html");

            startActivity(intent);

        }
        if (v.getId() == R.id.BtnPdf3) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + "https://ssp.helsingor.dk/media/7790017/naar_boern_og_unge_deler_intime_billeder_paa_nettet.pdf"), "text/html");

            startActivity(intent);
        }
    }
}
