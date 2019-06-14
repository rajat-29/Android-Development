package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescrip;
    String [] desp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescrip = findViewById(R.id.tvDescrip);

        desp = getResources().getStringArray(R.array.descriptions);

        // phone is in potrait mode
        if(findViewById(R.id.layout_potrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();

        }

        // phone is in landscape mode
        if(findViewById(R.id.layout_land) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }



    }


    @Override
    public void onItemSelected(int index) {

        tvDescrip.setText(desp[index]);

        // phone is in potrait mode
        if(findViewById(R.id.layout_potrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();

        }

    }
}
