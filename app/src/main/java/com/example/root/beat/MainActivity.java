package com.example.root.beat;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    MediaPlayer mediaPlayer,mediaPlayer2;
    SoundPool soundPool;
    Random crazy=new Random();
    int explode=0;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        v=new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mediaPlayer=MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer2=MediaPlayer.create(this,R.raw.soundtrack);
        mediaPlayer.start();
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explode=soundPool.load(this,R.raw.explosion,1);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(256),crazy.nextInt(256),crazy.nextInt(256)));

    }

    @Override
    public void onClick(View view) {

        if(explode!=0)
        {
            soundPool.play(explode,1,1,0,0,1);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.stop();
      mediaPlayer2.stop();
        if(explode!=0)
        {
            soundPool.play(explode,1,1,0,0,1);
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mediaPlayer2.start();
        v.setBackgroundColor(Color.rgb(crazy.nextInt(256),crazy.nextInt(256),crazy.nextInt(256)));
        mediaPlayer.start();
        return true;
    }
}
