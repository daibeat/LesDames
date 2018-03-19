package com.example.android.musicstructureapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class DamesActivity extends AppCompatActivity {

    /**
     * Handles playback of  the sound file
     */

    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproduccion);

        mMediaPlayer = MediaPlayer.create(this, R.raw.shortsong);


        ImageButton playButton = (ImageButton) findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(DamesActivity.this,"I'm done!",Toast.LENGTH_SHORT).show();
                        finish(); // finish current activity
                    }
                });
            }
        });
        ImageButton pauseButton = (ImageButton) findViewById(R.id.pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.pause();
            }
        });



    }
    }

