package com.Horizon_Adventure_App.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.Horizon_Adventure_App.Adapters.CategoryAdapter;
import com.Horizon_Adventure_App.Adapters.PupolarAdapter;
import com.Horizon_Adventure_App.Domains.CategoryDomain;
import com.Horizon_Adventure_App.Domains.PopularDomain;

import com.com.Horizon_Adventure_App.Activity.R;
import java.util.ArrayList;

public class Mountins extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountins);

        initRecyclerView();
    }
    @SuppressLint({"ResourceType", "WrongViewCast"})
    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Jebel Akhdar", "Oman / Al Dakhiliyah", "Jebel Akhdar, also known as the Green Mountain, is Oman’s most scenic. Located in Al Dakhiliyah, the range is blessed with beautiful, cool weather year-round, lush green areas, old villages, and a growing number of posh hotels and resorts. Whether to relax in luxurious surroundings or to rough-it mount c+limbing, it is an essential destination in Oman.", 2, true, 4.8, "wahiba_sands", true, 1000));
        items.add(new PopularDomain("Jebel Shams", "Oman / Al Dakhiliyah", "Embark on a thrilling hiking adventure in Jebel Shams, known as the Grand Canyon of Oman. Enjoy breathtaking views and conquer challenging trails that showcase the beauty of Omani mountains.", 1, false, 5, "jebel_shams", false, 2500));
        items.add(new PopularDomain("Jebel Samhan", "Oman / Dhofar", "With a stunning peak sitting at 2,100 metres, Jebel Samhan is Dhofar’s most popular touristic destination, especially during the khareef monsoon season (July-September), when its spaces are covered with greenery, twisted frankincense trees, flowing streams, and lively animal reserves.", 3, true, 4.3, "musandam_peninsula", true, 30000));

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