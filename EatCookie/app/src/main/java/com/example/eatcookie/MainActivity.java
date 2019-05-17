package com.example.eatcookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCokies(View view) {
        ImageView displayImage = (ImageView) findViewById(R.id.cookie_image);
        displayImage.setImageResource(R.drawable.after_cookie);

        TextView textView = (TextView) findViewById(R.id.status_text);
        textView.setText("I'm so full");
    }
}


