package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutrients{
	@Override
 	public String toString(){
		return 
			"Nutrients{" + 
			"}";
		}
}