package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataType{
	@JsonProperty("Branded")
	private int branded;

	@JsonProperty("Foundation")
	private int foundation;

	@JsonProperty("SR Legacy")
	private int sRLegacy;

	@JsonProperty("Survey (FNDDS)")
	private int surveyFNDDS;

	public void setBranded(int branded){
		this.branded = branded;
	}

	public int getBranded(){
		return branded;
	}

	public void setFoundation(int foundation){
		this.foundation = foundation;
	}

	public int getFoundation(){
		return foundation;
	}

	public void setSRLegacy(int sRLegacy){
		this.sRLegacy = sRLegacy;
	}

	public int getSRLegacy(){
		return sRLegacy;
	}

	public void setSurveyFNDDS(int surveyFNDDS){
		this.surveyFNDDS = surveyFNDDS;
	}

	public int getSurveyFNDDS(){
		return surveyFNDDS;
	}

	@Override
 	public String toString(){
		return 
			"DataType{" + 
			"branded = '" + branded + '\'' + 
			",foundation = '" + foundation + '\'' + 
			",sR Legacy = '" + sRLegacy + '\'' + 
			",survey (FNDDS) = '" + surveyFNDDS + '\'' + 
			"}";
		}
}