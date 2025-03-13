package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sodium{

	@JsonProperty("value")
	private int value;

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Sodium{" + 
			"value = '" + value + '\'' + 
			"}";
		}
}