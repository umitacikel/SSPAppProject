package com.example.yunas.sspappproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fragment_Help extends Fragment implements View.OnClickListener {


    public SSP_Fragment_Help() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp_help, container, false);


        View btnCall = (Button) v.findViewById(R.id.Btn_Call);
        btnCall.setOnClickListener((View.OnClickListener) this);

        View btnEmail = (Button) v.findViewById(R.id.Btn_Email);
        btnEmail.setOnClickListener((View.OnClickListener) this);
        return v;
    }


        public void onClick(View v) {
            if(v.getId() == R.id.Btn_Call)
            {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                call.setData(Uri.parse("tel:" + "+25512492"));
                startActivity(call);
            }
            else if (v.getId() == R.id.Btn_Email)
            {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SSP_Fragment_Help_Email NAME = new SSP_Fragment_Help_Email();
                fragmentTransaction.replace(R.id.fragment, NAME);
                fragmentTransaction.commit();
            }

        }





    }



