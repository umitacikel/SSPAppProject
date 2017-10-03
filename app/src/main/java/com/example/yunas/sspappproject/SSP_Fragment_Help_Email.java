package com.example.yunas.sspappproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SSP_Fragment_Help_Email extends Fragment implements View.OnClickListener   {


    public SSP_Fragment_Help_Email() {
        // Required empty public constructor
    }

    String Email = "umitacike@live.dk";
  //  EditText editTextEmail;
    EditText editTextSubject;
    EditText editTextMessage;

    Button buttonSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssp_help_email, container, false);
    //    editTextEmail = (EditText) v.findViewById(R.id.editTextEmail);
        editTextSubject = (EditText) v.findViewById(R.id.editTextSubject);
        editTextMessage = (EditText) v.findViewById(R.id.editTextMessage);


        buttonSend = (Button) v.findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(this);

        return v;
    }

    private void sendEmail() {
        //Getting content for email
      //  String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(getActivity(), Email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
    @Override
    public void onClick(View v) {
        sendEmail();

    }
}
