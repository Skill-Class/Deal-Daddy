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
import android.widget.TextView;

import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItemsDetails;
import com.example.dealdaddy.Model.Slide;
import com.example.dealdaddy.Adapter.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;





/*
    @Author - Sheetal Kumar
    -------------------------------------
    In App - Activity with slider Adapter
    Attached adapter - RecyclerViewAdapterForItemDetails
    Objective -
    Todo - nothing
    Status - complete
    -------------------------------------

 */


public class DetailActivity extends AppCompatActivity {


    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private ImageView BackBtn;
    private TextView dealDaddyText;
    private Integer ModelImage;
    private List<ItemsWithImage> itemsDetails;
    private RecyclerView myrv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        /*
        fetching data from homescreen activity
         */
        getDataFromHomeScreen();

        /*
         **
         * Adding Static Data to ArrayLists
         * Will use list according to requirements
         */
        AddImagesIntoArrayLists();

        /*
        * sending to previous activity from this activity.
         */
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              sendTobackActivity();
            }
        });


        /*
         **
         * Adding adapter to recycler View so that it can be displayed.
         */
        AddAdapterAndLayoutIntoRecyclerView();

    }

    private void sendTobackActivity() {

        Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.animation_enter,R.anim.animation_leave);
        finish();

    }

    private void AddAdapterAndLayoutIntoRecyclerView() {


        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        sliderpager.setAdapter(adapter);

        // setup timer for slider
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new DetailActivity.SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);


        RecyclerViewAdapterForItemsDetails myAdapter = new RecyclerViewAdapterForItemsDetails(this, itemsDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);


    }

    private void AddImagesIntoArrayLists() {

        lstSlides = new ArrayList<>();
        itemsDetails = new ArrayList<>();


        lstSlides.add(new Slide(R.drawable.sliderimagetwo, "HIGHLANDER \nUp to 70% Off"));
        lstSlides.add(new Slide(R.drawable.sliderimagefour, "The Tracks & Tee Look \nMin. 50% Off"));
        lstSlides.add(new Slide(R.drawable.sliderimagethree, "Stylish Watches \nEnjoy Up To 40% Off On"));


        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel4,"WROGN", "Men Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel1,"Benetton", "Men Slim Fit Denim Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3,"Highlander", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel2,"BlackBerrys", "Men Slim Regular Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3,"WROGN", "Cotton Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel4,"Highlander", "Men Checked Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", " Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));



    }

    private void getDataFromHomeScreen() {

        //   ModelCategories = "Men";

        ModelImage = R.drawable.pic2;
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String ModelCat = bundle.getString("ModelType");
            // Integer ModelImage = bundle.getInt("ModelImage");
            dealDaddyText.setText(ModelCat);

        }

    }

    private void AddXMLToJava() {

        dealDaddyText = findViewById(R.id.dealDaddyText);
        BackBtn = findViewById(R.id.navicon);
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        myrv = findViewById(R.id.recyclerView);
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
    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.animation_enter,R.anim.animation_leave);
        finish();
        super.onBackPressed();  // optional depending on your needs
    }

}
