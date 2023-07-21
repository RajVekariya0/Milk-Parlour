package com.example.moveit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.moveit.R;
import com.example.moveit.fragment.FilterFragment;
import com.example.moveit.fragment.RouteFragment;
import com.example.moveit.fragment.SeatFragment;
import com.example.moveit.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RouteActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        initViews();

        loadFragment(new RouteFragment());

    }

    private void initViews() {

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(RouteActivity.this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_route:
                fragment = new RouteFragment();
                break;

            case R.id.navigation_filter:
                 fragment = new FilterFragment();
                break;

            case R.id.navigation_seat:
                fragment = new SeatFragment();
                break;

            case R.id.navigation_profile:
                fragment = new UserFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}