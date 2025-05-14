package edu.matc.entity;

import java.util.HashMap;

/**
 * The type Calculator.
 */
public class Calculator {
    /**
     * The Calories per gram of protein.
     */
    static final double CALORIES_PER_GRAM_OF_PROTEIN = 4.0;
    /**
     * The Calories per gram of carbs.
     */
    static final double CALORIES_PER_GRAM_OF_CARBS = 4.0;
    /**
     * The Calories per gram of fat.
     */
    static final double CALORIES_PER_GRAM_OF_FAT = 9.0;

    private int age;
    private String gender;
    private int heightFeet;
    private int heightInches;
    private double weight;
    private double activity;
    private String goal;

    private double goalCalories;
    private double goalProtein;
    private double goalCarbohydrate;
    private double goalFat;

    /**
     * Instantiates a new Calculator.
     */
    public Calculator() {}

    /**
     * Instantiates a new Calculator.
     *
     * @param age          the age
     * @param gender       the gender
     * @param heightFeet   the height feet
     * @param heightInches the height inches
     * @param weight       the weight
     * @param activity     the activity
     * @param goal         the goal
     */
    public Calculator(int age, String gender, int heightFeet, int heightInches, double weight, double activity, String goal) {
        this.age = age;
        this.gender = gender;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weight = weight;
        this.activity = activity;
        this.goal = goal;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {return age;}

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {return gender;}

    /**
     * Gets height feet.
     *
     * @return the height feet
     */
    public int getHeightFeet() {return heightFeet;}

    /**
     * Gets height inches.
     *
     * @return the height inches
     */
    public int getHeightInches() {return heightInches;}

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {return weight;}

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public double getActivity() {return activity;}

    /**
     * Gets goal.
     *
     * @return the goal
     */
    public String getGoal() {return goal;}

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {this.age = age;}

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {this.gender = gender;}

    /**
     * Sets height feet.
     *
     * @param heightFeet the height feet
     */
    public void setHeightFeet(int heightFeet) {this.heightFeet = heightFeet;}

    /**
     * Sets height inches.
     *
     * @param heightInches the height inches
     */
    public void setHeightInches(int heightInches) {this.heightInches = heightInches;}

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {this.weight = weight;}

    /**
     * Sets activity.
     *
     * @param activity the activity
     */
    public void setActivity(double activity) {this.activity = activity;}

    /**
     * Sets goal.
     *
     * @param goal the goal
     */
    public void setGoal(String goal) {this.goal = goal;}

    /**
     * Sets goal calories.
     *
     * @param goalCalories the goal calories
     */
    public void setGoalCalories(double goalCalories) {this.goalCalories = goalCalories;}

    /**
     * Sets goal protein.
     *
     * @param goalProtein the goal protein
     */
    public void setGoalProtein(double goalProtein) {this.goalProtein = goalProtein;}

    /**
     * Sets goal carbohydrate.
     *
     * @param goalCarbohydrate the goal carbohydrate
     */
    public void setGoalCarbohydrate(double goalCarbohydrate) {this.goalCarbohydrate = goalCarbohydrate;}

    /**
     * Sets goal fat.
     *
     * @param goalFat the goal fat
     */
    public void setGoalFat(double goalFat) {this.goalFat = goalFat;}

    /**
     * Gets goal calories.
     *
     * @return the goal calories
     */
    public double getGoalCalories() {return goalCalories;}

    /**
     * Gets goal protein.
     *
     * @return the goal protein
     */
    public double getGoalProtein() {return goalProtein;}

    /**
     * Gets goal carbohydrate.
     *
     * @return the goal carbohydrate
     */
    public double getGoalCarbohydrate() {return goalCarbohydrate;}

    /**
     * Get goal fat double.
     *
     * @return the double
     */
    public double getGoalFat(){return goalFat;};

    /**
     * Calculate bmr for males double.
     *
     * @return the double
     */
    public double calculateBMRForMales() {
        double weightInKilograms = getWeight() / 2.205;
        double heightFeetInCentimeters = getHeightFeet() * 30.48;
        double heightInchesInCentimeters = getHeightInches() * 2.54;
        double totalHeightInCentimeters = heightFeetInCentimeters + heightInchesInCentimeters;

        double bmr = 88.362 + (13.397 * weightInKilograms)
                + (4.799 * totalHeightInCentimeters)
                - (5.677 * getAge());

        return Math.round(bmr);
    }

    /**
     * Calculate bmr for females double.
     *
     * @return the double
     */
    public double calculateBMRForFemales() {
        double weightInKilograms = getWeight() / 2.205;
        double heightFeetInCentimeters = getHeightFeet() * 30.48;
        double heightInchesInCentimeters = getHeightInches() * 2.54;
        double totalHeightInCentimeters = heightFeetInCentimeters + heightInchesInCentimeters;

        double bmr = 447.593 + (9.247 * weightInKilograms)
                + (3.098 * totalHeightInCentimeters)
                - (4.330 * getAge());

        return Math.round(bmr);
    }

    /**
     * Calculate total daily expenditure double.
     *
     * @param gender        the gender
     * @param activityLevel the activity level
     * @return the double
     */
    public double calculateTotalDailyExpenditure(String gender, double activityLevel) {
        if (gender.equals("m")) {
            return calculateBMRForMales() * activityLevel;
        } else {
            return calculateBMRForFemales() * activityLevel;
        }
    }

    /**
     * Calculate macro nutrients double.
     *
     * @param gender        the gender
     * @param activityLevel the activity level
     * @param goal          the goal
     * @return the double
     */
    public double calculateMacroNutrients(String gender, double activityLevel, String goal) {
        double TDEE = calculateTotalDailyExpenditure(gender, activityLevel);

        switch (goal) {
            // if goal == m, maintain weight
            // return TDEE
            case "m":
                return TDEE;
            // if goal == l, lose 0.5 lb/week
            // return TDEE - 250
            case "l":
                return TDEE - 250;
            // if goal == l1, lose 1 lb/week
            // return TDEE - 500
            case "l1":
                return TDEE - 500;
            // if goal == l2, lose 2 lb/week
            // return TDEE - 1000
            case "l2":
                return TDEE - 1000;
            // if goal == g, gain 0.5 lb/week
            // return TDEE + 250
            case "g":
                return TDEE + 250;
            // if goal == g1, gain 1.0 lb/week
            // return TDEE + 500
            case "g1":
                return TDEE + 500;
            // if goal == g2, gain 2 lb/week
            // return TDEE + 1000
            case "g2":
                return TDEE + 1000;
            default: throw new IllegalArgumentException("Invalid goal: " + goal);
        }
    }

    /**
     * Calculate macros string.
     *
     * @return the string
     */
    public HashMap<String, Double> calculateMacros() {
        HashMap<String, Double> hashMap = new HashMap<>();

        double calories = Math.round(calculateMacroNutrients(getGender(), getActivity(), getGoal()));

        // Adjusted macro distribution: 30% protein, 40% carbs, 30% fats
        // Future endeavors would be allowing people to adjust to a custom amount
        double protein = Math.round((calories * ((double) 30 / 100)) / CALORIES_PER_GRAM_OF_PROTEIN);
        double carbohydrate = Math.round((calories * ((double) 40 / 100)) / CALORIES_PER_GRAM_OF_CARBS);
        double fats = Math.round((calories * ((double) 30 / 100)) / CALORIES_PER_GRAM_OF_FAT);

        hashMap.put("Calories", calories);
        hashMap.put("Protein", protein);
        hashMap.put("Carbohydrate", carbohydrate);
        hashMap.put("Fats", fats);

        return hashMap;
    }
}

