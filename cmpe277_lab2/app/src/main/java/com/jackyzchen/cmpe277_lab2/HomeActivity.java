package com.jackyzchen.cmpe277_lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private Button bDialog, bMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        bDialog = findViewById(R.id.bDescription);
        bMenu = findViewById(R.id.bMenu);

        bDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOverview();
            }
        });

        bMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MenuActivity.class));
            }
        });

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView tUsername = findViewById(R.id.tUsername);

        tUsername.setText("Welcome, "  +  username + "!");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    private void showOverview() {
        OverviewDialog overviewDialog = new OverviewDialog();
        overviewDialog.show(getSupportFragmentManager(), "overview dialog");
    }
}
