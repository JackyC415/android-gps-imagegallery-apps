package com.jackyzchen.cmpe277_lab2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DBController dbController;
    private EditText rUsername;
    private EditText rPassword;
    private TextView rEmail;
    private Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbController = new DBController(RegisterActivity.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registration Page");

        rUsername = findViewById(R.id.rUsername);
        rPassword = findViewById(R.id.rPassword);
        rEmail = findViewById(R.id.rEmail);
        bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = rUsername.getText().toString();
                final String password = rPassword.getText().toString();
                final String email = rEmail.getText().toString();

                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)) {
                    dbController.insertRegistration(new RegisterField(1, username, password, email));
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid field(s)!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

        });
    }
}
