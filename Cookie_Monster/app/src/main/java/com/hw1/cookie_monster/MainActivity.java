package com.hw1.cookie_monster;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

//public class MainActivity extends AppCompatActivity {
    public class MainActivity extends Activity {

    //USED AS A BOOLEAN FOR THE HUNGRY IMAGE
    private boolean isHungry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isHungry = true;
    }


    public void NextPage(View view){

        //ESTABLISH REFERENCE TO TEXT AND IMAGE VIEWS
        TextView full_TextView = (TextView) findViewById(R.id.textView3);
        ImageView full_imgImageView = (ImageView) findViewById(R.id.imageView2);
        Button Done_btn = (Button) findViewById(R.id.button);


        if(isHungry){
            full_TextView.setText(R.string.full);
            full_imgImageView.setImageResource(R.drawable.full);
            Done_btn.setText(R.string.done_btn);
            isHungry = false;
        }else{
            full_TextView.setText(R.string.hungry);
            full_imgImageView.setImageResource(R.drawable.hungry);
            Done_btn.setText(R.string.eat_btn);
            isHungry = true;
        }

    }

}