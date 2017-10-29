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
public class PubFragment extends Fragment {

    private FragmentTabHost mTabhost;
    public PubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pub, container, false);


        mTabhost = (FragmentTabHost) v.findViewById(R.id.pub_tabhost);
        mTabhost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        mTabhost.addTab(mTabhost.newTabSpec("Pub_Folder").setIndicator("filpdf"), Pub_Folder.class, null);
        mTabhost.addTab(mTabhost.newTabSpec("Pub_Andet").setIndicator("Andet"), Pub_Andet.class, null);

        return v;

    }


}



