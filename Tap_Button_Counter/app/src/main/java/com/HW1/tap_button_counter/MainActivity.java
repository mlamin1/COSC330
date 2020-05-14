package com.HW1.tap_button_counter;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.util.Log.d;

//import static com.HW1.tap_button_counter.R.*;

public class MainActivity extends Activity {

    //MODEL
    private Counter count;

    //VIEW
    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();
        countView = (TextView) findViewById(R.id.textView);
    }

    public void countTap(View view) {
        count.addCount();
        countView.setText(count.getCount().toString());
        d("increment value", "Muniru:"+count.getCount());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        //This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.actions) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
