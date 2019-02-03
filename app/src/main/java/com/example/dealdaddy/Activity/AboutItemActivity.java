package com.example.dealdaddy.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItemsDetails;
import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;

import java.util.ArrayList;
import java.util.List;

public class AboutItemActivity extends AppCompatActivity {

    private ImageView BackBtn;
    private Button bagButton;

    private List<ItemsWithImage> itemsDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_item);

        BackBtn = findViewById(R.id.navicon);
        bagButton = findViewById(R.id.button);

        bagButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                bagButton.setText("VIEW BAG");
                bagButton.setBackgroundColor(R.color.colorAccent);

                Intent intent =new Intent(AboutItemActivity.this,OrderConfirmActivity.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutItemActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });


        itemsDetails = new ArrayList<>();

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3,"Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9,"Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3,"Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9,"Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3,"Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9,"Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic2,"BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3,"Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9,"Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapterForItemsDetails myAdapter = new RecyclerViewAdapterForItemsDetails(this, itemsDetails);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);
    }
}
