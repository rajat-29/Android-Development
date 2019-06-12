package com.example.crickettemperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalculate;
    TextView dispResults;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalculate = findViewById(R.id.btnCalculate);
        dispResults = findViewById(R.id.dispResults);

        dispResults.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.00");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etChirps.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());

                    double temp = (chirps / 3.0) + 4;

                    String results = "The approximate temperature outside is " + formatter.format(temp) + " degrees Celsius.";

                    dispResults.setText(results);

                    dispResults.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
