package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class table_of_contents extends AppCompatActivity {

    ListView listView;
    String title[] = {"Glossary/Word list", "Crossword puzzle", "Learning the Human Anatomy", "Picture Story", "Reading and Speaking Exercises"};
    int logo[] = {R.drawable.glossary, R.drawable.crossword, R.drawable.anatomy1, R.drawable.story, R.drawable.talking};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_of_contents);

        listView = (ListView)findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), title, logo);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent myintent = new Intent(view.getContext(), Chapter_1.class);
                    startActivityForResult(myintent, 0);
                }
                if(position == 1){
                    Intent myintent = new Intent(view.getContext(), Chapter2.class);
                    startActivityForResult(myintent, 1);
                }
                if(position == 2){
                    Intent myintent = new Intent(view.getContext(), Chapter_3.class);
                    startActivityForResult(myintent, 2);
                }
                if(position == 3){
                    Intent myintent = new Intent(view.getContext(), Chapter_4.class);
                    startActivityForResult(myintent, 3);
                }
                if(position == 4){
                    Intent myintent = new Intent(view.getContext(), Chapter_5.class);
                    startActivityForResult(myintent, 4);
                }
            }
        });


    }
}
