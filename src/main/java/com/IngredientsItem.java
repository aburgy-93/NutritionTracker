package com;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Ingredients item.
 */
public class IngredientsItem{

	@JsonProperty("safety_level")
	private Object safetyLevel;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private Object description;

	/**
	 * Set safety level.
	 *
	 * @param safetyLevel the safety level
	 */
	public void setSafetyLevel(Object safetyLevel){
		this.safetyLevel = safetyLevel;
	}

	/**
	 * Get safety level object.
	 *
	 * @return the object
	 */
	public Object getSafetyLevel(){
		return safetyLevel;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(Object description){
		this.description = description;
	}

	/**
	 * Get description object.
	 *
	 * @return the object
	 */
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