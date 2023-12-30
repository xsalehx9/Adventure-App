package com.Horizon_Adventure_App.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.com.Horizon_Adventure_App.Activity.R;

public class MainActivity extends AppCompatActivity {

    Button buttonlo;
    Button buttonlo2;
    VideoView videoA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonlo = findViewById(R.id.button);
        buttonlo2 = findViewById(R.id.button2);
        videoA = findViewById(R.id.videoA);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intro);
        videoA.setVideoURI(uri);
        videoA.start();

        videoA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });


        buttonlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });

        buttonlo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPostResume() {
        videoA.resume();
        super.onPostResume();
    }
    @Override
    protected void onRestart() {
        videoA.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoA.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoA.stopPlayback();
        super.onDestroy();
    }

}