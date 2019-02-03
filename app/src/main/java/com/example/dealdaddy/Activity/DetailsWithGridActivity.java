package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.R;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItems;

import java.util.ArrayList;
import java.util.List;

public class DetailsWithGridActivity extends AppCompatActivity {

    private List<Items> itemsDetails;
    private ImageView BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_with_grid);

        BackBtn = findViewById(R.id.navicon);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsWithGridActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

      //  String priceString =getResources().getString(R.string.priceString);


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
        RecyclerViewAdapterForItems myAdapter = new RecyclerViewAdapterForItems(this,itemsDetails);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);

    }
}
