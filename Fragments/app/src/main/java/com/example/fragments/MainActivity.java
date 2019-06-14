package com.example.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescrip;
    ArrayList<String> desp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescrip = findViewById(R.id.tvDescrip);

        desp = new ArrayList<String >();

        desp.add("Description for iteam 1");
        desp.add("Description for iteam 2");
        desp.add("Description for iteam 3");

    }


    @Override
    public void onItemSelected(int index) {

        tvDescrip.setText(desp.get(index));

    }
}
