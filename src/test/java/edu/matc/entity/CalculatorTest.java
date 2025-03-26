package edu.matc.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculateBMRForMales() {
        calculator.setWeight(165.0);
        calculator.setAge(30);
        calculator.setGender("Male");
        calculator.setHeightFeet(5);
        calculator.setHeightInches(8);

        // When I implement saving a user's numbers, I will have to use a User entity to get/save their data
        // Since it is just used currently to calculate BMR/TDEE/Goal calories and not saved,
        // I have to use hardcoded data
        assertEquals(calculator.calculateBMRForMales(), 1749);
    }

    @Test
    void calculateBMRForFemales() {
        calculator.setWeight(135.0);
        calculator.setAge(26);
        calculator.setGender("Female");
        calculator.setHeightFeet(5);
        calculator.setHeightInches(3);

        // When I implement saving a user's numbers, I will have to use a User entity to get/save their data
        // Since it is just used currently to calculate BMR/TDEE/Goal calories and not saved,
        // I have to use hardcoded data
        assertEquals(calculator.calculateBMRForFemales(), 1397.0);
    }

    @Test
    void calculateTotalDailyExpenditureMale() {
        calculator.setWeight(165.0);
        calculator.setAge(30);
        calculator.setHeightFeet(5);
        calculator.setHeightInches(8);

        double activityLevel = 1.55;
        double expectedTDEE = calculator.calculateBMRForMales() * activityLevel;

        assertEquals(calculator.calculateTotalDailyExpenditure("m", activityLevel), expectedTDEE);
    }

    @Test
    void calculateTotalDailyExpenditureFemale() {
        calculator.setWeight(135.0);
        calculator.setAge(26);
        calculator.setHeightFeet(5);
        calculator.setHeightInches(3);

        double activityLevel = 1.55;
        double expectedTDEE = calculator.calculateBMRForFemales() * activityLevel;

        assertEquals(calculator.calculateTotalDailyExpenditure("f", activityLevel), expectedTDEE);
    }

    @Test
    void calculateMacroNutrients() {
    }

    @Test
    void calculateMacros() {
    }
}