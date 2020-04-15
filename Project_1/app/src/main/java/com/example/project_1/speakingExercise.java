package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class speakingExercise extends AppCompatActivity {

    boolean next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaking_exercise);
        next = false;
        Button btn = findViewById(R.id.switchbtn);
        btn.setText("Try Yourself");
    }

    public void switchToNext(View view){
        TextView txt0 = findViewById(R.id.textView11);
        TextView txt1 = findViewById(R.id.textView12);
        TextView txt2 = findViewById(R.id.textView14);
        TextView txt3 = findViewById(R.id.textView15);
        TextView txt4 = findViewById(R.id.textView23);
        TextView txt5 = findViewById(R.id.textView22);
        TextView txt6 = findViewById(R.id.textView13);
        TextView txt7 = findViewById(R.id.textView26);
        TextView txt8 = findViewById(R.id.textView24);
        TextView txt9 = findViewById(R.id.textView25);
        Button btn = findViewById(R.id.switchbtn);

        if(next == false) {
            btn.setText("Switch Back");
            txt0.setText(R.string.Health6);
            txt1.setText(R.string.Patient6);
            txt2.setText(R.string.Health7);
            txt3.setText(R.string.Patient7);
            txt4.setText(R.string.Health8);
            txt5.setText(R.string.Patient8);
            txt6.setText(R.string.Health9);
            txt7.setText(R.string.Patient9);
            txt8.setText(R.string.Health10);
            txt9.setText(R.string.Patient10);
            next = true;
        }
        else{
            btn.setText("Try Yourself");
            txt0.setText(R.string.Health1);
            txt1.setText(R.string.Patient1);
            txt2.setText(R.string.Health2);
            txt3.setText(R.string.Patient2);
            txt4.setText(R.string.Health3);
            txt5.setText(R.string.Patient3);
            txt6.setText(R.string.Health4);
            txt7.setText(R.string.Patient4);
            txt8.setText(R.string.Health5);
            txt9.setText(R.string.Patient5);
            next = false;
        }
    }
}
