package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodAttributesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("value")
	private int value;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"FoodAttributesItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}