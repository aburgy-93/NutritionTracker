package com;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Nutrition.
 */
public class Nutrition{

	@JsonProperty("caloricBreakdown")
	private CaloricBreakdown caloricBreakdown;

	@JsonProperty("carbs")
	private String carbs;

	@JsonProperty("protein")
	private String protein;

	@JsonProperty("fat")
	private String fat;

	@JsonProperty("calories")
	private Object calories;

	@JsonProperty("nutrients")
	private List<NutrientsItem> nutrients;

	/**
	 * Set caloric breakdown.
	 *
	 * @param caloricBreakdown the caloric breakdown
	 */
	public void setCaloricBreakdown(CaloricBreakdown caloricBreakdown){
		this.caloricBreakdown = caloricBreakdown;
	}

	/**
	 * Get caloric breakdown caloric breakdown.
	 *
	 * @return the caloric breakdown
	 */
	public CaloricBreakdown getCaloricBreakdown(){
		return caloricBreakdown;
	}

	/**
	 * Set carbs.
	 *
	 * @param carbs the carbs
	 */
	public void setCarbs(String carbs){
		this.carbs = carbs;
	}

	/**
	 * Get carbs string.
	 *
	 * @return the string
	 */
	public String getCarbs(){
		return carbs;
	}

	/**
	 * Set protein.
	 *
	 * @param protein the protein
	 */
	public void setProtein(String protein){
		this.protein = protein;
	}

	/**
	 * Get protein string.
	 *
	 * @return the string
	 */
	public String getProtein(){
		return protein;
	}

	/**
	 * Set fat.
	 *
	 * @param fat the fat
	 */
	public void setFat(String fat){
		this.fat = fat;
	}

	/**
	 * Get fat string.
	 *
	 * @return the string
	 */
	public String getFat(){
		return fat;
	}

	/**
	 * Set calories.
	 *
	 * @param calories the calories
	 */
	public void setCalories(Object calories){
		this.calories = calories;
	}

	/**
	 * Get calories object.
	 *
	 * @return the object
	 */
	public Object getCalories(){
		return calories;
	}

	/**
	 * Set nutrients.
	 *
	 * @param nutrients the nutrients
	 */
	public void setNutrients(List<NutrientsItem> nutrients){
		this.nutrients = nutrients;
	}

	/**
	 * Get nutrients list.
	 *
	 * @return the list
	 */
	public List<NutrientsItem> getNutrients(){
		return nutrients;
	}

	@Override
 	public String toString(){
		return 
			"Nutrition{" + 
			"caloricBreakdown = '" + caloricBreakdown + '\'' + 
			",carbs = '" + carbs + '\'' + 
			",protein = '" + protein + '\'' + 
			",fat = '" + fat + '\'' + 
			",calories = '" + calories + '\'' + 
			",nutrients = '" + nutrients + '\'' + 
			"}";
		}
}