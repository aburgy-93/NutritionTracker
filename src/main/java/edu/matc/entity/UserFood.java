package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * The type User food.
 */
@Entity // class mapped to a particular table
@Table(name = "food_tracker") // table used, case-sensitive
public class UserFood {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "date")
    private String date;

    @Column(name = "serving_size")
    private int servingSize;

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

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable=false, updatable=false)
    private User user;

    /**
     * No argument constructor
     */
    public UserFood() {}

    /**
     * Instantiates a new Food
     *
     * @param userId        the user who entered the food
     * @param foodId        the id of the food entered
     * @param date          the date of food entered
     * @param servingSize   the serving size
     * @param mealTime      the meal time
     * @param totalCalories total amount of calories based on serving size and calories
     * @param totalProtein  total amount of protein based on serving size and protein
     * @param totalCarbs    total number of carbs based on serving size and carbs
     * @param totalFats     total amount of fat based on serving size and fat
     * @param user          the user
     */
    public UserFood(int userId, int foodId, String date, int servingSize, String mealTime, double totalCalories,
                    double totalProtein, double totalCarbs, double totalFats, User user) {
        this.userId = userId;
        this.foodId = foodId;
        this.date = date;
        this.servingSize = servingSize;
        this.mealTime = mealTime;
        this.totalCalories = totalCalories;
        this.totalProtein = totalProtein;
        this.totalCarbs = totalCarbs;
        this.totalFats = totalFats;
        this.user = user;
    }

    /**
     * Get user id
     *
     * @return the user's id
     */
    public int getUserId() {return userId;}

    /**
     * Set the user id
     *
     * @param userId the user ID
     */
    public void setUserId(int userId) {this.userId = userId;}

    /**
     * Gets food id.
     *
     * @return the food id
     */
    public int getFoodId() {return foodId;}

    /**
     * Get date of meal
     *
     * @return the date of meal eaten
     */
    public String getDate() {return date;}

    /**
     * Set the meal date
     *
     * @param date the meal date
     */
    public void setDate(String date) {this.date = date;}

    /**
     * Get the serving size
     *
     * @return the serving size
     */
    public int getServingSize() {return servingSize;}

    /**
     * Set the serving size
     *
     * @param servingSize the serving size
     */
    public void setServingSize(int servingSize) {this.servingSize = servingSize;}


    /**
     * Get the meal time (breakfast, lunch, dinner, snack)
     *
     * @return the name of the mealtime
     */
    public String getMealTime() {return mealTime;}

    /**
     * Set the mealtime name
     *
     * @param mealTime the name of the meal time
     */
    public void setMealTime(String mealTime) {this.mealTime = mealTime;}

    /**
     * Get the total amount of calories
     *
     * @return the total amount of calories
     */
    public double getTotalCalories() {return totalCalories;}

    /**
     * Set the total amount of calories based on calories and serving size
     *
     * @param calories    number of calories in a food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalCalories(double calories, int servingSize) {
        this.totalCalories = calories * servingSize;
    }

    /**
     * Get the total amount of protein
     *
     * @return the total amount of protein
     */
    public double getTotalProtein() {return totalProtein;}

    /**
     * Set the total amount of protein based on protein and serving size
     *
     * @param protein     the amount of protein in food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalProtein(double protein, int servingSize) {
        this.totalProtein = protein * servingSize;
    }

    /**
     * Get the total number of carbs
     *
     * @return the total number of carbs
     */
    public double getTotalCarbs() {return totalCarbs;}

    /**
     * Set the total number of carbs based on carbs and serving size
     *
     * @param carbs       the total carbs based on serving size
     * @param servingSize the amount of servings a user had
     */
    public void setTotalCarbs(double carbs, int servingSize) {
        this.totalCarbs = carbs * servingSize;
    }

    /**
     * Get the total amount of fat
     *
     * @return the total amount of fat
     */
    public double getTotalFats() {return totalFats;}

    /**
     * Set the total amount of fat based on fat and serving size
     *
     * @param fat         the amount of fat in a food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalFats(double fat, int servingSize) {
        this.totalFats = fat * servingSize;
    }

    /**
     * Get the food ID
     *
     * @return the food ID
     */
    public int getId() {return id;}

    /**
     * Set the id
     *
     * @param id food id
     */
    public void setId(int id) {this.id = id;}

    /**
     * Gets food name.
     *
     * @return the food name
     */
    public String getFoodName() {
        return food.getFoodName();
    }

    /**
     * Sets food name.
     *
     * @param foodName the food name
     */
    public void setFoodName(String foodName) {
        this.food.setFoodName(foodName);
    }

    @Override
    public String toString() {
        return "UserFood{" +
                "id=" + id +
                ", userId=" + userId +
                ", foodId=" + foodId +
                ", date='" + date + '\'' +
                ", servingSize=" + servingSize +
                ", mealTime='" + mealTime + '\'' +
                ", totalCalories=" + totalCalories +
                ", totalProtein=" + totalProtein +
                ", totalCarbs=" + totalCarbs +
                ", totalFats=" + totalFats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserFood userFood = (UserFood) o;
        return userId == userFood.userId && foodId == userFood.foodId && servingSize == userFood.servingSize && Double.compare(totalCalories, userFood.totalCalories) == 0 && Double.compare(totalProtein, userFood.totalProtein) == 0 && Double.compare(totalCarbs, userFood.totalCarbs) == 0 && Double.compare(totalFats, userFood.totalFats) == 0 && id == userFood.id && Objects.equals(date, userFood.date) && Objects.equals(mealTime, userFood.mealTime) && Objects.equals(food, userFood.food) && Objects.equals(user, userFood.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, foodId, date, servingSize, mealTime, totalCalories, totalProtein, totalCarbs, totalFats, id, food, user);
    }
}
