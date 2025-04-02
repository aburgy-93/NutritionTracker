package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodMeasuresItem{
	@JsonProperty("measureUnitName")
	private String measureUnitName;

	@JsonProperty("disseminationText")
	private String disseminationText;

	@JsonProperty("modifier")
	private String modifier;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("gramWeight")
	private int gramWeight;

	@JsonProperty("id")
	private int id;

	@JsonProperty("measureUnitAbbreviation")
	private String measureUnitAbbreviation;

	@JsonProperty("measureUnitId")
	private int measureUnitId;

	public void setMeasureUnitName(String measureUnitName){
		this.measureUnitName = measureUnitName;
	}

	public String getMeasureUnitName(){
		return measureUnitName;
	}

	public void setDisseminationText(String disseminationText){
		this.disseminationText = disseminationText;
	}

	public String getDisseminationText(){
		return disseminationText;
	}

	public void setModifier(String modifier){
		this.modifier = modifier;
	}

	public String getModifier(){
		return modifier;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setGramWeight(int gramWeight){
		this.gramWeight = gramWeight;
	}

	public int getGramWeight(){
		return gramWeight;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMeasureUnitAbbreviation(String measureUnitAbbreviation){
		this.measureUnitAbbreviation = measureUnitAbbreviation;
	}

	public String getMeasureUnitAbbreviation(){
		return measureUnitAbbreviation;
	}

	public void setMeasureUnitId(int measureUnitId){
		this.measureUnitId = measureUnitId;
	}

	public int getMeasureUnitId(){
		return measureUnitId;
	}

	@Override
 	public String toString(){
		return 
			"FoodMeasuresItem{" + 
			"measureUnitName = '" + measureUnitName + '\'' + 
			",disseminationText = '" + disseminationText + '\'' + 
			",modifier = '" + modifier + '\'' + 
			",rank = '" + rank + '\'' + 
			",gramWeight = '" + gramWeight + '\'' + 
			",id = '" + id + '\'' + 
			",measureUnitAbbreviation = '" + measureUnitAbbreviation + '\'' + 
			",measureUnitId = '" + measureUnitId + '\'' + 
			"}";
		}
}