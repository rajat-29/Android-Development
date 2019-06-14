package com.example.contact_list;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivMood,ivPhone,ivWeb,ivLoc;
    Button btnCreate;
    final int CREATE_CONTACT = 1;
    String name ="", number ="", web ="", location ="", mood ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLoc = findViewById(R.id.ivLoc);
        btnCreate = findViewById(R.id.btnCreate);

        ivMood.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivLoc.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateContact.class);
                startActivityForResult(intent,CREATE_CONTACT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + web));
                startActivity(intent);
            }
        });

        ivLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CREATE_CONTACT)
        {
            if(resultCode == RESULT_OK)
            {
                ivMood.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivLoc.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy"))
                {
                    ivMood.setImageResource(R.drawable.happy);

                }
                else if(mood.equals("ok"))
                {
                    ivMood.setImageResource(R.drawable.ok);
                }
                else
                {
                    ivMood.setImageResource(R.drawable.sad);
                }



            }
        }

    }
}
