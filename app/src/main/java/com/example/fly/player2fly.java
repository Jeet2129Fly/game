package com.example.fly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class player2fly extends AppCompatActivity {

    private ImageView image1;
    private int[] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;
    private Button button1;
    private Button button2;
    private TextView textView1;
    private TextView textView2;
    int i = 0;
    boolean button1Pressed = true;
    boolean button2Pressed = true;
    HashMap<Integer, Integer> map = new HashMap<>();
    Button button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2fly);
        map.put(R.drawable.img_0, 0);
        map.put(R.drawable.img_1, 1);
        map.put(R.drawable.img_2, 1);
        map.put(R.drawable.img_3, 0);
        map.put(R.drawable.img_4, 0);
        map.put(R.drawable.img_5, 1);
        map.put(R.drawable.img_6, 0);
        map.put(R.drawable.img_7, 0);
        image1 = (ImageView) findViewById(R.id.imagRandom);
        imageArray = new int[8];
        imageArray[0] = R.drawable.img_0;
        imageArray[1] = R.drawable.img_1;
        imageArray[2] = R.drawable.img_2;
        imageArray[3] = R.drawable.img_3;
        imageArray[4] = R.drawable.img_4;
        imageArray[5] = R.drawable.img_5;
        imageArray[6] = R.drawable.img_6;
        imageArray[7] = R.drawable.img_7;

        startIndex = 0;
        endIndex = 7;

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        refreshImage();

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshImage();
            }
        });

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button1Pressed = true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button1Pressed = false;
                }
                return true;
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button2Pressed = true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button2Pressed = false;
                }
                return true;
            }
        });
    }

    public void refreshImage() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                if (i < imageArray.length) {
                    image1.setImageResource(imageArray[i]);
                    handler.postDelayed(this, 2000);  //for interval...
                    if (map.get(imageArray[i]) == 1) {
                        if (!button1Pressed && !button2Pressed)
                            Toast.makeText(player2fly.this, "Both Player Lose", Toast.LENGTH_SHORT).show();
                        else if (!button1Pressed) {
                            Toast.makeText(player2fly.this, "Player One Lose", Toast.LENGTH_SHORT).show();
                        } else if (!button2Pressed) {
                            Toast.makeText(player2fly.this, "Player Two Lose", Toast.LENGTH_SHORT).show();
                        }
                    } else if (map.get(imageArray[i]) == 0) {
                        if (button1Pressed && button2Pressed)
                            Toast.makeText(player2fly.this, "Both Player Lose", Toast.LENGTH_SHORT).show();
                        else if (button1Pressed) {
                            Toast.makeText(player2fly.this, "Player One Lose", Toast.LENGTH_SHORT).show();
                        } else if (button2Pressed) {
                            Toast.makeText(player2fly.this, "Player Two Lose", Toast.LENGTH_SHORT).show();
                        }
                    }
                    i++;
                }
            }
        };
        handler.postDelayed(runnable, 0); //for initial delay..
    }

   /* public void nextImage() {
        image1.setImageResource(imageArray[currentIndex]);
        Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        image1.startAnimation(rotateimage);


    }*/


}