package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dealdaddy.Adapter.RecyclerViewAdapterForHomeScreen;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForUpcomingProducts;
import com.example.dealdaddy.Model.ItemForHomeImages;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.Model.ItemsWithImageArrayList;
import com.example.dealdaddy.R;

import java.util.ArrayList;
import java.util.List;

public class UpcomingProducts extends AppCompatActivity {

    private ImageView backImage;
    private RecyclerView myRecycleView;
    private List<ItemsWithImage> itemsDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_products);



        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();




        /**
         **
         * Adding Static Data to ArrayLists
         * Will use list according to requirements
         */
        AddImagesIntoArrayLists();


        /**
         **
         * Adding Animation to Views
         * Here using AnimationUtils
         */
        AddAnimationToView();

        /**
         **
         * Adding adapter to recycler View so that it can be displayed.
         */
        AddAdapterAndLayoutIntoRecyclerView();


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpcomingProducts.this, IntroScreen.class));
                overridePendingTransition(R.anim.zoom_exit, R.anim.slide_out_right);
            }
        });
    }


    private void AddXMLToJava() {
        myRecycleView = findViewById(R.id.recyclerView);
        backImage = findViewById(R.id.imageView3);
    }

    private void AddImagesIntoArrayLists() {

        /**
         Here
         // productname = company name
         // prize = time
         //itemtype = product details
         */
        itemsDetails = new ArrayList<>();

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3,"WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "33 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.womenmodel1,"MODA RAPIDO", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "32 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.kid3,"ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3,"DIFFERENCE OF OPINION", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "23 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel2,"HIGHLANDER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "31 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel1,"WROGN", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "30 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3,"ETHER", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "13 Days To Go!", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.furniture3,"DIVINE CASA", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                "14 Days To Go!", false));



        /**
         **
         * created Lists of list so that we can handle multiple items for men, women, kids and furniture

         men :{item1,item2,item3,item4),
         women :{item1,item2,item3,item4},
         kids:{item1,item2,item3,item4},
         furniture :{item1,item2,item3,item4}

         */

    }

    private void AddAnimationToView() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        Animation animationNav = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        Animation animationBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);


    }

    private void AddAdapterAndLayoutIntoRecyclerView() {

       RecyclerViewAdapterForUpcomingProducts myAdapter = new RecyclerViewAdapterForUpcomingProducts(this, itemsDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        myRecycleView.setLayoutManager(layoutManager);
        myRecycleView.setAdapter(myAdapter);
    }

}
