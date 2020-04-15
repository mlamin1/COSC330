package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chapter_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_5);
    }

    public void readExercise(View view){
        startActivity(new Intent(Chapter_5.this, ReadingExercise.class));
    }

    public void speakExercise(View view){
        startActivity(new Intent(Chapter_5.this, speakingExercise.class));
    }
}
