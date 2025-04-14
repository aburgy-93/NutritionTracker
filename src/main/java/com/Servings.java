package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Servings{

	@JsonProperty("number")
	private Object number;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("size")
	private Object size;

	@JsonProperty("raw")
	private String raw;

	public void setNumber(Object number){
		this.number = number;
	}

	public Object getNumber(){
		return number;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setSize(Object size){
		this.size = size;
	}

	public Object getSize(){
		return size;
	}

	public void setRaw(String raw){
		this.raw = raw;
	}

	public String getRaw(){
		return raw;
	}

	@Override
 	public String toString(){
		return 
			"Servings{" + 
			"number = '" + number + '\'' + 
			",unit = '" + unit + '\'' + 
			",size = '" + size + '\'' + 
			",raw = '" + raw + '\'' + 
			"}";
		}
}