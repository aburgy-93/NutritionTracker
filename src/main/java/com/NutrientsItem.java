package com;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Nutrients item.
 */
public class NutrientsItem{

	@JsonProperty("amount")
	private Object amount;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("percentOfDailyNeeds")
	private Object percentOfDailyNeeds;

	@JsonProperty("name")
	private String name;

	/**
	 * Set amount.
	 *
	 * @param amount the amount
	 */
	public void setAmount(Object amount){
		this.amount = amount;
	}

	/**
	 * Get amount object.
	 *
	 * @return the object
	 */
	public Object getAmount(){
		return amount;
	}

	/**
	 * Set unit.
	 *
	 * @param unit the unit
	 */
	public void setUnit(String unit){
		this.unit = unit;
	}

	/**
	 * Get unit string.
	 *
	 * @return the string
	 */
	public String getUnit(){
		return unit;
	}

	/**
	 * Set percent of daily needs.
	 *
	 * @param percentOfDailyNeeds the percent of daily needs
	 */
	public void setPercentOfDailyNeeds(Object percentOfDailyNeeds){
		this.percentOfDailyNeeds = percentOfDailyNeeds;
	}

	/**
	 * Get percent of daily needs object.
	 *
	 * @return the object
	 */
	public Object getPercentOfDailyNeeds(){
		return percentOfDailyNeeds;
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

	@Override
 	public String toString(){
		return 
			"NutrientsItem{" + 
			"amount = '" + amount + '\'' + 
			",unit = '" + unit + '\'' + 
			",percentOfDailyNeeds = '" + percentOfDailyNeeds + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}