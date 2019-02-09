package com.example.dealdaddy.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dealdaddy.Adapter.RecyclerViewAdapterForHomeScreen;
import com.example.dealdaddy.Model.ItemForHomeImages;
import com.example.dealdaddy.Model.ItemsWithImageArrayList;
import com.example.dealdaddy.R;

import java.util.ArrayList;
import java.util.List;


/**
      @Author - Sheetal Kumar
      -------------------------------------
      In App - Main HomeScreen
      Attached adapter - RecyclerViewAdapterForHomeScreen
      Objective -
      Todo - nothing
      Status - complete
      -------------------------------------

 */

public class MainActivity extends AppCompatActivity {

    private ImageView bagImage, navicon;
    private TextView bottomTextView;
    private View viewLast;

    private List<ItemForHomeImages> itemForHomeImages;
    private RecyclerView recyclerView;

    private List<ItemsWithImageArrayList> itemsWithImageArrayLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }

    private void AddXMLToJava() {

        bagImage = findViewById(R.id.imageView7);
        navicon = findViewById(R.id.navicon);
        bottomTextView = findViewById(R.id.bottomTextView);
        viewLast = findViewById(R.id.viewlast);
        recyclerView = findViewById(R.id.recyclerView);

    }

    private void AddAdapterAndLayoutIntoRecyclerView() {

        RecyclerViewAdapterForHomeScreen myAdapter = new RecyclerViewAdapterForHomeScreen(this, itemsWithImageArrayLists);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    private void AddAnimationToView() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        Animation animationNav = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        Animation animationBottom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_to_up);

        bagImage.startAnimation(animation);
        navicon.startAnimation(animationNav);
        viewLast.startAnimation(animationBottom);
        bottomTextView.startAnimation(animationBottom);
    }

    private void AddImagesIntoArrayLists() {

        /**
        Here
        Company name = Categories
        */

        itemForHomeImages = new ArrayList<>();
        itemsWithImageArrayLists = new ArrayList<>();

        itemForHomeImages.add(new ItemForHomeImages(R.drawable.menmodel1, R.drawable.womenmodel5, R.drawable.kid3, R.drawable.furniture1));
        itemForHomeImages.add(new ItemForHomeImages(R.drawable.menmodel2, R.drawable.womenmodel2, R.drawable.kid4, R.drawable.furniture3));
        itemForHomeImages.add(new ItemForHomeImages(R.drawable.menmodel3, R.drawable.womenmodel3, R.drawable.kid5, R.drawable.furniture4));
        itemForHomeImages.add(new ItemForHomeImages(R.drawable.pic2, R.drawable.womenmodel4, R.drawable.kid4, R.drawable.furniture5));


        /**
        **
        * created Lists of list so that we can handle multiple items for men, women, kids and furniture

         men :{item1,item2,item3,item4),
         women :{item1,item2,item3,item4},
         kids:{item1,item2,item3,item4},
         furniture :{item1,item2,item3,item4}

          */
        itemsWithImageArrayLists.add(new ItemsWithImageArrayList(itemForHomeImages, R.drawable.menmodel4, "Men", "Men Slim Fit Casual Shirt", "hello", false));
        itemsWithImageArrayLists.add(new ItemsWithImageArrayList(itemForHomeImages, R.drawable.womenmodel1, "Women", "Women Slim Fit Casual Shirt", "hello", false));
        itemsWithImageArrayLists.add(new ItemsWithImageArrayList(itemForHomeImages, R.drawable.kid3, "Kids", "Kids Slim Fit Casual Shirt", "hello", false));
        itemsWithImageArrayLists.add(new ItemsWithImageArrayList(itemForHomeImages, R.drawable.furniture3, "Furniture", "Home and Living", "hello", false));

    }
}
