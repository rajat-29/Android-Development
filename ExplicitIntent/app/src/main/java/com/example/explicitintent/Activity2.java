package com.example.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvWelcome;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnback = findViewById(R.id.btnback);

        tvWelcome = findViewById(R.id.tvWelcome);

        String ename = getIntent().getStringExtra("name");

        tvWelcome.setText(ename + " ,Welcome to Activity 2");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_CANCELED);
                Activity2.this.finish();
            }
        });
    }
}
