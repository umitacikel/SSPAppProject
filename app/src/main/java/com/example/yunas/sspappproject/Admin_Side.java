package com.example.yunas.sspappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Side extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__side);
    }


    public void adminSSPknap(View view){
        Intent intent = new Intent(this, Admin_ssp_side.class);
        startActivity(intent);
    }

    public void adminCUBEknap(View view){
        Intent intent = new Intent(this, Admin_cube_side.class);
        startActivity(intent);
    }

    public void adminTETRIZknap(View view){
        Intent intent = new Intent(this, Admin_tetriz_side.class);
        startActivity(intent);
    }


}
