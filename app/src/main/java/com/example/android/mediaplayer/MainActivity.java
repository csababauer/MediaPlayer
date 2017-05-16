package com.example.android.mediaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.example.android.mediaplayer.R.id.play;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private SeekBar sb;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize media player
        mp = MediaPlayer.create(MainActivity.this, R.raw.kidkoala);

        sb = (SeekBar) findViewById(R.id.seekBar);
        //sb.setMax(100);
        sb.setProgress(7);



        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //sb.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));

        //onclick listener for play button
        Button playMusic = (Button) findViewById(play);
        playMusic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                mp.start();
                Toast.makeText(MainActivity.this, "Kid Koala", Toast.LENGTH_SHORT).show();
            }
        });

        //onclick listener for pause button
        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                mp.pause();
            }
        });

        //onclick listener for volume seekbar
        SeekBar volume = (SeekBar) findViewById(R.id.seekBar);
        volume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                mp.pause();
            }
        });

        //seekbar sets volume
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
