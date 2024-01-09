package com.example.go4lunch.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.go4lunch.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import com.example.go4lunch.databinding.ActivityMainBinding;
import com.example.go4lunch.fragments.MapsFragment;
import com.example.go4lunch.fragments.RestaurantListFragment;
import com.example.go4lunch.fragments.WorkmatesFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        configureUI();

        // connecting MapsFragment with activity

        getSupportFragmentManager()
                .beginTransaction()
                .replace(id.main_frame_layout, new MapsFragment())
                .commit();




    }

    private void initView() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    private void configureUI() {
        this.configureToolbar();
        this.configureBottomView();
        this.configureDrawerLayout();
        this.configureNavigationView();
    }

    private void configureToolbar() {
        setSupportActionBar(binding.mainToolbar);
    }

    private void configureBottomView() {
        binding.mainBottomNavigationView.setOnNavigationItemReselectedListener(item -> onBottomNavigation(item.getItemId()));
    }

    private void configureDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.mainDrawerLayout, binding.mainToolbar,
                string.navigation_drawer_open, string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(color.white));
        binding.mainDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView() {
        binding.mainNavigationView.setNavigationItemSelectedListener(this);
        ImageView imageUser = binding.mainNavigationView.getHeaderView(0).findViewById(id.user_navigation_header_image_view_picture);
        TextView userNameTextView = binding.mainNavigationView.getHeaderView(0).findViewById(id.user_navigation_header_name_text);
        TextView emailTextview = binding.mainNavigationView.getHeaderView(0).findViewById(id.user_navigation_header_email_text);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userNameTextView.setText(user.getDisplayName());
            emailTextview.setText(user.getEmail());
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .transform(new CenterCrop())
                    .into(imageUser);
        }
    }

    public boolean onBottomNavigation(int itemId) {
        Fragment selectedFragment = null;

        switch (itemId) {
            case id.bottom_navigation_menu_map_button:
                selectedFragment = new MapsFragment();
                break;
            case id.bottom_navigation_menu_list_button:
                selectedFragment = new RestaurantListFragment();
                break;
            case id.bottom_navigation_menu_workMates_button:
                selectedFragment = new WorkmatesFragment();
                break;
        }

        if (selectedFragment != null) {
            MainActivity.this
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id.main_frame_layout, selectedFragment)
                    .commit();
        }
        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}