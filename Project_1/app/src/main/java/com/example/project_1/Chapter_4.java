package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import android.os.Bundle;
import android.widget.Toast;

public class Chapter_4 extends AppCompatActivity {

    private String description[] = {"This is Maria",
            "Maria was sick",
            "She does not want to go to the hospital",
            "She had a bad cough",
            "She could not breath",
            "Maria calls the doctor",
            "And asks for an interpreter",
            "Her husband drives her to the hospital",
            "The register ask Maria for her name",
            "Also ask her for her insurance",
            "And then her health card",
            "Then gives Maria a form to fill out",
            "Maria ended up staying in the hospital for 3 days"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_4);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        Toast.makeText(getApplicationContext(), description[0], Toast.LENGTH_LONG).show();
        viewPager.addOnPageChangeListener(myOnPageChangeListener);
    }

    OnPageChangeListener myOnPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Toast.makeText(getApplicationContext(), description[position], Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
