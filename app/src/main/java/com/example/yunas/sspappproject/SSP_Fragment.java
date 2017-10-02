package com.example.yunas.sspappproject;


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
public class SSP_Fragment extends Fragment {


    public SSP_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp, container, false);


        Button ID = (Button) v.findViewById(R.id.Btn_Help);
        ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SSP_Fragment_Help NAME = new SSP_Fragment_Help();
                fragmentTransaction.replace(R.id.fragment, NAME);
                fragmentTransaction.commit();

            }
        });

        return v;
    }


}
