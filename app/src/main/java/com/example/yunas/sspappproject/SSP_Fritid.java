package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fritid extends Fragment implements View.OnClickListener {

    PDFView pdfview;

    public SSP_Fritid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp_fritid, container, false);

        View btnPdf = (Button) v.findViewById(R.id.BtnPdf);
        btnPdf.setOnClickListener((View.OnClickListener) this);

        return v;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.BtnPdf) {
            android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment,  new Pdf_Viewer() ).commit();
        }

    }
}