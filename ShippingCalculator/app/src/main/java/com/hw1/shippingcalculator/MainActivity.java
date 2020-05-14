package com.hw1.shippingcalculator;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    //DATA MODEL FOR SHIP ITEM
    private Shipitem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TASK 1: SET ACTIVITY CONTENT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED
        shipItem = new Shipitem();

        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT
        weightET = (EditText) findViewById(R.id.editText1);

        //TASK 4: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //TASK 4: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT
        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        public void onTextChanged(CharSequence s,
                                  int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                      int start, int count, int after){}
    };

    private void displayShipping() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        baseCostTV.setText("$" + String.format("%.02f",
                shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",
                shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",
                shipItem.getTotalCost()));
    }

    /*
    @Override
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
