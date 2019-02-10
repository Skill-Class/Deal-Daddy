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




/**
      @Author - Sheetal Kumar
      -------------------------------------
       In App - Main Intro Screen
       Objective -
       Todo - nothing
       Status - complete
      -------------------------------------
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

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /**
         **
         * Adding Animation to Views
         * Here using AnimationUtils
         */
        AddAnimationToView();

        /**
         **
         * calling sharApp function so that user and share this app.
         */
        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApp();
            }
        });

        /**
         **
         * Sending user to Main Activity from this Activity after user clicks on start button.
         */
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToMain();
            }
        });
    }

    private void sendToMain() {

        Intent intent = new Intent(IntroScreen.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_exit, R.anim.slide_out_right);
        finish();
    }

    private void AddAnimationToView() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        Animation animationNav = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        Animation animationBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);

        shareImageView.startAnimation(animation);
        logoImageView.startAnimation(animationNav);
        learnTextView.startAnimation(animationBottom);
        checkBox.startAnimation(animationBottom);

    }

    private void AddXMLToJava() {

        startbtn = findViewById(R.id.button3);
        shareImageView = findViewById(R.id.shareimageView);
        logoImageView = findViewById(R.id.logo);
        learnTextView = findViewById(R.id.textView4);
        checkBox = findViewById(R.id.checkBox);
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
            e.toString();
        }
    }
}
