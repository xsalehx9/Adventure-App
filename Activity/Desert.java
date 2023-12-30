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

public class Desert extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);

        initRecyclerView();
    }

    @SuppressLint({"ResourceType", "WrongViewCast"})
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Wahiba Sands", "Oman / Sharqiya", "Considered among the most beautiful camping areas in Oman, the Sharqiya Sands extends over an area of up to ten thousand square kilometres! Tourists get the chance to indulge in the true Arabian experience which is a rarity due to the amount of globalisation that has occured over the past years. The most popular activities at the Sharqiya Sands are dune bashing and going on a camel safari.", 2, true, 4.8, "wahiba_sands", true, 100));
        items.add(new PopularDomain("Bawsher Sands", "Oman / Muscat", "Located not very far from the beaches of Muscat with its harmonious architecture, Bawshar sands are an excellent place to enjoy the dunes with SUVs. Bawshar Sands also allows visitors to glide on their rented sand bikes. One can also climb up the sandhills and get a beautiful view of the sunsets.", 1, false, 5, "bawshar", false, 80));
        items.add(new PopularDomain("Ramlat Tawq", "Oman / Muscat", "Ramlat Tawq is a desert with beautiful sand dunes, occupying over 10,000 kilometres. It is a very popular tourist attraction as the desert is situated very close to the capital city, Muscat.", 3, true, 4.3, "ramlat_tawq", true, 60));
        items.add(new PopularDomain("Rub’al Khali", "Oman / Al Wistaa", "Also known as the Great Sandy Desert, Rub’ al Khali is the largest sand desert in the world with an area of about 250,000 square miles. It is considered to be one of the most important ones as well, as it has vast reserves of oil and natural gas beneath its sands. The sand dunes in this desert are said to be so high that it is nearly impossible for human beings to move around here.", 3, true, 4.3, "bidiya", true, 160));

        recyclerViewPopular = findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterPopular = new PupolarAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);


        ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches", "wahiba_sands"));
        catsList.add(new CategoryDomain("Camps", "bidiya"));
        catsList.add(new CategoryDomain("Forest", "ramlat_tawq"));
        catsList.add(new CategoryDomain("Desert", "ramlat_tawq"));
        catsList.add(new CategoryDomain("Mountain", "ramlat_tawq"));

        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);



    }

}