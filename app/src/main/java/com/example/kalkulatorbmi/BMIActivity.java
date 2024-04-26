package com.example.kalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView resultTextView;
    private Button calculateButton;

    private ImageView homeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.btnOblicz);
        homeImage = findViewById(R.id.imageHome);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;
            float bmi = calculateBMI(weight, height);

            displayBMI(bmi);
        } else {
            resultTextView.setText("Please enter both weight and height.");
        }
    }

    private void displayBMI(float bmi) {
        String bmiResult = "BMI: " + String.format("%.2f", bmi);
        resultTextView.setText(bmiResult);
    }

    public float calculateBMI(float weight, float height) {
        return  weight / (height * height);
    }
}