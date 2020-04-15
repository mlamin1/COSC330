package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class ReadingExercise extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] answers = { "-Choose-", "Emergency", "Appointment", "Primary care center", "Checkup" };
    String[] holdingValue = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_exercise);
        TextView text = findViewById(R.id.textView9);
        text.setTextColor(Color.parseColor("#00FF0000"));

        Spinner spin0 = (Spinner) findViewById(R.id.spinner);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner2);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner3);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, answers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin0.setAdapter(adapter);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);

        spin0.setOnItemSelectedListener(this);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> arg0, View view, int position, long id){
        switch (arg0.getId()){
            case R.id.spinner:
                holdingValue[0] = answers[position];
                break;
            case R.id.spinner2:
                holdingValue[1] = answers[position];
                break;
            case R.id.spinner3:
                holdingValue[2] = answers[position];
                break;
            case R.id.spinner4:
                holdingValue[3] = answers[position];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void trySubmit(View v){
        if(holdingValue[0] == "Checkup" && holdingValue[1] == "Primary care center" && holdingValue[2] == "Appointment" && holdingValue[3] == "Emergency"){
            TextView text = findViewById(R.id.textView9);
            text.setTextColor(Color.parseColor("#00FF0000"));
            startActivity(new Intent(ReadingExercise.this, readingSolutions.class));
        }
        else{
            TextView text = findViewById(R.id.textView9);
            text.setTextColor(Color.parseColor("#FF0000"));
        }
    }
}
