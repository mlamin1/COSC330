package com.hw1.fibonacciflower;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {


    private ArrayList<ImageView> allPetals;
    private LayoutInflater layoutInflater;

    private Button pinkBtn;
    private Button goldBtn;
    private Button clearBtn;
    private RelativeLayout relativeLayout;

    Flower myFlower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFlower = new Flower();
        allPetals = new ArrayList <ImageView>();





        //INITIALIZE THE GENERATION OF THE FIBONACCI ARTWORK
        initialize();

        //CREATE A LAYOUT INFLATER TO ADD PETALS TO RELATIVE LAYOUT
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        pinkBtn = (Button) findViewById(R.id.Pink);
        goldBtn = (Button) findViewById(R.id.Gold);
        clearBtn = (Button) findViewById(R.id.Clear);
        pinkBtn.setOnClickListener(addPetal);
        goldBtn.setOnClickListener(addPetal);
        clearBtn.setOnClickListener(clearPetals);

        //SET THE CENTER COORDINATE
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        myFlower.set_xCenter(metrics.widthPixels / 2 - 100);
        myFlower.set_yCenter(metrics.heightPixels / 2);

    }

    private void initialize(){
        //TASK 1: INITIALIZE THE SETTINGS FOR THE FIRST PETAL

        myFlower.setRotate(0);
        myFlower.setScaleX((float) .3);
        myFlower.setScaleY((float) .3);
        myFlower.setDegenerate((float) 1.001);
        myFlower.initializeAngle();

    }

    private View.OnClickListener addPetal = new View.OnClickListener() {
        public void onClick (View view) {


            //TASK 1:  GRAB THE CORRECT PETAL
            String buttonText = ((Button) view).getText().toString();
            ImageView petal;
            if (buttonText.equals("Add Pink"))
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_pink, null);
            else
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_gold, null);

            //TASK 2: SET THE VISUAL PROPERTIES OF THE PETAL
            petal.setX(myFlower.get_xCenter());
            petal.setY(myFlower.get_yCenter());
            petal.setPivotY(0);
            petal.setPivotX(100);
            petal.setScaleX(myFlower.getScaleX());
            petal.setScaleY(myFlower.getScaleY());
            petal.setRotation(myFlower.getRotate());

            //TASK 3: PLACE THE INFLATED IMAGEVIEW IN THE MAIN LAYOUT
            relativeLayout.addView(petal, 0);

            //TASK 4: ADD THE IMAGEVIEW OF THE PETAL TO THE ARRAYLIST
            allPetals.add(petal);

            //TASK 5: UPDATE THE ANGLE AND SCALE FOR THE NEXT PETAL TO BE ADDED
            myFlower.updatePetalValues();
        }
    };

    private View.OnClickListener clearPetals  = new View.OnClickListener() {
        public void onClick (View view) {
            //TASK 1: REMOVE ALL PETAL IMAGE VIEW FROM THE LAYOUT
            for (int i = 0; i < allPetals.size(); i++) {
                ImageView petal = allPetals.get(i);
                relativeLayout.removeView(petal);
            }

            //TASK 2: RESET ALL VARIABLES
            allPetals.clear();
            initialize();
        }
    };

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    } */


}
