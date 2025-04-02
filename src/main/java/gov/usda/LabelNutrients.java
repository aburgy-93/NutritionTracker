package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LabelNutrients{

	@JsonProperty("carbohydrates")
	private Carbohydrates carbohydrates;

	@JsonProperty("saturatedFat")
	private SaturatedFat saturatedFat;

	@JsonProperty("sodium")
	private Sodium sodium;

	@JsonProperty("fiber")
	private Fiber fiber;

	@JsonProperty("sugars")
	private Sugars sugars;

	@JsonProperty("protein")
	private Protein protein;

	@JsonProperty("fat")
	private Fat fat;

	@JsonProperty("transFat")
	private TransFat transFat;

	@JsonProperty("cholesterol")
	private Cholesterol cholesterol;

	@JsonProperty("calories")
	private Calories calories;

	public void setCarbohydrates(Carbohydrates carbohydrates){
		this.carbohydrates = carbohydrates;
	}

	public Carbohydrates getCarbohydrates(){
		return carbohydrates;
	}

	public void setSaturatedFat(SaturatedFat saturatedFat){
		this.saturatedFat = saturatedFat;
	}

	public SaturatedFat getSaturatedFat(){
		return saturatedFat;
	}

	public void setSodium(Sodium sodium){
		this.sodium = sodium;
	}

	public Sodium getSodium(){
		return sodium;
	}

	public void setFiber(Fiber fiber){
		this.fiber = fiber;
	}

	public Fiber getFiber(){
		return fiber;
	}

	public void setSugars(Sugars sugars){
		this.sugars = sugars;
	}

	public Sugars getSugars(){
		return sugars;
	}

	public void setProtein(Protein protein){
		this.protein = protein;
	}

	public Protein getProtein(){
		return protein;
	}

	public void setFat(Fat fat){
		this.fat = fat;
	}

	public Fat getFat(){
		return fat;
	}

	public void setTransFat(TransFat transFat){
		this.transFat = transFat;
	}

	public TransFat getTransFat(){
		return transFat;
	}

	public void setCholesterol(Cholesterol cholesterol){
		this.cholesterol = cholesterol;
	}

	public Cholesterol getCholesterol(){
		return cholesterol;
	}

	public void setCalories(Calories calories){
		this.calories = calories;
	}

	public Calories getCalories(){
		return calories;
	}

	@Override
 	public String toString(){
		return 
			"LabelNutrients{" + 
			"carbohydrates = '" + carbohydrates + '\'' + 
			",saturatedFat = '" + saturatedFat + '\'' + 
			",sodium = '" + sodium + '\'' + 
			",fiber = '" + fiber + '\'' + 
			",sugars = '" + sugars + '\'' + 
			",protein = '" + protein + '\'' + 
			",fat = '" + fat + '\'' + 
			",transFat = '" + transFat + '\'' + 
			",cholesterol = '" + cholesterol + '\'' + 
			",calories = '" + calories + '\'' + 
			"}";
		}
}