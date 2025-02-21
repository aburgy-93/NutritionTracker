package edu.matc.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Food.
 */
@Entity
@Table(name = "food_table")
public class Food {
    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "serving_size")
    private int servingSize;

    @Column(name = "serving_name")
    private String servingUnit;

    @Column(name = "calories")
    private int calories;

    @Column(name = "fat")
    private double fat;

    @Column(name = "carbs")
    private double carbs;

    @Column(name = "protein")
    private double protein;

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Instantiate a new Food
     */
    public Food() {
    }

    /**
     * Instantiates a new Food.
     *
     * @param foodName    the food name
     * @param foodType    the food type
     * @param servingSize the serving size
     * @param servingUnit the serving unit
     * @param calories    the calories
     * @param fat         the fat
     * @param carbs       the carbs
     * @param protein     the protein
     */
    public Food(String foodName, String foodType, int servingSize, String servingUnit,
                int calories, double fat, double carbs, double protein) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.servingSize = servingSize;
        this.servingUnit = servingUnit;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

    /**
     * Gets name of food
     *
     * @return the food name
     */
    public String getFoodName() {return foodName;}

    /**
     * Sets the food name
     *
     * @param foodName the name of the food
     */
    public void setFoodName(String foodName) {this.foodName = foodName;};

    /**
     * Gets a food type
     *
     * @return food type
     */
    public String getFoodType() {return foodType;}

    /**
     * Sets the food type
     *
     * @param foodType the food type
     */
    public void setFoodType(String foodType) {this.foodType = foodType;};

    /**
     * Gets the serving size
     *
     * @return serving size
     */
    public int getServingSize() {return servingSize;}

    /**
     * Set the serving size
     *
     * @param servingSize the serving size
     */
    public void setServingSize(int servingSize) {this.servingSize = servingSize;};

    /**
     * Gets the serving unit
     *
     * @return serving unit
     */
    public String getServingUnit() {return servingUnit;}

    /**
     * Set serving unit
     *
     * @param servingUnit serving unit
     */
    public void setServingUnit(String servingUnit) {this.servingUnit = servingUnit;};

    /**
     * Gets calories of food
     *
     * @return calories of food
     */
    public int getCalories() {return calories;}

    /**
     * Sets the calories of the food
     *
     * @param calories calories in food
     */
    public void setCalories(int calories) {this.calories = calories;};

    /**
     * Gets fat in food
     *
     * @return fat in food
     */
    public double getFat(){return fat;};

    /**
     * Sets the fat amount in a food
     *
     * @param fat amount of fat in food
     */
    public void setFat(double fat) {this.fat = fat;}

    /**
     * Get the number of carbs in food
     *
     * @return number of carbs in food
     */
    public double getCarbs(){return carbs;}

    /**
     * Sets the number of carbs in food
     *
     * @param carbs the number of carbs in food
     */
    public void setCarbs(double carbs) {this.carbs = carbs;}

    /**
     * Get the amount of protein in food
     *
     * @return amount of protein in food
     */
    public double getProtein(){return protein;}

    /**
     * Set the protein amount in food
     *
     * @param protein protein amount in food
     */
    public void setProtein(double protein) {this.protein = protein;}

    /**
     * Get the id
     *
     * @return id id
     */
    public int getId() {return id;}

    /**
     * Set the id
     *
     * @param id food id
     */
    public void setId(int id) {this.id = id;}
}
