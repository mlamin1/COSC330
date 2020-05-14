package com.hw1.burgercaloriecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    // TASK 1: DECLARE UI OBJECTS TO BE REFERENCED
    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    // TASK 2: DECLARE VARIABLES FOR COMPUTING CALORIES
    private Burger burger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TASK 4: INITIZLIZE UI OBJECTS AND VARIABLES
        burger = new Burger();
        initialize();

        // TASK 5: REGISTER CHANGE LISTENERS
        registerChangeListener();

    }

    private void initialize() {
        // TASK 5: GET REFERENCE TO EACH OF THE UI COMPONENTS
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        prosciuttoCBX = (CheckBox) findViewById(R.id.checkBox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar) findViewById(R.id.seekBar1);
        caloriesTV = (TextView) findViewById(R.id.textView2);

        displayCalories();
    }

    private void registerChangeListener() {
        pattyRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            switch (radioId) {
                case R.id.radio0: // BEEF PATTY
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.radio1: // LAMB PATTY
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case R.id.radio2: // OSTRICH PATTY
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case R.id.radio3: // ASIAGO CHEESE
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case R.id.radio4: // CREME FRAICHE
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
            }
            displayCalories();
        }
    };

    private OnClickListener baconListener = new OnClickListener() {
        public void onClick(View v) {
            if (((CheckBox) v).isChecked())
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            else
                burger.clearProsciuttoCalories();

            displayCalories();
        }
    };

    private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());
            // sauceCal = seekBar.getProgress();
            displayCalories();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private void displayCalories() {

        // CONSTRUCT AN OUTPUT STRING AND DISPLAY IN THE TEXTVIEW
        String calorieText = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
