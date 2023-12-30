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


public class Sea extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);

        initRecyclerView();
    }

    @SuppressLint({"ResourceType", "WrongViewCast"})
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Al Mughsail ", "Oman / Dofhar", "Ditch the city's stress and lifestyle and connect with nature on a half-day tour. This West Salalah tour is mainly a nature trip, where you visit the Ayn Razat's beautiful natural spring water. After, walk the shores of Mughsail beach to watch the sculptured cliffs and holes from limestone rocks. Visit the Marnif cave and the lagoon to watch the flamingos", 2, true, 4.8, "moghsil", true, 1000));
        items.add(new PopularDomain("Al Fizayah", "Mountain Hiking Challenge", "Mit dem Auto von Salalah in ca 1,5h erreichbar. Immer der Straße Richtung Westen folgen, hinter Mughsayl Beach durch den Armee-checkpoint an dem Führerschein und Pass gezeigt werden muss. Ab da ist die Fahrt ein echtes Erlebnis. Nach einiger Zeit weist ein blaues Schild auf eine kleine Ausfahrt zum Fizaya Beach hin. Von oben geht es eine Schotterpiste ca 690hm bergab Richtung Strand - die Strecke ließ sich mit etwas Übung auch locker ohne 4wd mit einer Limousine befahren. Entlang der Strecke gibt hinunter gibt es tolle Aussichtspunkte", 1, false, 5, "fizayah", false, 2500));
        items.add(new PopularDomain("Musandam Peninsula", "Marine Adventure Paradise", "Discover the fjord-like landscapes of Musandam Peninsula. Dive into the vibrant marine life with snorkeling and scuba diving activities. Experience the beauty of Oman's coastal treasures.", 3, true, 4.3, "musandam_peninsula", true, 30000));

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