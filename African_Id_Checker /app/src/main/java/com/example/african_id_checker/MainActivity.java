package com.example.african_id_checker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText2;
    Button submit_btn;
    TextView result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText2 = findViewById(R.id.editText2);
        submit_btn = findViewById(R.id.submit_btn);
        result_view = findViewById(R.id.result_view);
        result_view.setVisibility(View.GONE);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = editText2.getText().toString().trim();

                if(idNumber.length()==11) {
                    String dob = idNumber.substring(0, 6);

                    int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                    String sGender;

                    if (gender < 5)
                        sGender = "Female";
                    else
                        sGender = "Male";

                    int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                    String snationality;

                    if (nationality == 0)
                        snationality = "SA Citizen";
                    else
                        snationality = "Permanent Resident";

                    result_view.setText("Date of Birth: " + dob + "\n" +
                            "Gender: " + sGender + "\n" +
                            "Nationality: " + snationality);

                    result_view.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(MainActivity.this, "Enter correct 11 digit No.", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
