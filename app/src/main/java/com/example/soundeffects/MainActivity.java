package com.example.soundeffects;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonOne, buttonTwo, buttonThree, buttonFour;
    private int sound1, sound2, sound3, sound4;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();

        sound1 = soundPool.load(this, R.raw.complete, 1);
        sound2 = soundPool.load(this, R.raw.correct, 1);
        sound3 = soundPool.load(this, R.raw.defeat_one, 1);
        sound4 = soundPool.load(this, R.raw.defeat_two, 3);

        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.button_two:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_three:
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.button_four:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }
}