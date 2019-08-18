package com.example.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etWeight,etHeight;
    Button btnSubmit;
    TextView tvBmi,tvSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        tvBmi = findViewById(R.id.tvBmi);
        tvSuggest = findViewById(R.id.tvSuggest);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvBmi.setVisibility(View.GONE);
        tvSuggest.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etWeight.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Weight can't be empty", Toast.LENGTH_SHORT).show();
                    etWeight.setText("");
                }
                else if(etHeight.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Height can't be empty", Toast.LENGTH_SHORT).show();
                    etHeight.setText("");
                }
                else
                {
                    calculatebmi();
                }
            }
        });

    }

    private void calculatebmi()
    {

        double weight = Double.parseDouble(etWeight.getText().toString().trim());

        double height = Double.parseDouble(etHeight.getText().toString().trim())/100;

        double bmi = Math.round(weight * 10 / height / height) / 10;

        if(bmi>12 && bmi<18.5) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are UnderWeight");
        }
        else if(bmi>=18.5 && bmi<25) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are Normal");
        }
        else if(bmi>=25 && bmi<30) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are Over Weight");
        }
        else if(bmi>=30 && bmi<35) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are Obese Class I");
        }
        else if(bmi>=35 && bmi<40) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are Obese Class II");
        }
        else if(bmi>=40) {
            tvBmi.setText("Hi, Your BMI IS : "+bmi);
            tvSuggest.setText("You are Obese Class III");
        }

        tvBmi.setVisibility(View.VISIBLE);
        tvSuggest.setVisibility(View.VISIBLE);

    }
}
