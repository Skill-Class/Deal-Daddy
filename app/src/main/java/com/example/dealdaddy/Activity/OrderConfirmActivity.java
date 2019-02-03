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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItems;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForItemsDetails;
import com.example.dealdaddy.Adapter.RecyclerViewAdapterForOrderConfirm;
import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.R;

import java.util.ArrayList;
import java.util.List;

public class OrderConfirmActivity extends AppCompatActivity {

    ImageView BackBtn;

    private List<Items> itemsDetails;

    private Spinner spinnerSize;
    private Spinner spinnerQty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        BackBtn = findViewById(R.id.navicon);
        spinnerSize = findViewById(R.id.spinner);

        //Spinner will be added later.
        // it will be implemented in Order Confirm adapter class.





        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderConfirmActivity.this, AboutItemActivity.class);
                startActivity(intent);
            }
        });


        itemsDetails = new ArrayList<>();


        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new Items("BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapterForOrderConfirm myAdapter = new RecyclerViewAdapterForOrderConfirm(this, itemsDetails);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);


    }

}
