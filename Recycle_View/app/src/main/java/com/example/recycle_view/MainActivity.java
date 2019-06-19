package com.example.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        addBtn = findViewById(R.id.btnAdd);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("ram","ji","bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("RAJAT","Gupta", "Plane"));
        people.add(new Person("RAM","Gupta", "bus"));
        people.add(new Person("RIDHAV","Gupta", "Plane"));
        people.add(new Person("RISHABH","Gupta", "Plane"));
        people.add(new Person("POONAM","Gupta", "Plane"));
        people.add(new Person("SANJEEV","Gupta", "Plane"));
        people.add(new Person("KANTA","Gupta", "bus"));
        people.add(new Person("RAMESH","Gupta", "bus"));
        people.add(new Person("POONAM","Gupta", "Plane"));
        people.add(new Person("SANJEEV","Gupta", "Plane"));
        people.add(new Person("KANTA","Gupta", "bus"));
        people.add(new Person("RAMESH","Gupta", "bus"));
        people.add(new Person("KANTA","Gupta", "bus"));
        people.add(new Person("RAMESH","Gupta", "bus"));
        people.add(new Person("POONAM","Gupta", "Plane"));
        people.add(new Person("SANJEEV","Gupta", "Plane"));
        people.add(new Person("KANTA","Gupta", "bus"));
        people.add(new Person("RAMESH","Gupta", "bus"));

        myAdapter = new PersonAdapter(this, people);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onItemclicked(int index) {

        Toast.makeText(this, "Name: " + people.get(index).getName(), Toast.LENGTH_SHORT).show();

    }
}
