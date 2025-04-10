package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaloricBreakdown{

	@JsonProperty("percentCarbs")
	private Object percentCarbs;

	@JsonProperty("percentProtein")
	private Object percentProtein;

	@JsonProperty("percentFat")
	private Object percentFat;

	public void setPercentCarbs(Object percentCarbs){
		this.percentCarbs = percentCarbs;
	}

	public Object getPercentCarbs(){
		return percentCarbs;
	}

	public void setPercentProtein(Object percentProtein){
		this.percentProtein = percentProtein;
	}

	public Object getPercentProtein(){
		return percentProtein;
	}

	public void setPercentFat(Object percentFat){
		this.percentFat = percentFat;
	}

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