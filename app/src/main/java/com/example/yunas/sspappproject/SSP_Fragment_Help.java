package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fragment_Help extends Fragment {


    public SSP_Fragment_Help() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp_help, container, false);
        View btnCall = (Button) v.findViewById(R.id.Btn_Call);




/*
    private void call() {

        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        call.setData(Uri.parse("tel:" + "+25512492"));
        startActivity(call);
    }
*/






        return v;
    }
}

