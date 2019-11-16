package com.example.fly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    Button b;
    MediaPlayer bird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bird=MediaPlayer.create(MainActivity.this,R.raw.background);
        bird.start();

        b=findViewById(R.id.player2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .playOn(b);

                Intent i=new Intent(getApplicationContext(),player2fly.class);
                startActivity(i);
            }
        });





    }

    @Override
    protected void onPause() {
        super.onPause();
        bird.release();
        finish();
    }
}
