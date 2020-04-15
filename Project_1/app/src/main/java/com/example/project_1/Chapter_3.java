package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Chapter_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] vocab = { "-Choose-", "Chest", "Hand", "Feet", "Stomach", "Shoulder", "Head", "Arm" };
    String[] holdingValue = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_3);

        TextView txt = findViewById(R.id.textView4);
        txt.setTextColor(Color.parseColor("#00FF0000"));
        Button btn = findViewById(R.id.headnext);
        btn.setText("Parts of Head");

        Spinner spin0 = (Spinner) findViewById(R.id.spinner5);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner6);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner7);
        Spinner spin3 = (Spinner) findViewById(R.id.spinner8);
        Spinner spin4 = (Spinner) findViewById(R.id.spinner9);
        Spinner spin5 = (Spinner) findViewById(R.id.spinner10);
        Spinner spin6 = (Spinner) findViewById(R.id.spinner11);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vocab);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin0.setAdapter(adapter);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin4.setAdapter(adapter);
        spin5.setAdapter(adapter);
        spin6.setAdapter(adapter);

        spin0.setOnItemSelectedListener(this);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        spin4.setOnItemSelectedListener(this);
        spin5.setOnItemSelectedListener(this);
        spin6.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner5:
                holdingValue[0] = vocab[position];
                break;
            case R.id.spinner6:
                holdingValue[1] = vocab[position];
                break;
            case R.id.spinner7:
                holdingValue[2] = vocab[position];
                break;
            case R.id.spinner8:
                holdingValue[3] = vocab[position];
                break;
            case R.id.spinner9:
                holdingValue[4] = vocab[position];
                break;
            case R.id.spinner10:
                holdingValue[5] = vocab[position];
                break;
            case R.id.spinner11:
                holdingValue[6] = vocab[position];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void checkAnswer(View v){
        if(holdingValue[0] == "Head" && holdingValue[1] == "Shoulder" && holdingValue[2] == "Chest" && holdingValue[3] == "Stomach" && holdingValue[4] == "Arm" && holdingValue[5] == "Hand" && holdingValue[6] == "Feet"){
            TextView text = findViewById(R.id.textView4);
            text.setText("Congrats all correct!");
            text.setTextColor(Color.parseColor("#FF118A08"));
        }
        else{
            TextView text = findViewById(R.id.textView4);
            text.setText("Sorry try again.");
            text.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    public void goToHeadVocab(View v){
        startActivity(new Intent(Chapter_3.this, anatomyHead.class));
    }
}
