package com;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public void setCaloricBreakdown(CaloricBreakdown caloricBreakdown){
		this.caloricBreakdown = caloricBreakdown;
	}

	public CaloricBreakdown getCaloricBreakdown(){
		return caloricBreakdown;
	}

	public void setCarbs(String carbs){
		this.carbs = carbs;
	}

	public String getCarbs(){
		return carbs;
	}

	public void setProtein(String protein){
		this.protein = protein;
	}

	public String getProtein(){
		return protein;
	}

	public void setFat(String fat){
		this.fat = fat;
	}

	public String getFat(){
		return fat;
	}

	public void setCalories(Object calories){
		this.calories = calories;
	}

	public Object getCalories(){
		return calories;
	}

	public void setNutrients(List<NutrientsItem> nutrients){
		this.nutrients = nutrients;
	}

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