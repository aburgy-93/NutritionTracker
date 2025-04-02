package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodNutrientsItem{
	@JsonProperty("unitName")
	private String unitName;

	@JsonProperty("nutrientNumber")
	private String nutrientNumber;

	@JsonProperty("foodNutrientSourceDescription")
	private String foodNutrientSourceDescription;

	@JsonProperty("derivationId")
	private int derivationId;

	@JsonProperty("derivationDescription")
	private String derivationDescription;

	@JsonProperty("percentDailyValue")
	private int percentDailyValue;

	@JsonProperty("foodNutrientSourceCode")
	private String foodNutrientSourceCode;

	@JsonProperty("derivationCode")
	private String derivationCode;

	@JsonProperty("foodNutrientId")
	private int foodNutrientId;

	@JsonProperty("nutrientId")
	private int nutrientId;

	@JsonProperty("indentLevel")
	private int indentLevel;

	@JsonProperty("foodNutrientSourceId")
	private int foodNutrientSourceId;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("nutrientName")
	private String nutrientName;

	@JsonProperty("value")
	private Object value;

	@JsonProperty("dataPoints")
	private int dataPoints;

	public void setUnitName(String unitName){
		this.unitName = unitName;
	}

	public String getUnitName(){
		return unitName;
	}

	public void setNutrientNumber(String nutrientNumber){
		this.nutrientNumber = nutrientNumber;
	}

	public String getNutrientNumber(){
		return nutrientNumber;
	}

	public void setFoodNutrientSourceDescription(String foodNutrientSourceDescription){
		this.foodNutrientSourceDescription = foodNutrientSourceDescription;
	}

	public String getFoodNutrientSourceDescription(){
		return foodNutrientSourceDescription;
	}

	public void setDerivationId(int derivationId){
		this.derivationId = derivationId;
	}

	public int getDerivationId(){
		return derivationId;
	}

	public void setDerivationDescription(String derivationDescription){
		this.derivationDescription = derivationDescription;
	}

	public String getDerivationDescription(){
		return derivationDescription;
	}

	public void setPercentDailyValue(int percentDailyValue){
		this.percentDailyValue = percentDailyValue;
	}

	public int getPercentDailyValue(){
		return percentDailyValue;
	}

	public void setFoodNutrientSourceCode(String foodNutrientSourceCode){
		this.foodNutrientSourceCode = foodNutrientSourceCode;
	}

	public String getFoodNutrientSourceCode(){
		return foodNutrientSourceCode;
	}

	public void setDerivationCode(String derivationCode){
		this.derivationCode = derivationCode;
	}

	public String getDerivationCode(){
		return derivationCode;
	}

	public void setFoodNutrientId(int foodNutrientId){
		this.foodNutrientId = foodNutrientId;
	}

	public int getFoodNutrientId(){
		return foodNutrientId;
	}

	public void setNutrientId(int nutrientId){
		this.nutrientId = nutrientId;
	}

	public int getNutrientId(){
		return nutrientId;
	}

	public void setIndentLevel(int indentLevel){
		this.indentLevel = indentLevel;
	}

	public int getIndentLevel(){
		return indentLevel;
	}

	public void setFoodNutrientSourceId(int foodNutrientSourceId){
		this.foodNutrientSourceId = foodNutrientSourceId;
	}

	public int getFoodNutrientSourceId(){
		return foodNutrientSourceId;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setNutrientName(String nutrientName){
		this.nutrientName = nutrientName;
	}

	public String getNutrientName(){
		return nutrientName;
	}

	public void setValue(Object value){
		this.value = value;
	}

	public Object getValue(){
		return value;
	}

	public void setDataPoints(int dataPoints){
		this.dataPoints = dataPoints;
	}

	public int getDataPoints(){
		return dataPoints;
	}

	@Override
 	public String toString(){
		return 
			"FoodNutrientsItem{" + 
			"unitName = '" + unitName + '\'' + 
			",nutrientNumber = '" + nutrientNumber + '\'' + 
			",foodNutrientSourceDescription = '" + foodNutrientSourceDescription + '\'' + 
			",derivationId = '" + derivationId + '\'' + 
			",derivationDescription = '" + derivationDescription + '\'' + 
			",percentDailyValue = '" + percentDailyValue + '\'' + 
			",foodNutrientSourceCode = '" + foodNutrientSourceCode + '\'' + 
			",derivationCode = '" + derivationCode + '\'' + 
			",foodNutrientId = '" + foodNutrientId + '\'' + 
			",nutrientId = '" + nutrientId + '\'' + 
			",indentLevel = '" + indentLevel + '\'' + 
			",foodNutrientSourceId = '" + foodNutrientSourceId + '\'' + 
			",rank = '" + rank + '\'' + 
			",nutrientName = '" + nutrientName + '\'' + 
			",value = '" + value + '\'' + 
			",dataPoints = '" + dataPoints + '\'' + 
			"}";
		}
}