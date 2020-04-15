package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;



public class Listdata extends AppCompatActivity {

    public MediaPlayer sound_on;
    int song;

    TextView name;
    ImageView image;
    ImageButton button;
    TextView def;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        name = findViewById(R.id.listdata);
        image = findViewById(R.id.imageView2);
        def = findViewById(R.id.listdata2);
        button = findViewById(R.id.imageButton1);
        //   String[] name = {};
        // WordInfo wi;

        Intent intent = getIntent();
        //  String test;

        //  int i = intent.getIntExtra("index",0);


        //  name.setText(word[i]);


        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        def.setText(intent.getStringExtra("def"));
        //button.setImageResource(intent.getIntExtra("button", 0));

        //sound_on = MediaPlayer.create(ListdataActivity.this, R.raw.appointment);
        //sound_on.start();
        //sound_on = MediaPlayer.create(this, R.raw.appointment);

        //name.getText().toString();

        String test = "Appointment";


        String[] words = {"Appointment", "Allergy", "Checkup", "Co-pay", "Emergency", "Fever", "Fiber", "Generic Medicine", "Headache", "Health History", "Health Insurance", "Label",
                "Medicine Interpreter", "Medicine", "Nutrition", "Obesity", "Over-the-counter(OTC)", "Pharmacy", "Pharmacist", "Prescription(Rx)", "Primary Care Center", "Recipe", "Side Effect",
                "Sodium", "Sore Throat", "Symptoms", "Warning Label", "Vitamins"};

        if (name.getText().toString().equals("Appointment")) {
            sound_on = MediaPlayer.create(this, R.raw.appointment);
        }
        if (name.getText().toString().equals("Allergy")) {
            sound_on = MediaPlayer.create(this, R.raw.allergy);
        }
        if (name.getText().toString().equals("Checkup")) {
            sound_on = MediaPlayer.create(this, R.raw.checkup);
        }
        if (name.getText().toString().equals("Co-pay")) {
            sound_on = MediaPlayer.create(this, R.raw.co_pay);
        }
        if (name.getText().toString().equals("Emergency")) {
            sound_on = MediaPlayer.create(this, R.raw.emergency);
        }
        if (name.getText().toString().equals("Fever")) {
            sound_on = MediaPlayer.create(this, R.raw.fever);
        }
        if (name.getText().toString().equals("Fiber")) {
            sound_on = MediaPlayer.create(this, R.raw.fiber);
        }
        if (name.getText().toString().equals("Generic Medicine")) {
            sound_on = MediaPlayer.create(this, R.raw.generic_medicine);
        }
        if (name.getText().toString().equals("Headache")) {
            sound_on = MediaPlayer.create(this, R.raw.headache);
        }
        if (name.getText().toString().equals("Health History")) {
            sound_on = MediaPlayer.create(this, R.raw.health_history);
        }
        if (name.getText().toString().equals("Health Insurance")) {
            sound_on = MediaPlayer.create(this, R.raw.health_insurance);
        }
        if (name.getText().toString().equals("Label")) {
            sound_on = MediaPlayer.create(this, R.raw.label);
        }
        if (name.getText().toString().equals("Medicine Interpreter")) {
            sound_on = MediaPlayer.create(this, R.raw.medicine_interpreter);
        }
        if (name.getText().toString().equals("Nutrition")) {
            sound_on = MediaPlayer.create(this, R.raw.nutrition);
        }
        if (name.getText().toString().equals("Obesity")) {
            sound_on = MediaPlayer.create(this, R.raw.obesity);
        }
        if (name.getText().toString().equals("Over-the-counter(OTC)")) {
            sound_on = MediaPlayer.create(this, R.raw.over_the_counter);
        }
        if (name.getText().toString().equals("Pharmacy")) {
            sound_on = MediaPlayer.create(this, R.raw.pharmacy);
        }
        if (name.getText().toString().equals("Pharmacist")) {
            sound_on = MediaPlayer.create(this, R.raw.pharmacist);
        }
        if (name.getText().toString().equals("Prescription(Rx)")) {
            sound_on = MediaPlayer.create(this, R.raw.prescription);
        }
        if (name.getText().toString().equals("Primary Care Center")) {
            sound_on = MediaPlayer.create(this, R.raw.primary_care_center);
        }
        if (name.getText().toString().equals("Recipe")) {
            sound_on = MediaPlayer.create(this, R.raw.recipe);
        }
        if (name.getText().toString().equals("Side Effect")) {
            sound_on = MediaPlayer.create(this, R.raw.side_effect);
        }
        if (name.getText().toString().equals("Sodium")) {
            sound_on = MediaPlayer.create(this, R.raw.sodium);
        }
        if (name.getText().toString().equals("Sore Throat")) {
            sound_on = MediaPlayer.create(this, R.raw.sore_throat);
        }
        if (name.getText().toString().equals("Symptoms")) {
            sound_on = MediaPlayer.create(this, R.raw.symptoms);
        }
        if (name.getText().toString().equals("Warning Label")) {
            sound_on = MediaPlayer.create(this, R.raw.warning_label);
        }
        if (name.getText().toString().equals("Vitamins")) {
            sound_on = MediaPlayer.create(this, R.raw.vitamins);
        }
    }
    public void playsound(View view){
        sound_on.start();

    }
}
