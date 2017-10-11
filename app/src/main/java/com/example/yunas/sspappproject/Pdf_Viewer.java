package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pdf_Viewer extends Fragment {

PDFView pdfView;
    public Pdf_Viewer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pdf__viewer, container, false);
        pdfView = (PDFView)v.findViewById(R.id.pdfView);
        pdfView.fromAsset("FritidsPas.pdf").load();

        return v;
    }


}
