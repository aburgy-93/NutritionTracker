package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodNutrientsItem{

	@JsonProperty("amount")
	private Object amount;

	@JsonProperty("nutrient")
	private Nutrient nutrient;

	@JsonProperty("foodNutrientDerivation")
	private FoodNutrientDerivation foodNutrientDerivation;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

	public void setAmount(Object amount){
		this.amount = amount;
	}

	public Object getAmount(){
		return amount;
	}

	public void setNutrient(Nutrient nutrient){
		this.nutrient = nutrient;
	}

	public Nutrient getNutrient(){
		return nutrient;
	}

	public void setFoodNutrientDerivation(FoodNutrientDerivation foodNutrientDerivation){
		this.foodNutrientDerivation = foodNutrientDerivation;
	}

	public FoodNutrientDerivation getFoodNutrientDerivation(){
		return foodNutrientDerivation;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"FoodNutrientsItem{" + 
			"amount = '" + amount + '\'' + 
			",nutrient = '" + nutrient + '\'' + 
			",foodNutrientDerivation = '" + foodNutrientDerivation + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}