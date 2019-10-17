package com.example.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpager.ui.main.GPSFragment;
import com.example.viewpager.ui.main.TabsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button b_gps;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

    ViewPager viewPager = findViewById(R.id.view_pager);
    viewPager.setAdapter(tabsPagerAdapter);

    TabLayout tabs = findViewById(R.id.tabs);
    tabs.setupWithViewPager(viewPager);

    b_gps = findViewById(R.id.b_gps);
    b_gps.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(MainActivity.this, GPSFragment.class);
            startActivity(intent);
        }
    });
  }
}