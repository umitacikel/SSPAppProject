package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private FragmentTabHost mTabhost;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        mTabhost = (FragmentTabHost) v.findViewById(R.id.cube_tabhost);
        mTabhost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        mTabhost.addTab(mTabhost.newTabSpec("cube_opslag").setIndicator("Opslag"), cube_opslag.class, null);
        mTabhost.addTab(mTabhost.newTabSpec("cube_begivenheder").setIndicator("Begivenheder"), cube_begivenheder.class, null);

        return v;

    }


}
