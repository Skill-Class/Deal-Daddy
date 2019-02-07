package com.example.dealdaddy.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dealdaddy.R;




/*
      @author - Sheetal Kumar
 */



public class IntroScreen extends AppCompatActivity {

    Button startbtn;
    ImageView shareImageView, logoImageView;
    TextView learnTextView;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        startbtn = findViewById(R.id.button3);

        shareImageView = findViewById(R.id.shareimageView);
        logoImageView = findViewById(R.id.logo);
        learnTextView = findViewById(R.id.textView4);
        checkBox = findViewById(R.id.checkBox);


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        Animation animationNav = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        Animation animationBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);

        shareImageView.startAnimation(animation);
        logoImageView.startAnimation(animationNav);
        //   startbtn.startAnimation(animationBottom);
        learnTextView.startAnimation(animationBottom);
        checkBox.startAnimation(animationBottom);

        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApp();
            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntroScreen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_exit,R.anim.slide_out_right);
                finish();
            }
        });
    }

    private void shareApp() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "DealDaddy");
            String shareMessage = "\nLet me recommend you this application\n\n";
            //shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareMessage = "Dealdaddy is a super cool app.";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "Please select your option"));
        } catch (Exception e) {
            //e.toString();
        }
    }
}
