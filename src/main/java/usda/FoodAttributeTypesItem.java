package usda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodAttributeTypesItem{
	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private int id;

	@JsonProperty("foodAttributes")
	private List<FoodAttributesItem> foodAttributes;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFoodAttributes(List<FoodAttributesItem> foodAttributes){
		this.foodAttributes = foodAttributes;
	}

	public List<FoodAttributesItem> getFoodAttributes(){
		return foodAttributes;
	}

	@Override
 	public String toString(){
		return 
			"FoodAttributeTypesItem{" + 
			"name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",foodAttributes = '" + foodAttributes + '\'' + 
			"}";
		}
}