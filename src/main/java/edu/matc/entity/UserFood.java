package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity // class mapped to a particular table
@Table(name = "food_tracker") // table used, case-sensitive
public class UserFood {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "date")
    private String date;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "serving_size")
    private int servingSize;

    @Column(name = "calories")
    private int calories;

    @Column(name = "protein")
    private double protein;

    @Column(name = "carbs")
    private double carbs;

    @Column(name = "fat")
    private double fat;

    @Column(name = "meal_time")
    private String mealTime;

    @Column(name = "total_calories")
    private double totalCalories;

    @Column(name = "total_protein")
    private double totalProtein;

    @Column(name = "total_carbs")
    private double totalCarbs;

    @Column(name = "total_fat")
    private double totalFats;

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * No argument constructor
     */
    public UserFood() {}

    /**
     * Instantiates a new Food
     *
     * @param userId the user who entered the food
     * @param date the date of food entered
     * @param foodName the name of the food
     * @param foodType the type of food
     * @param servingSize the serving size
     * @param calories the amount of calories
     * @param protein the amount of protein
     * @param carbs the number of carbs
     * @param fat the amount of fat
     * @param mealTime the meal time
     */

    public UserFood(int userId, String date, String foodName, String foodType, int servingSize, int calories, double protein,
                    double carbs, double fat, String mealTime, double totalCalories, double totalProtein, double totalCarbs, double totalFats) {
        this.userId = userId;
        this.date = date;
        this.foodName = foodName;
        this.foodType = foodType;
        this.servingSize = servingSize;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.mealTime = mealTime;
        this.totalCalories = totalCalories;
        this.totalProtein = totalProtein;
        this.totalCarbs = totalCarbs;
        this.totalFats = totalFats;
    }

    /**
     * Get user id
     * @return the user's id
     */
    public int getUserId() {return userId;}

    /**
     * Set the user id
     * @param userId the user ID
     */
    public void setUserId(int userId) {this.userId = userId;}

    /**
     * Get date of meal
     * @return the date of meal eaten
     */
    public String getDate() {return date;}

    /**
     * Set the meal date
     * @param date the meal date
     */
    public void setDate(String date) {this.date = date;}

    /**
     * Get the food name
     * @return the food name
     */
    public String getFoodName() {return foodName;}

    /**
     * Set the food name
     * @param foodName the name of the food entered
     */
    public void setFoodName(String foodName) {this.foodName = foodName;}

    /**
     * Get the type of food
     * @return the food type
     */
    public String getFoodType() {return foodType;}

    /**
     * Set the food type
     * @param foodType the food type
     */
    public void setFoodType(String foodType) {this.foodType = foodType;}

    /**
     * Get the serving size
     * @return the serving size
     */
    public int getServingSize() {return servingSize;}

    /**
     * Set the serving size
     * @param servingSize the serving size
     */
    public void setServingSize(int servingSize) {this.servingSize = servingSize;}

    /**
     * Get the calories of the food
     * @return the calories of the food
     */
    public int getCalories() {return calories;}

    /**
     * Set the calorie amount
     * @param calories the calories of the food
     */
    public void setCalories(int calories) {this.calories = calories;}

    /**
     * Get the protein amount
     * @return the amount of protein in the food
     */
    public double getProtein() {return protein;}

    /**
     * Set the protein of the food
     * @param protein the protein of the food
     */
    public void setProtein(double protein) {this.protein = protein;}

    /**
     * Get the carbs of the food
     * @return the carbs in the food
     */
    public double getCarbs() {return carbs;}

    /**
     * Set the carbs for the food
     * @param carbs the carbs amount in the food
     */
    public void setCarbs(double carbs) {this.carbs = carbs;}

    /**
     * Get the fat in the food
     * @return the fat amount in food
     */
    public double getFat(){return fat;}

    /**
     * Set the fat in the food
     * @param fat the amount of fat in the food
     */
    public void setFat(double fat) {this.fat = fat;}

    /**
     * Get the meal time (breakfast, lunch, dinner, snack)
     * @return the name of the mealtime
     */
    public String getMealTime() {return mealTime;}

    /**
     * Set the mealtime name
     * @param mealTime the name of the meal time
     */
    public void setMealTime(String mealTime) {this.mealTime = mealTime;}

    /**
     * Get the total amount of calories
     * @return the total amount of calories
     */

    public double getTotalCalories() {return totalCalories;}

    /**
     * Set the total amount of calories based on calories and serving size
     * @param calories number of calories in a food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalCalories(double calories, int servingSize) {
        this.totalCalories = calories * servingSize;
    }

    /**
     * Get the total amount of protein
     * @return the total amount of protein
     */
    public double getTotalProtein() {return totalProtein;}

    /**
     * Set the total amount of protein based on protein and serving size
     * @param protein the amount of protein in food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalProtein(double protein, int servingSize) {
        this.totalProtein = protein * servingSize;
    }

    /**
     * Get the total number of carbs
     * @return the total number of carbs
     */
    public double getTotalCarbs() {return totalCarbs;}

    /**
     * Set the total number of carbs based on carbs and serving size
     * @param carbs the total carbs based on serving size
     * @param servingSize the amount of servings a user had
     */
    public void setTotalCarbs(double carbs, int servingSize) {
        this.totalCarbs = carbs * servingSize;
    }

    /**
     * Get the total amount of fat
     * @return the total amount of fat
     */
    public double getTotalFats() {return totalFats;}

    /**
     * Set the total amount of fat based on fat and serving size
     * @param fat the amount of fat in a food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalFats(double fat, int servingSize) {
        this.totalFats = fat * servingSize;
    }

    /**
     * Get the food ID
     * @return the food ID
     */
    public int getId() {return id;}

    /**
     * Set the id
     * @param id food id
     */
    public void setId(int id) {this.id = id;}

}
