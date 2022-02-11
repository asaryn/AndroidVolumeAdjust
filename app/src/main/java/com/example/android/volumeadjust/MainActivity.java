package com.example.android.volumeadjust;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create new MediaPlayer object
        //reply1988 is the audio source
        MediaPlayer audio = MediaPlayer.create(this, R.raw.reply1988);

        //Create new AudioManager object
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

    /*   *Make the button with the id "play_button" functional
        * By default, the audio is not playing, until the button is clicked (else statement is being run).
        * Then, when the button is clicked again, it executes what's inside the if statement,
        * because it is true that the audio is playing, and the song will be paused.*/

        Button playAudio = findViewById(R.id.play_button);
        playAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(audio.isPlaying()){
                    audio.pause();
                    playAudio.setText("RESUME");
                } else {
                    audio.start();
                    audio.setLooping(true);
                    playAudio.setText("PAUSE");
                }
            }
        });


        /* Add functionality to "volume_down" button in the XML
        * It will decrease the volume*/
        Button volumeDown = findViewById(R.id.volume_down);
        volumeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        });

        /* Add functionality to "volume_up" button in the XML
         * It will increase the volume*/
        Button volumeUp = findViewById(R.id.volume_up);
        volumeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        });
    }
}