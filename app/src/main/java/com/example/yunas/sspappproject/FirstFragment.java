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
public class FirstFragment extends Fragment {

    private FragmentTabHost tTabhost;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        tTabhost = (FragmentTabHost) v.findViewById(R.id.tetriz_tabhost);
        tTabhost.setup(getActivity(), getChildFragmentManager(), R.id.tetriz_realtabcontent);
        tTabhost.addTab(tTabhost.newTabSpec("tetriz_opslag").setIndicator("Opslag"), tetriz_opslag.class, null);
        tTabhost.addTab(tTabhost.newTabSpec("tetriz_begivenheder").setIndicator("Begivenheder"), tetriz_begivenheder.class, null);


        return v;
    }

}
