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

import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.Model.ItemsWithImage;
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

    private TextView dealDaddyText;
    private String ModelCat;
    private Integer ModelImage;
    private List<ItemsWithImage> itemsDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dealDaddyText = findViewById(R.id.dealDaddyText);
        // fetching data from homescreen activity


     //   ModelCat = "Men";
       ModelImage = R.drawable.pic2;

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String ModelCat = bundle.getString("ModelType");
           // Integer ModelImage = bundle.getInt("ModelImage");
            dealDaddyText.setText(ModelCat);

        }


        BackBtn = findViewById(R.id.navicon);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });



        lstSlides = new ArrayList<>();
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

       // itemsDetails = new ArrayList<>();


        String menUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmenimg.jpg?alt=media&token=2087538c-18e5-4dea-96bd-70c157020a84";
        String girlUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fmarcus-loke-751530-unsplash.jpg?alt=media&token=407d0b24-f24a-4a33-a4f8-4dc4bb82c347";
        String womelUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fann-danilina-671900-unsplash.jpg?alt=media&token=d8a12241-ceb1-42ca-97a8-f6d510d3aded";
        String kidsUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fjanko-ferlic-284664-unsplash.jpg?alt=media&token=2ccc0c14-fcc2-4408-9a1a-535574fbd1c9";
        String boysUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fsharon-garcia-498810-unsplash.jpg?alt=media&token=716005bd-9972-4053-9fd7-43687be09c22";
        String funitureUrl = "https://firebasestorage.googleapis.com/v0/b/dealdaddy-9622a.appspot.com/o/images%2Fnathan-fertig-249917-unsplash.jpg?alt=media&token=4c210b3e-43a4-4d7e-b633-2bc57ac63d1c";


        lstSlides.add(new Slide(R.drawable.pic2, "HIGHLANDER \nUp to 70% Off"));
       // lstSlides.add(new Slide(R.drawable.pic8, "Tiptoeing Into The Weekend! \nMIN. 40% OFF"));
        //lstSlides.add(new Slide(R.drawable.pic7, "FRENCH CONNECTION \nGame-Changing Picks At 40-70% Off"));
        lstSlides.add(new Slide(R.drawable.pic3, "The Tracks & Tee Look \nMin. 50% Off"));
        lstSlides.add(new Slide(R.drawable.pic4, "Stylish Watches \nEnjoy Up To 40% Off On"));
       // lstSlides.add(new Slide(R.drawable.pic7, "Sportswear To Keep You Fit & Fab ! \nMin. 30% Off"));


        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);

        sliderpager.setAdapter(adapter);


        itemsDetails = new ArrayList<>();

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));
        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(ModelImage,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));


      //  itemsDetails.add(new ItemsWithImage(R.drawable.pic6,"BlackBerrys", "Men Slim FIt Casual Shirt",
        //        "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

       // itemsDetails.add(new ItemsWithImage(R.drawable.pic7,"BlackBerrys", "Men Slim FIt Casual Shirt",
         //       "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));






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
