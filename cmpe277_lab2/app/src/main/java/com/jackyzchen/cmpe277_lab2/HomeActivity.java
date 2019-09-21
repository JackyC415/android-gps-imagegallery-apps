package com.jackyzchen.cmpe277_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button bDialog, bMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

    private void showOverview() {
        OverviewDialog overviewDialog = new OverviewDialog();
        overviewDialog.show(getSupportFragmentManager(), "overview dialog");
    }
}
