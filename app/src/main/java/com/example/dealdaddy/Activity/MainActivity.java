package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dealdaddy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ImageView menImageView, womenImageView, kidsImageView, boysImageView, girlsImageView, furnitureImageView;
    private ImageView bagImage, navicon;

    private CardView cardViewone;
    private TextView bottomTextView;
    private View viewLast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menImageView = findViewById(R.id.imageView1);
        womenImageView = findViewById(R.id.imageView2);
        boysImageView = findViewById(R.id.imageView3);
        kidsImageView = findViewById(R.id.imageView4);
        girlsImageView = findViewById(R.id.imageView6);
        furnitureImageView = findViewById(R.id.imageView5);
        bagImage = findViewById(R.id.imageView7);
        navicon = findViewById(R.id.navicon);

        bottomTextView=findViewById(R.id.bottomTextView);
        viewLast = findViewById(R.id.viewlast);


        cardViewone = findViewById(R.id.cardView1);
        cardViewone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        Animation animationNav = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        Animation animationBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);

        bagImage.startAnimation(animation);
        navicon.startAnimation(animationNav);
        viewLast.startAnimation(animationBottom);
        bottomTextView.startAnimation(animationBottom);


        String menUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmenimg.jpg?alt=media&token=2087538c-18e5-4dea-96bd-70c157020a84";
        String girlUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmarcus-loke-751530-unsplash.jpg?alt=media&token=407d0b24-f24a-4a33-a4f8-4dc4bb82c347";
        String womelUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fann-danilina-671900-unsplash.jpg?alt=media&token=d8a12241-ceb1-42ca-97a8-f6d510d3aded";
        String kidsUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fjanko-ferlic-284664-unsplash.jpg?alt=media&token=2ccc0c14-fcc2-4408-9a1a-535574fbd1c9";
        String boysUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fsharon-garcia-498810-unsplash.jpg?alt=media&token=716005bd-9972-4053-9fd7-43687be09c22";
        String funitureUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fnathan-fertig-249917-unsplash.jpg?alt=media&token=4c210b3e-43a4-4d7e-b633-2bc57ac63d1c";

        Picasso.with(this)
                .load(menUrl)
                .into(menImageView);

        Picasso.with(this)
                .load(womelUrl)
                .into(womenImageView);

        Picasso.with(this)
                .load(kidsUrl)
                .into(kidsImageView);

        Picasso.with(this)
                .load(boysUrl)
                .into(boysImageView);

        Picasso.with(this)
                .load(girlUrl)
                .into(girlsImageView);

        Picasso.with(this)
                .load(funitureUrl)
                .into(furnitureImageView);

    }
}
