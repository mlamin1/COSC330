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

public class anatomyHead extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] headVocab = { "-Choose-", "Neck", "Ear", "Nose", "Eye", "Mouth" };
    String[] holdingValue = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy_head);

        TextView txt = findViewById(R.id.textView27);
        txt.setTextColor(Color.parseColor("#00FF0000"));

        Spinner spin0 = (Spinner) findViewById(R.id.spinner12);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner13);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner14);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner15);
        Spinner spin4 = (Spinner) findViewById(R.id.spinner16);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, headVocab);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin0.setAdapter(adapter);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin4.setAdapter(adapter);

        spin0.setOnItemSelectedListener(this);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        spin4.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner12:
                holdingValue[0] = headVocab[position];
                break;
            case R.id.spinner13:
                holdingValue[1] = headVocab[position];
                break;
            case R.id.spinner14:
                holdingValue[2] = headVocab[position];
                break;
            case R.id.spinner15:
                holdingValue[3] = headVocab[position];
                break;
            case R.id.spinner16:
                holdingValue[4] = headVocab[position];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void checkVocab(View v){
        if(holdingValue[0] == "Eye" && holdingValue[1] == "Mouth" && holdingValue[2] == "Neck" && holdingValue[3] == "Nose" && holdingValue[4] == "Ear"){
            TextView text = findViewById(R.id.textView27);
            text.setText("Congrats all correct!");
            text.setTextColor(Color.parseColor("#FF118A08"));
        }
        else{
            TextView text = findViewById(R.id.textView27);
            text.setText("Sorry try again.");
            text.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    public void restartVocab(View v){
        finish();
    }
}
