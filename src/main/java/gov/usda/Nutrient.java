package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrient{

	@JsonProperty("number")
	private String number;

	@JsonProperty("unitName")
	private String unitName;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("id")
	private int id;

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setUnitName(String unitName){
		this.unitName = unitName;
	}

	public String getUnitName(){
		return unitName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Nutrient{" + 
			"number = '" + number + '\'' + 
			",unitName = '" + unitName + '\'' + 
			",name = '" + name + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}