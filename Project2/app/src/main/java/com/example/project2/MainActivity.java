package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

      //TEST FUNCTION
    public void goToTest(View view){
        Intent intent = new Intent(this, MainAct.class);
        intent.putExtra("StrategyChosen", str);
        startActivity(intent);
    }


    public void strategyradioClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();
            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButton:
                    if (checked)
                        str = "strategy1";
                        break;
                case R.id.radioButton1:
                    if (checked)
                        str = "strategy2";
                        break;
                case R.id.radioButton2:
                    if (checked)
                        str = "strategy3";
                        break;
                case R.id.radioButton3:
                    if(checked)
                        str = "strategy4";
                        break;
            }

    }
}
