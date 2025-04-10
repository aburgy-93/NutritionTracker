package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Servings{

	@JsonProperty("number")
	private Object number;

	@JsonProperty("unit")
	private Object unit;

	@JsonProperty("size")
	private Object size;

	@JsonProperty("raw")
	private Object raw;

	public void setNumber(Object number){
		this.number = number;
	}

	public Object getNumber(){
		return number;
	}

	public void setUnit(Object unit){
		this.unit = unit;
	}

	public Object getUnit(){
		return unit;
	}

	public void setSize(Object size){
		this.size = size;
	}

	public Object getSize(){
		return size;
	}

	public void setRaw(Object raw){
		this.raw = raw;
	}

	public Object getRaw(){
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