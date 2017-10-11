package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fragment extends Fragment {

    private FragmentTabHost mTabhost;
    public SSP_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp, container, false);


        mTabhost = (FragmentTabHost) v.findViewById(R.id.ssp_tabhost);
        mTabhost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        mTabhost.addTab(mTabhost.newTabSpec("SSP_Anonym").setIndicator("Anonym Rådgivning"), SSP_Anonym.class, null);
        mTabhost.addTab(mTabhost.newTabSpec("SSP_Fritid").setIndicator("Fritids Job"), SSP_Fritid.class, null);

        return v;

    }


}



