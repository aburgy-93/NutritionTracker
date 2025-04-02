package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinalFoodInputFoodsItem{
	@JsonProperty("unit")
	private String unit;

	@JsonProperty("portionDescription")
	private String portionDescription;

	@JsonProperty("foodDescription")
	private String foodDescription;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("gramWeight")
	private int gramWeight;

	@JsonProperty("portionCode")
	private String portionCode;

	@JsonProperty("id")
	private int id;

	@JsonProperty("retentionCode")
	private int retentionCode;

	@JsonProperty("value")
	private int value;

	@JsonProperty("srCode")
	private int srCode;

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setPortionDescription(String portionDescription){
		this.portionDescription = portionDescription;
	}

	public String getPortionDescription(){
		return portionDescription;
	}

	public void setFoodDescription(String foodDescription){
		this.foodDescription = foodDescription;
	}

	public String getFoodDescription(){
		return foodDescription;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setGramWeight(int gramWeight){
		this.gramWeight = gramWeight;
	}

	public int getGramWeight(){
		return gramWeight;
	}

	public void setPortionCode(String portionCode){
		this.portionCode = portionCode;
	}

	public String getPortionCode(){
		return portionCode;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRetentionCode(int retentionCode){
		this.retentionCode = retentionCode;
	}

	public int getRetentionCode(){
		return retentionCode;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public void setSrCode(int srCode){
		this.srCode = srCode;
	}

	public int getSrCode(){
		return srCode;
	}

	@Override
 	public String toString(){
		return 
			"FinalFoodInputFoodsItem{" + 
			"unit = '" + unit + '\'' + 
			",portionDescription = '" + portionDescription + '\'' + 
			",foodDescription = '" + foodDescription + '\'' + 
			",rank = '" + rank + '\'' + 
			",gramWeight = '" + gramWeight + '\'' + 
			",portionCode = '" + portionCode + '\'' + 
			",id = '" + id + '\'' + 
			",retentionCode = '" + retentionCode + '\'' + 
			",value = '" + value + '\'' + 
			",srCode = '" + srCode + '\'' + 
			"}";
		}
}