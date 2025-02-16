package edu.matc.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
    private int fat;

    @Column(name = "carbs")
    private int carbs;

    @Column(name = "protein")
    private int protein;

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

    public Food(String foodName, String foodType, int servingSize, String servingUnit,
                int calories, int fat, int carbs, int protein) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.servingSize = servingSize;
        this.servingUnit = servingUnit;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

}
