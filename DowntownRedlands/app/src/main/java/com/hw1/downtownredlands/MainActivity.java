package com.hw1.downtownredlands;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showmap(View view )
    {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
   /* public void showmap(android.view.View view)
    {
        Uri intentUri = Uri.parse("geo:34.055561, -117.182602");
        Intent RedMap = new Intent(Intent.ACTION_VIEW, intentUri);
        RedMap.setPackage("com.google.android.apps.maps");
        startActivity(RedMap);
    }*/
}
