package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.R;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItemsDetails;
import com.example.dealdaddy.Model.Slide;
import com.example.dealdaddy.Adapter.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity {


    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private ImageView BackBtn;

    private List<Items> itemsDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        BackBtn = findViewById(R.id.navicon);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        lstSlides = new ArrayList<>();
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

        itemsDetails = new ArrayList<>();


        String menUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmenimg.jpg?alt=media&token=2087538c-18e5-4dea-96bd-70c157020a84";
        String girlUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmarcus-loke-751530-unsplash.jpg?alt=media&token=407d0b24-f24a-4a33-a4f8-4dc4bb82c347";
        String womelUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fann-danilina-671900-unsplash.jpg?alt=media&token=d8a12241-ceb1-42ca-97a8-f6d510d3aded";
        String kidsUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fjanko-ferlic-284664-unsplash.jpg?alt=media&token=2ccc0c14-fcc2-4408-9a1a-535574fbd1c9";
        String boysUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fsharon-garcia-498810-unsplash.jpg?alt=media&token=716005bd-9972-4053-9fd7-43687be09c22";
        String funitureUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fnathan-fertig-249917-unsplash.jpg?alt=media&token=4c210b3e-43a4-4d7e-b633-2bc57ac63d1c";


        lstSlides.add(new Slide(menUrl, "HIGHLANDER \nUp to 70% Off"));
        lstSlides.add(new Slide(womelUrl, "Tiptoeing Into The Weekend! \nMIN. 40% OFF"));
        lstSlides.add(new Slide(kidsUrl, "FRENCH CONNECTION \nGame-Changing Picks At 40-70% Off"));
        lstSlides.add(new Slide(boysUrl, "The Tracks & Tee Look \nMin. 50% Off"));
        lstSlides.add(new Slide(girlUrl, "Stylish Watches \nEnjoy Up To 40% Off On"));
        lstSlides.add(new Slide(funitureUrl, "Sportswear To Keep You Fit & Fab ! \nMin. 30% Off"));


        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);

        sliderpager.setAdapter(adapter);


        itemsDetails = new ArrayList<>();

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Wrangler", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("United Colors of Benetton", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("WROGN", "Men Regular Fit Joggers",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Mast & Harbour", "Men Slim FIt Chinos",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Nike", "Men Air Force 1 HIGH Sneakers",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Mast & Harbour", "Men Sneakers",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Nike", "Men Running Shoes",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Peter England", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Reebok", "Men Stride Slip On Running",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Reebok", "Hurtle Running Shoes",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Levis", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Peter England", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Wrangler", "Men Regular Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Titan", "Men Dial Watch",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Nautica", "Men Deodrant & Perfume Set",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("Fossil", "Men Analogue Watch",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapterForItemsDetails myAdapter = new RecyclerViewAdapterForItemsDetails(this, itemsDetails);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);


        // setup timer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new DetailActivity.SliderTimer(), 4000, 6000);


        indicator.setupWithViewPager(sliderpager, true);


    }

    class SliderTimer extends TimerTask {


        @Override
        public void run() {

            DetailActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    } else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }

}
