package com;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Servings.
 */
public class Servings{

	@JsonProperty("number")
	private Object number;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("size")
	private Object size;

	@JsonProperty("raw")
	private String raw;

	/**
	 * Set number.
	 *
	 * @param number the number
	 */
	public void setNumber(Object number){
		this.number = number;
	}

	/**
	 * Get number object.
	 *
	 * @return the object
	 */
	public Object getNumber(){
		return number;
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
	 * Set size.
	 *
	 * @param size the size
	 */
	public void setSize(Object size){
		this.size = size;
	}

	/**
	 * Get size object.
	 *
	 * @return the object
	 */
	public Object getSize(){
		return size;
	}

	/**
	 * Set raw.
	 *
	 * @param raw the raw
	 */
	public void setRaw(String raw){
		this.raw = raw;
	}

	/**
	 * Get raw string.
	 *
	 * @return the string
	 */
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