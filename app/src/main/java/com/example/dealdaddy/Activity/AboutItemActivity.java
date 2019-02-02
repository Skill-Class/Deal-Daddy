package com.example.dealdaddy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dealdaddy.R;

public class AboutItemActivity extends AppCompatActivity {

    private ImageView BackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_item);

        BackBtn = findViewById(R.id.navicon);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutItemActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
