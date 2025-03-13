package gov.usda;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Protein{

	@JsonProperty("value")
	private Object value;

	public void setValue(Object value){
		this.value = value;
	}

	public Object getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Protein{" + 
			"value = '" + value + '\'' + 
			"}";
		}
}