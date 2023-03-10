package com.hackuniv.mysoundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import com.hackuniv.mysoundpool.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    private SoundPool soundPool;
    private int sound1,sound2,sound3,sound4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();

        sound1 = soundPool.load(this,R.raw.complete,1);
        sound2 = soundPool.load(this,R.raw.correct,1);
        sound3 = soundPool.load(this,R.raw.defeat_one,1);
        sound4 = soundPool.load(this,R.raw.defeat_two,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //play for button first
                soundPool.play(sound1,1,1,0,0,1);
                break;
            case R.id.button2:
                //play for button first
                soundPool.play(sound2,1,1,0,0,1);
                break;
            case R.id.button3:
                //play for button first
                soundPool.play(sound3,1,1,0,0,1);
                break;
            case R.id.button4:
                //play for button first
                soundPool.play(sound4,1,1,0,0,1);
                break;
        }
    }
}