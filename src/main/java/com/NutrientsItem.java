package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutrientsItem{

	@JsonProperty("amount")
	private Object amount;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("percentOfDailyNeeds")
	private Object percentOfDailyNeeds;

	@JsonProperty("name")
	private String name;

	public void setAmount(Object amount){
		this.amount = amount;
	}

	public Object getAmount(){
		return amount;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setPercentOfDailyNeeds(Object percentOfDailyNeeds){
		this.percentOfDailyNeeds = percentOfDailyNeeds;
	}

	public Object getPercentOfDailyNeeds(){
		return percentOfDailyNeeds;
	}

	public void setName(String name){
		this.name = name;
	}

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