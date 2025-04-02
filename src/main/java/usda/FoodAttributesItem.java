package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodAttributesItem{
	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("value")
	private String value;

	@JsonProperty("sequenceNumber")
	private int sequenceNumber;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setSequenceNumber(int sequenceNumber){
		this.sequenceNumber = sequenceNumber;
	}

	public int getSequenceNumber(){
		return sequenceNumber;
	}

	@Override
 	public String toString(){
		return 
			"FoodAttributesItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",sequenceNumber = '" + sequenceNumber + '\'' + 
			"}";
		}
}