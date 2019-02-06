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

public class OrderConfirmActivity extends AppCompatActivity {

    ImageView BackBtn;
    Button proceedBtn;

    private List<ItemsWithImage> itemsDetails;

    private Spinner spinnerSize;
    private Spinner spinnerQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        BackBtn = findViewById(R.id.navicon);
        spinnerSize = findViewById(R.id.spinner);
        proceedBtn = findViewById(R.id.button2);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderConfirmActivity.this, CheckoutActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_exit, R.anim.slide_out_right);
            }
        });

        //Spinner will be added later.
        // it will be implemented in Order Confirm adapter class.


        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderConfirmActivity.this, AboutItemActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
        });


        itemsDetails = new ArrayList<>();


        itemsDetails.add(new ItemsWithImage(R.drawable.pic2, "BlackBerrys", "Men Slim FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic3, "Levis", "Men Regular FIt Casual Shirt",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));

        itemsDetails.add(new ItemsWithImage(R.drawable.pic9, "Roadster", "Men Skinny Fit Jeans",
                "\\u20B9 1245  \\u20B9 2490 (40% Off)", false));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapterForOrderConfirm myAdapter = new RecyclerViewAdapterForOrderConfirm(this, itemsDetails);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        myrv.setLayoutManager(layoutManager);
        myrv.setAdapter(myAdapter);


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
