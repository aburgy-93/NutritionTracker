package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * The type User food.
 */
@Entity(name = "UserFood") // class mapped to a particular table
@Table(name = "food_tracker") // table used, case-sensitive
public class UserFood {
    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "serving_size")
    private double servingSize;

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

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * No argument constructor
     */
    public UserFood() {}


    /**
     * Instantiates a new User food.
     *
     * @param user        the user
     * @param food        the food
     * @param date        the date
     * @param servingSize the serving size
     * @param mealTime    the meal time
     */
    public UserFood(User user, Food food, String date, double servingSize, String mealTime) {
        this.user = user;
        this.food = food;
        this.date = date;
        this.servingSize = servingSize;
        this.mealTime = mealTime;
        setTotalCalories(food.getCalories(), servingSize);
        setTotalProtein(food.getProtein(), servingSize);
        setTotalCarbs(food.getCarbs(), servingSize);
        setTotalFats(food.getFat(), servingSize);
    }

    /**
     * Set the total amount of calories based on calories and serving size
     *
     * @param calories    number of calories in a food
     * @param servingSize the amount of servings a user had
     */
    public void setTotalCalories(double calories, double servingSize) {
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
    public void setTotalProtein(double protein, double servingSize) {
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
    public void setTotalCarbs(double carbs, double servingSize) {
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
    public void setTotalFats(double fat, double servingSize) {
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
        return id == userFood.id && servingSize == userFood.servingSize && Double.compare(totalCalories, userFood.totalCalories) == 0 && Double.compare(totalProtein, userFood.totalProtein) == 0 && Double.compare(totalCarbs, userFood.totalCarbs) == 0 && Double.compare(totalFats, userFood.totalFats) == 0 && Objects.equals(date, userFood.date) && Objects.equals(mealTime, userFood.mealTime) && Objects.equals(food, userFood.food) && Objects.equals(user, userFood.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, servingSize, mealTime, totalCalories, totalProtein, totalCarbs, totalFats, food, user);
    }
}

