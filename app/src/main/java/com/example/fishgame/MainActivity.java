package com.example.fishgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mysong;
    private FlyingFishView gameView;
    private Handler handelar=new Handler();
    private final static long Intervel=30;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.t);
        mysong.start();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameView=new FlyingFishView(this);

        setContentView(gameView);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handelar.post(new Runnable() {
                    @Override
                    public void run() {
                            gameView.invalidate();
                    }
                });
            }
        },0,Intervel);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysong.stop();
    }
}
