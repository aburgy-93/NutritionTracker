package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Aggregations{
	@JsonProperty("dataType")
	private DataType dataType;

	@JsonProperty("nutrients")
	private Nutrients nutrients;

	public void setDataType(DataType dataType){
		this.dataType = dataType;
	}

	public DataType getDataType(){
		return dataType;
	}

	public void setNutrients(Nutrients nutrients){
		this.nutrients = nutrients;
	}

	public Nutrients getNutrients(){
		return nutrients;
	}

	@Override
 	public String toString(){
		return 
			"Aggregations{" + 
			"dataType = '" + dataType + '\'' + 
			",nutrients = '" + nutrients + '\'' + 
			"}";
		}
}