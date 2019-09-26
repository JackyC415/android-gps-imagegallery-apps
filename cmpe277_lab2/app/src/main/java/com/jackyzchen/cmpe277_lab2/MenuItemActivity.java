package com.jackyzchen.cmpe277_lab2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MenuItemActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu items");

        imageView = findViewById(R.id.image_view);

        Intent intent = getIntent();
        int itemIndex = intent.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this);

        imageView.setImageResource(imageAdapter.imageArr[itemIndex]);
    }
}
