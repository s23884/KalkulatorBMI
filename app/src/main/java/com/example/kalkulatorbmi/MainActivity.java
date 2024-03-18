package com.example.kalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.btnOblicz);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;
            float bmi = weight / (height * height);

            displayBMI(bmi);
        } else {
            resultTextView.setText("Please enter both weight and height.");
        }
    }

    private void displayBMI(float bmi) {
        String bmiResult = "BMI: " + String.format("%.2f", bmi);
        resultTextView.setText(bmiResult);
    }
}