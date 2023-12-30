package com.Horizon_Adventure_App.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Horizon_Adventure_App.Adapters.CategoryAdapter;
import com.Horizon_Adventure_App.Adapters.PupolarAdapter;
import com.Horizon_Adventure_App.Domains.CategoryDomain;
import com.Horizon_Adventure_App.Domains.PopularDomain;
import com.com.Horizon_Adventure_App.Activity.R;

import java.util.ArrayList;
import java.util.List;

public class Paragliding extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parglide);

        initRecyclerView();
    }

    @SuppressLint({"ResourceType", "WrongViewCast"})
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Magan fly", " Oman / Barka", "The Paramotor Tandem flight takes approximately 15-25 mins per round. Our specialty instructor will take you on the special flight from the airfield of Sawadi Beach during the spectacular Sunrise and Sunset.", 2, true, 4.8, "magan_fly", true, 140));
        items.add(new PopularDomain("Adventures Sprot", "Oman / Salalh", "Adventure Sports team has 20 years+ of experience in operating Water Sports & Aviation Sports centers. All team members are multilingual, well trained to comply with the highest safety standards and enjoy sharing their passion of water sports & Aviation Sports with guests. Team members hold internationally accepted valid Master instructor and instructor degree licenses. A registered and certified.", 1, false, 5, "adevantrejpg", false, 130));
        items.add(new PopularDomain("Tourista", "Oman / Muscat", "I am thrilled to connect my unique background of being a tour planner in Muscat and allowed me to develop an intimate knowledge of the city's hidden gems, cultural heritage, and local traditions that will undoubtedly enhance the travel experience for visitors. Furthermore, my fluency in Arabic and extensive network of connections within the community allow me to bridge any language or cultural gaps between travelers and locals, ensuring a seamless and immersive experience for all involved.", 3, true, 4.3, "musandam_peninsula", true, 100));

        recyclerViewPopular = findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterPopular = new PupolarAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);


        ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches", "cat1"));
        catsList.add(new CategoryDomain("Camps", "cat2"));
        catsList.add(new CategoryDomain("Forest", "cat3"));
        catsList.add(new CategoryDomain("Desert", "cat4"));
        catsList.add(new CategoryDomain("Mountain", "cat5"));

        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);



    }

}