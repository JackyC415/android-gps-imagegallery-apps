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

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.cmpe277lab2.EXTRA_TEXT";
    private EditText username;
    private EditText password;
    private TextView attempt;
    private Button login, register;
    private int loginAttempts = 0;
    DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbController = new DBController(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");

        username = findViewById(R.id.eUsername);
        password = findViewById(R.id.ePassword);
        attempt = findViewById(R.id.tAttempt);
        login = findViewById(R.id.bLogin);
        register = findViewById(R.id.bRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredential(username.getText().toString().toLowerCase(), password.getText().toString().toLowerCase());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    //verify credential; exception: login as admin (any password is fine)
    private void checkCredential(String user, String pass) {

        String authorized = dbController.authenticate(user);
        if(pass.equalsIgnoreCase(authorized) && !emptyInput(user,pass) || user.equalsIgnoreCase("admin")) {
            proceedToHomePage();
        } else {
            checkLoginAttempts();
        }
    }

    public boolean emptyInput(String user, String pass) {

        boolean isEmpty = false;
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            isEmpty = true;
        }
        return isEmpty;
    }

    private void proceedToHomePage() {
        String user = username.getText().toString();
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(EXTRA_TEXT, user);
        startActivity(intent);
    }

    private void checkLoginAttempts (){
        loginAttempts++;
        Toast.makeText(getApplicationContext(), "Invalid credentials!", Toast.LENGTH_LONG).show();
        attempt.setText("Attempt: " + loginAttempts);

        if (loginAttempts == 3) {
            login.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Account blocked!", Toast.LENGTH_LONG).show();
        }
    }

}
