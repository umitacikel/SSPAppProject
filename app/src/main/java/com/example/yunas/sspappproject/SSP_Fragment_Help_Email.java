package com.example.yunas.sspappproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.R.id.message;



/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fragment_Help_Email extends Fragment  implements View.OnClickListener {


    public SSP_Fragment_Help_Email() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp_help, container, false);



        View btnSendEmail = (Button) v.findViewById(R.id.Btn_SendEmail);
        btnSendEmail.setOnClickListener((View.OnClickListener) this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Btn_SendEmail)
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","yunas3000@gmail.com", null));

            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "GMAIL"));
        }
    }

}
