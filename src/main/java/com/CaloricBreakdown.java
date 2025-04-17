package com;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Caloric breakdown.
 */
public class CaloricBreakdown{

	@JsonProperty("percentCarbs")
	private Object percentCarbs;

	@JsonProperty("percentProtein")
	private Object percentProtein;

	@JsonProperty("percentFat")
	private Object percentFat;

	/**
	 * Set percent carbs.
	 *
	 * @param percentCarbs the percent carbs
	 */
	public void setPercentCarbs(Object percentCarbs){
		this.percentCarbs = percentCarbs;
	}

	/**
	 * Get percent carbs object.
	 *
	 * @return the object
	 */
	public Object getPercentCarbs(){
		return percentCarbs;
	}

	/**
	 * Set percent protein.
	 *
	 * @param percentProtein the percent protein
	 */
	public void setPercentProtein(Object percentProtein){
		this.percentProtein = percentProtein;
	}

	/**
	 * Get percent protein object.
	 *
	 * @return the object
	 */
	public Object getPercentProtein(){
		return percentProtein;
	}

	/**
	 * Set percent fat.
	 *
	 * @param percentFat the percent fat
	 */
	public void setPercentFat(Object percentFat){
		this.percentFat = percentFat;
	}

	/**
	 * Get percent fat object.
	 *
	 * @return the object
	 */
	public Object getPercentFat(){
		return percentFat;
	}

	@Override
 	public String toString(){
		return 
			"CaloricBreakdown{" + 
			"percentCarbs = '" + percentCarbs + '\'' + 
			",percentProtein = '" + percentProtein + '\'' + 
			",percentFat = '" + percentFat + '\'' + 
			"}";
		}
}