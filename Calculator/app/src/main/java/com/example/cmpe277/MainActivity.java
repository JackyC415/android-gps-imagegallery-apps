package com.example.cmpe277;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //user interface controllers
    EditText num1, num2;
    Button add,sub,mul,div;
    TextView answer;

    //global variables
    int resultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //user input (numbers)
        num1 = findViewById(R.id.num1Text);
        num2 = findViewById(R.id.num2Text);

        //calculator operations (buttons)
        add = findViewById(R.id.addButton);
        sub = findViewById(R.id.subButton);
        mul = findViewById(R.id.mulButton);
        div = findViewById(R.id.divButton);

        //computed value (text view)
        answer = findViewById(R.id.answerText);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultNum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                answer.setText("SUM: " + resultNum);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultNum = Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString());
                answer.setText("DIFFERENCE: " + resultNum);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultNum = Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString());
                answer.setText("PRODUCT: " + resultNum);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float divideResult = Float.parseFloat(num1.getText().toString()) / Float.parseFloat(num2.getText().toString());
                answer.setText("DIVIDEND: " + divideResult);
            }
        });

    }
}
