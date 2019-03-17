package com.example.dealdaddy.Activity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dealdaddy.R;

public class UpcomingProductsDetailsAcitivity extends AppCompatActivity {


    private ImageView modelImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_products_details_acitivity);

        modelImage = findViewById(R.id.imageView4);


    }
}
