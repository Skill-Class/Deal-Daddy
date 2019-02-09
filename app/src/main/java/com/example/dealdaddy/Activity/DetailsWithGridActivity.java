package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItems;

import java.util.ArrayList;
import java.util.List;


/**
    @Author - Sheetal Kumar
    -------------------------------------
    In App - Activity with Grid
    Attached adapter - RecyclerViewAdapterForItem
    Objective - To show items available for user
    Todo - have to update data from firebase
    Status - incomplete
    -------------------------------------

 */


public class DetailsWithGridActivity extends AppCompatActivity {

    private List<ItemsWithImage> itemsDetails;
    private ImageView BackBtn;
    private RecyclerView myrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_with_grid);

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();

        //sending user to back activity after back button clicked.
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToBackActivity();
            }
        });

        /**
         **
         * Adding Static Data to ArrayLists
         * Will use list according to requirements
         */
        AddImagesIntoArrayLists();

        /**
         **
         * Adding adapter to recycler View so that it can be displayed.
         */
        AddAdapterAndLayoutIntoRecyclerView();


    }

    private void AddAdapterAndLayoutIntoRecyclerView() {

        RecyclerViewAdapterForItems myAdapter = new RecyclerViewAdapterForItems(this, itemsDetails);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);
    }


    private void AddImagesIntoArrayLists() {

        itemsDetails = new ArrayList<>();

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel2, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel1, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel4, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel4, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));
        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel1, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel2, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel1, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel4, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.menmodel3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

    }

    private void sendToBackActivity() {

        Intent intent1 = new Intent(DetailsWithGridActivity.this, DetailActivity.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);

    }

    private void AddXMLToJava() {

        BackBtn = findViewById(R.id.navicon);
        myrv = findViewById(R.id.recyclerView);

    }

    @Override
    public void onBackPressed() {

        // code here to show dialog
        Intent intent1 = new Intent(DetailsWithGridActivity.this, DetailActivity.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        finish();
        super.onBackPressed();  // optional depending on your needs

    }
}
