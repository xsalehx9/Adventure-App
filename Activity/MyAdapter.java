package com.Horizon_Adventure_App.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.Horizon_Adventure_App.Domains.PopularDomain;
import com.bumptech.glide.Glide;
import com.com.Horizon_Adventure_App.Activity.R;

public class MyAdapter extends AppCompatActivity {
    private TextView titleTxt, locationTxt, bedTxt, guideTxt, wifiTxt, descriptionTxt, scoreTxt;
    private PopularDomain item;
    private ImageView picImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        titleTxt.setText(item.getTitle());
        scoreTxt.setText(""+ item.getScore());
        locationTxt.setText(item.getLocation());
        bedTxt.setText(item.getBed() + " Bed");
        descriptionTxt.setText(item.getDescription());

        if (item.isGuide()) {
            guideTxt.setText("Guide");
        } else {
            guideTxt.setText("No-Guide");
        }
        if (item.isWifi()) {
            wifiTxt.setText("Wifi");
        } else {
            wifiTxt.setText("No-Wifi");
        }
        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());

        Glide.with(this)
                .load(drawableResId)
                .into(picImg);

        backBtn.setOnClickListener(v -> finish());


    }

    private void initView() {
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        bedTxt = findViewById(R.id.bedTxt);
        guideTxt = findViewById(R.id.guideTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        picImg = findViewById(R.id.picImg);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn=findViewById(R.id.backBtn);
    }
}