package com.example.kalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CaloriesActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private TextView resultTextView;
    private Button calculateButton;
    private Button resetButton;
    private ImageView homeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        ageEditText = findViewById(R.id.age);
        genderRadioGroup = findViewById(R.id.radioGroupGender);
        maleRadioButton = findViewById(R.id.radioButtonMale);
        femaleRadioButton = findViewById(R.id.radioButtonFemale);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.btnOblicz);
        resetButton = findViewById(R.id.btnReset);
        homeImage = findViewById(R.id.imageHome);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaloriesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateCalories() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty() &&
                (maleRadioButton.isChecked() || femaleRadioButton.isChecked())) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);
            int age = Integer.parseInt(ageStr);

            double bmr;
            if (maleRadioButton.isChecked()) {
                bmr = 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * age);
            } else {
                bmr = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            }

            displayCalories(bmr);
        } else {
            resultTextView.setText("Proszę wprowadzić wagę, wzrost, wiek oraz wybrać płeć.");
        }
    }

    private void displayCalories(double bmr) {
        String caloriesResult = "Zapotrzebowanie kaloryczne: " + String.format("%.2f", bmr) + " kcal";
        resultTextView.setText(caloriesResult);
    }

    private void resetFields() {
        weightEditText.setText("");
        heightEditText.setText("");
        ageEditText.setText("");
        genderRadioGroup.clearCheck();
        resultTextView.setText("");
    }
}
