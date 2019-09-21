package com.jackyzchen.cmpe277_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.eUsername);
        password = findViewById(R.id.ePassword);
        attempt = findViewById(R.id.tAttempt);
        login = findViewById(R.id.bLogin);
        register = findViewById(R.id.bRegister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredential(username.getText().toString(), password.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    private void checkCredential(String user, String pass) {

        if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123456")) {
            proceedToHomePage();
        } else {
            checkLoginAttempts();
        }
    }

    private void proceedToHomePage() {
        //explicit intent
        String user = username.getText().toString();
        Intent intent = new Intent(this, HomeActivity.class);
        //pass data between activities
        intent.putExtra(EXTRA_TEXT, user);
        startActivity(intent);
    }

    private void checkLoginAttempts (){
        loginAttempts++;
        Toast.makeText(getApplicationContext(), "Incorrect credentials!", Toast.LENGTH_LONG).show();
        attempt.setText("Attempt: " + loginAttempts);

        if (loginAttempts == 3) {
            login.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Account blocked!", Toast.LENGTH_LONG).show();
        }
    }

}
