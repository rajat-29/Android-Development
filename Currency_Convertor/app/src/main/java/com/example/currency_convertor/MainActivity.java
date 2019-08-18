package com.example.currency_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText amount;
    TextView disp;
    Button euro,yen,usd;
    double rupee,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        disp = findViewById(R.id.disp);
        euro = findViewById(R.id.euro);
        yen = findViewById(R.id.yen);
        usd = findViewById(R.id.usd);

        getSupportActionBar().setTitle("Currency Convertor");
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        System.out.println(id);

        if(amount.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Field is Empty",Toast.LENGTH_SHORT).show();
        }
        else {

            switch (id) {
                case R.id.euro:
                    rupee = Double.valueOf("" + amount.getText());
                    result = 0.013 * rupee;
                    System.out.println(result);
                    disp.setText("" + result);
                    break;

                case R.id.yen:
                    rupee = Double.valueOf("" + amount.getText());
                    result = 1.56 * rupee;
                    disp.setText("" + result);
                    break;

                case R.id.usd:
                    rupee = Double.valueOf("" + amount.getText());
                    result = 0.014 * rupee;
                    disp.setText("" + result);
                    break;

                default:
                    break;

            }
        }

    }
}
