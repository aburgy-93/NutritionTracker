package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientsItem{

	@JsonProperty("safety_level")
	private Object safetyLevel;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private Object description;

	public void setSafetyLevel(Object safetyLevel){
		this.safetyLevel = safetyLevel;
	}

	public Object getSafetyLevel(){
		return safetyLevel;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"IngredientsItem{" + 
			"safety_level = '" + safetyLevel + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}