package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Personale_Fragment extends Fragment {

Button Mikkel_Muller, Anja_Enggaard;
Button Jane_Hansen, Øzcan_Yucel, Kasper_Jørgensen, Janne_Billsteen, Ulla_Svendsen, Nadine_Salem;
Button Robert_Rodriguez, Cømert_Sonsuz;
Button Samer_Zaazou, Hani_Hussain, Houda_Bayoumi, Rikke_Møller, Tomislav_Antic, Baha_Fleifel, Emre_Kalem;
Button Ungeråd;
Button færdig;



    public Personale_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_personale_, container, false);


        Mikkel_Muller = (Button) v.findViewById(R.id.Mikkel_Muller_btn);
        Anja_Enggaard = (Button) v.findViewById(R.id.Anja_Enggard_btn);

        Jane_Hansen =(Button) v.findViewById(R.id.Jane_hansen_btn);
        Øzcan_Yucel =(Button) v.findViewById(R.id.Øzcan_Yucel_btn);
        Kasper_Jørgensen =(Button) v.findViewById(R.id.Kasper_Jørgensen_btn);
        Janne_Billsteen =(Button) v.findViewById(R.id.JanneBillsteenChristensen_btn);
        Ulla_Svendsen =(Button) v.findViewById(R.id.UllaSvendsen_btn);
        Nadine_Salem =(Button) v.findViewById(R.id.NadineSalem_btn);

        Robert_Rodriguez = (Button) v.findViewById(R.id.RobertRodriguez_btn);
        Cømert_Sonsuz = (Button) v.findViewById(R.id.CømertSonsuz_btn);

        Samer_Zaazou =(Button) v.findViewById(R.id.Samer_Zaazou_btn);
        Hani_Hussain  =(Button) v.findViewById(R.id.HaniHussain_btn);
        Houda_Bayoumi  =(Button) v.findViewById(R.id.HoudaBayoumi_btn);
        Rikke_Møller  =(Button) v.findViewById(R.id.RikkeMøller_btn);
        Tomislav_Antic  =(Button) v.findViewById(R.id.TomislavAntic_btn);
        Baha_Fleifel  =(Button) v.findViewById(R.id.BahaFleifel_btn);
        Emre_Kalem  =(Button) v.findViewById(R.id.EmreKalem_btn);

        Ungeråd =(Button) v.findViewById(R.id.UngeRådgivning_btn);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View mView = getActivity().getLayoutInflater().inflate(R.layout.personale_oplysninger, null);
        builder.setView(mView);
        final AlertDialog dialog = builder.create();

        final TextView Navn =(TextView) mView.findViewById(R.id.Oplysninger_navn);
        final TextView Stilling =(TextView) mView.findViewById(R.id.Oplysninger_stilling);
        final TextView Email = (TextView) mView.findViewById(R.id.Oplysninger_Email);
        final TextView Telefon = (TextView) mView.findViewById(R.id.Oplysninger_telefon);

        færdig = (Button) mView.findViewById(R.id.Oplysninger_færdig);
        færdig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });

        Mikkel_Muller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navn.setText("Mikkel Müller");
                Stilling.setText("Leder");
                Email.setText("mhm38@helsingor.dk");
                Telefon.setText("25 31 19 50");
                dialog.show();

            }
        });

        Anja_Enggaard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Anja Enggaard");
                Stilling.setText("Sekretær");
                Email.setText("aen35@helsingor.dk");
                Telefon.setText("49 28 27 18 – 25 31 27 18");
                dialog.show();
            }
        });
        //-------------------------------------------

        Jane_Hansen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Jane Hansen");
                Stilling.setText("SSP Medarbejder");
                Email.setText("jha35@helsingor.dk");
                Telefon.setText("25 31 19 51");
                dialog.show();
            }
        });

        Øzcan_Yucel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Øzcan Yucel");
                Stilling.setText("SSP Medarbejder");
                Email.setText("zyu07@helsingor.dk");
                Telefon.setText("25 31 19 52");
                dialog.show();
            }
        });

        Kasper_Jørgensen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Kasper Jørgensen");
                Stilling.setText("SSP Medarbejder");
                Email.setText("kjj38@helsingor.dk");
                Telefon.setText("41 93 11 06");
                dialog.show();
            }
        });

        Janne_Billsteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Janne Billsteen Christensen ");
                Stilling.setText("SSP Medarbejder");
                Email.setText("jbc07@helsingor.dk");
                Telefon.setText("41 93 11 36");
                dialog.show();
            }
        });

        Ulla_Svendsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Ulla Svendsen");
                Stilling.setText("SSP Medarbejder");
                Email.setText("");
                Telefon.setText("");
                dialog.show();

            }
        });

        Nadine_Salem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Nadine Salem");
                Stilling.setText("SSP Medarbejder");
                Email.setText("nsa08@helsingor.dk");
                Telefon.setText("25 31 19 53");
                dialog.show();

            }
        });

        //--------------------------------------------------

        Robert_Rodriguez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Robert Rodriguez");
                Stilling.setText("SSP+ Koordinator");
                Email.setText("rro07@helsingor.dk");
                Telefon.setText("25 31 19 55");
                dialog.show();
            }
        });

        Cømert_Sonsuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Cømert Sonsuz");
                Stilling.setText("SSP+ Mentor");
                Email.setText("cso07@helsingor.dk");
                Telefon.setText("41 86 95 63");
                dialog.show();
            }
        });

        //---------------------------------------------

        Samer_Zaazou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Samer Zaazou");
                Stilling.setText("Afdelingsleder");
                Email.setText("sza07@helsingor.dk");
                Telefon.setText("25 31 19 54");
                dialog.show();
            }
        });

        Hani_Hussain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Hani Hussain Abdel- Rahman");
                Stilling.setText("Klubassistent");
                Email.setText("hab07@helsingor.dk");
                Telefon.setText("41 86 95 60");
                dialog.show();
            }
        });


        Houda_Bayoumi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Houda Bayoumi");
                Stilling.setText("Pædagog");
                Email.setText("hba07@helsingor.dk");
                Telefon.setText("41 86 95 62");
                dialog.show();
            }
        });


        Rikke_Møller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Rikke Møller");
                Stilling.setText("Pædagog");
                Email.setText("rim38@helsingor.dk");
                Telefon.setText("41 93 11 07");
                dialog.show();
            }
        });


        Tomislav_Antic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Tomislav Antic");
                Stilling.setText("Mentor/træner");
                Email.setText("toa07@helsingor.dk");
                Telefon.setText("41 93 11 19");
                dialog.show();
            }
        });

        Baha_Fleifel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Baha Eldin Mohamad Fleifel");
                Stilling.setText("Klubassistent");
                Email.setText("blf07@helsingor.dk");
                Telefon.setText("");
                dialog.show();
            }
        });

        Emre_Kalem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Emre Kalem");
                Stilling.setText("Klubassistent");
                Email.setText("emk07@helsingor.dk");
                Telefon.setText("");
                dialog.show();
            }
        });

        //----------------------------------------------------------

        Ungeråd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navn.setText("Anonym Ungerådgivning");
                Stilling.setText("Rådgivningen");
                Email.setText("ung.raadgivning@helsingor.dk");
                Telefon.setText("25 51 24 92");
                dialog.show();
            }
        });



        return v;
    }


    public void visopl(String navn, String stilling, String email, String telefon){

        View mView = getActivity().getLayoutInflater().inflate(R.layout.personale_oplysninger, null);

        final TextView Navn =(TextView) mView.findViewById(R.id.Oplysninger_navn);
        final TextView Stilling =(TextView) mView.findViewById(R.id.Oplysninger_stilling);
        final TextView Email = (TextView) mView.findViewById(R.id.Oplysninger_Email);
        final TextView Telefon = (TextView) mView.findViewById(R.id.Oplysninger_telefon);


        Navn.setText(navn);
        Stilling.setText(stilling);
        Email.setText(email);
        Telefon.setText(telefon);
    }

}
