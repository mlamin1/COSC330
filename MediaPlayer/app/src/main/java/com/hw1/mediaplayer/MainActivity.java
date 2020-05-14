package com.hw1.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create( this, R.raw.beats);
    }

    public void playSound(View view)
    {
        mp.start();
    }

    public void pauseSound(View view)
    {
        mp.pause();
    }

    public void stopSound(View view)
    {
        mp.stop();
        mp.release();
        mp = MediaPlayer.create( this, R.raw.beats);
    }
}
