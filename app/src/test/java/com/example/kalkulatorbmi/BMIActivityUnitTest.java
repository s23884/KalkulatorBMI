package com.example.kalkulatorbmi;

import org.junit.Test;
import static org.junit.Assert.*;

public class BMIActivityUnitTest {
    BMIActivity bmiActivity = new BMIActivity();
    @Test
    public void calculateBMI_withValidInput() {


        // Test valid input
        float weight = 70.0f; // in kg
        float height = 170.0f; // in cm
        float expectedBMI = 24.22f;
        float actualBMI = bmiActivity.calculateBMI(weight, height);

        // Check if calculated BMI matches expected value
        assertEquals(expectedBMI, actualBMI, 0.01f);
    }

    @Test
    public void calculateBMI_withInvalidInput() {
        BMIActivity bmiActivity = new BMIActivity();

        // Test invalid input (empty weight and height)
        float weight = 0.0f;
        float height = 0.0f;
        float expectedBMI = 0.0f;
        float actualBMI = bmiActivity.calculateBMI(weight, height);

        // Check if calculated BMI is 0.0 for invalid input
        assertEquals(expectedBMI, actualBMI, 0.01f);
    }
}
