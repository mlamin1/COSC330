package com.hw1.c_curve;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends Activity {

    private RelativeLayout relativeLayout;
    private TextView levelsTV;
    private Integer level;

    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout)
                findViewById(R.id.relativeLayout);
        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);

        level = 1;
        levelsTV = (TextView) findViewById(R.id.textView5);
    }

    public void drawFractal(View view) {
        fractalView.level = level;
        fractalView.invalidate();
        // levelsTV.setText(level.toString());
    }

    // NUMBERS FOR STEP UP AND STEP DOWN CAN RANGE FROM 1 THROUGH 14
    public void stepUp(View view) {
        if (level < 14) {
            level++;
            levelsTV.setText(level.toString());
        }
    }

    public void stepDown(View view) {
        if (level > 1) {
            level--;
            levelsTV.setText(level.toString());
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
    }*/

}
