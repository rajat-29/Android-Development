package com.example.explicitintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btn2,btn3;
    TextView dispResult;
    final int Activity3 = 3;
    final int Activity2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btn2= findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        dispResult = findViewById(R.id.dispResult);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your Name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String ename = etName.getText().toString().trim();
                    Intent intent =  new Intent(MainActivity.this,Activity2.class);
                    intent.putExtra("name",ename);
                    startActivityForResult(intent,Activity2);
                    etName.setText("");
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,Activity3.class);
                startActivityForResult(intent,Activity3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         if(requestCode == Activity3 || requestCode == Activity2)
         {
             if(resultCode == RESULT_OK)
             {
                 dispResult.setText(data.getStringExtra("surname"));
             }

             if(resultCode == RESULT_CANCELED)
             {
                 dispResult.setText("No Data Recieved");
             }
         }
    }
}
