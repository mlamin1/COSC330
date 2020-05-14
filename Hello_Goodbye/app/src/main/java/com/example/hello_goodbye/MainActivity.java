package com.example.hello_goodbye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean is_Hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        is_Hello = true;
    }

    public void next_page(View view){
        TextView tv = (TextView) findViewById(R.id.textView);
        if(is_Hello){
            tv.setText("Goodbye");
            is_Hello = false;
        }else{
            tv.setText("Hello");
            is_Hello = true;
        }
    }

}
