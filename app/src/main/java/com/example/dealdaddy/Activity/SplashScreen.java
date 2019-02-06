package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dealdaddy.Activity.MainActivity;
import com.example.dealdaddy.R;

public class SplashScreen extends AppCompatActivity {

    private ImageView logo;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        logo = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        Animation animationLogo= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_exit);
        Animation animationText= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);

        logo.startAnimation(animationLogo);
        textView.startAnimation(animationText);

    }


      @Override
    protected void onStart() {
        super.onStart();
        final Intent intent = new Intent(this, IntroScreen.class);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                    finish();
                }
            }
        };
        timer.start();
    }


}