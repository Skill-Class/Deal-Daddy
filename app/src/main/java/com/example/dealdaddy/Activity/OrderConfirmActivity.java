package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItems;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItemsDetails;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForOrderConfirm;
import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;

import java.util.ArrayList;
import java.util.List;



/**
      @Author - Sheetal Kumar
      -------------------------------------
      In App - OrderConformation Activity
      Attached adapter - RecyclerViewAdapterForOrderConfirm
      Objective -
      Todo - have use to dynamic data according to user's preferences
      Status - incomplete
      -------------------------------------

 */


public class OrderConfirmActivity extends AppCompatActivity {

    private ImageView BackBtn;
    private Button proceedBtn;
    private List<ItemsWithImage> itemsDetails;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        /**
         **
         * Connecting all XML views to java file using findViewById
         */
        AddXMLToJava();


        //sending user to checkout activity from current activity.
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendToCheckOurActivity();
            }
        });

        //Spinner will be added later.
        // it will be implemented in Order Confirm adapter class.

        //sending user to previous activity
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

    private void AddImagesIntoArrayLists() {

        itemsDetails = new ArrayList<>();

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

    }

    private void AddAdapterAndLayoutIntoRecyclerView() {

        RecyclerViewAdapterForOrderConfirm myAdapter = new RecyclerViewAdapterForOrderConfirm(this, itemsDetails);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }

    private void sendToBackActivity() {

        Intent intent = new Intent(OrderConfirmActivity.this, AboutItemActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }

    private void sendToCheckOurActivity() {

        Intent intent = new Intent(OrderConfirmActivity.this, CheckoutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_exit, R.anim.slide_out_right);
    }

    private void AddXMLToJava() {

        BackBtn = findViewById(R.id.navicon);
        proceedBtn = findViewById(R.id.button2);
        recyclerView = findViewById(R.id.recyclerView);

    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        Intent intent = new Intent(OrderConfirmActivity.this, AboutItemActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_enter,R.anim.animation_leave);
        finish();
        super.onBackPressed();  // optional depending on your needs
    }


}
