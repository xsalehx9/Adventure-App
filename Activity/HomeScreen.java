package com.Horizon_Adventure_App.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.com.Horizon_Adventure_App.Activity.R;
import com.google.android.material.navigation.NavigationView;


public class HomeScreen extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);

        // Open and close drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.Home);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Menu drawer
                switch (item.getItemId()) {
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
                        toolbar.setTitle("Home");
                        break;

                    case R.id.feedback:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Feedback()).commit();
                        toolbar.setTitle("Feedback");
                        break;

                    case R.id.AboutUs:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AboutApp()).commit();
                        toolbar.setTitle("Info");
                        break;

                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SettingFragment()).commit();
                        toolbar.setTitle("Setting");
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed(); // Call the default behavior
        }
    }
}
