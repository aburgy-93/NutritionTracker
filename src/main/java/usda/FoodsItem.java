package usda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodsItem{
	@JsonProperty("foodNutrients")
	private List<FoodNutrientsItem> foodNutrients;

	@JsonProperty("dataType")
	private String dataType;

	@JsonProperty("description")
	private String description;

	@JsonProperty("allHighlightFields")
	private String allHighlightFields;

	@JsonProperty("fdcId")
	private int fdcId;

	@JsonProperty("finalFoodInputFoods")
	private List<Object> finalFoodInputFoods;

	@JsonProperty("score")
	private Object score;

	@JsonProperty("commonNames")
	private String commonNames;

	@JsonProperty("foodCategoryId")
	private int foodCategoryId;

	@JsonProperty("microbes")
	private List<Object> microbes;

	@JsonProperty("foodMeasures")
	private List<Object> foodMeasures;

	@JsonProperty("additionalDescriptions")
	private String additionalDescriptions;

	@JsonProperty("foodAttributeTypes")
	private List<Object> foodAttributeTypes;

	@JsonProperty("publishedDate")
	private String publishedDate;

	@JsonProperty("foodVersionIds")
	private List<Object> foodVersionIds;

	@JsonProperty("foodCode")
	private int foodCode;

	@JsonProperty("foodCategory")
	private String foodCategory;

	@JsonProperty("foodAttributes")
	private List<Object> foodAttributes;

	@JsonProperty("ndbNumber")
	private int ndbNumber;

	@JsonProperty("marketCountry")
	private String marketCountry;

	@JsonProperty("tradeChannels")
	private List<String> tradeChannels;

	@JsonProperty("packageWeight")
	private String packageWeight;

	@JsonProperty("householdServingFullText")
	private String householdServingFullText;

	@JsonProperty("servingSizeUnit")
	private String servingSizeUnit;

	@JsonProperty("ingredients")
	private String ingredients;

	@JsonProperty("servingSize")
	private Object servingSize;

	@JsonProperty("brandName")
	private String brandName;

	@JsonProperty("brandOwner")
	private String brandOwner;

	@JsonProperty("shortDescription")
	private String shortDescription;

	@JsonProperty("gtinUpc")
	private String gtinUpc;

	@JsonProperty("modifiedDate")
	private String modifiedDate;

	@JsonProperty("dataSource")
	private String dataSource;

	@JsonProperty("subbrandName")
	private String subbrandName;

	public void setFoodNutrients(List<FoodNutrientsItem> foodNutrients){
		this.foodNutrients = foodNutrients;
	}

	public List<FoodNutrientsItem> getFoodNutrients(){
		return foodNutrients;
	}

	public void setDataType(String dataType){
		this.dataType = dataType;
	}

	public String getDataType(){
		return dataType;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAllHighlightFields(String allHighlightFields){
		this.allHighlightFields = allHighlightFields;
	}

	public String getAllHighlightFields(){
		return allHighlightFields;
	}

	public void setFdcId(int fdcId){
		this.fdcId = fdcId;
	}

	public int getFdcId(){
		return fdcId;
	}

	public void setFinalFoodInputFoods(List<Object> finalFoodInputFoods){
		this.finalFoodInputFoods = finalFoodInputFoods;
	}

	public List<Object> getFinalFoodInputFoods(){
		return finalFoodInputFoods;
	}

	public void setScore(Object score){
		this.score = score;
	}

	public Object getScore(){
		return score;
	}

	public void setCommonNames(String commonNames){
		this.commonNames = commonNames;
	}

	public String getCommonNames(){
		return commonNames;
	}

	public void setFoodCategoryId(int foodCategoryId){
		this.foodCategoryId = foodCategoryId;
	}

	public int getFoodCategoryId(){
		return foodCategoryId;
	}

	public void setMicrobes(List<Object> microbes){
		this.microbes = microbes;
	}

	public List<Object> getMicrobes(){
		return microbes;
	}

	public void setFoodMeasures(List<Object> foodMeasures){
		this.foodMeasures = foodMeasures;
	}

	public List<Object> getFoodMeasures(){
		return foodMeasures;
	}

	public void setAdditionalDescriptions(String additionalDescriptions){
		this.additionalDescriptions = additionalDescriptions;
	}

	public String getAdditionalDescriptions(){
		return additionalDescriptions;
	}

	public void setFoodAttributeTypes(List<Object> foodAttributeTypes){
		this.foodAttributeTypes = foodAttributeTypes;
	}

	public List<Object> getFoodAttributeTypes(){
		return foodAttributeTypes;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setFoodVersionIds(List<Object> foodVersionIds){
		this.foodVersionIds = foodVersionIds;
	}

	public List<Object> getFoodVersionIds(){
		return foodVersionIds;
	}

	public void setFoodCode(int foodCode){
		this.foodCode = foodCode;
	}

	public int getFoodCode(){
		return foodCode;
	}

	public void setFoodCategory(String foodCategory){
		this.foodCategory = foodCategory;
	}

	public String getFoodCategory(){
		return foodCategory;
	}

	public void setFoodAttributes(List<Object> foodAttributes){
		this.foodAttributes = foodAttributes;
	}

	public List<Object> getFoodAttributes(){
		return foodAttributes;
	}

	public void setNdbNumber(int ndbNumber){
		this.ndbNumber = ndbNumber;
	}

	public int getNdbNumber(){
		return ndbNumber;
	}

	public void setMarketCountry(String marketCountry){
		this.marketCountry = marketCountry;
	}

	public String getMarketCountry(){
		return marketCountry;
	}

	public void setTradeChannels(List<String> tradeChannels){
		this.tradeChannels = tradeChannels;
	}

	public List<String> getTradeChannels(){
		return tradeChannels;
	}

	public void setPackageWeight(String packageWeight){
		this.packageWeight = packageWeight;
	}

	public String getPackageWeight(){
		return packageWeight;
	}

	public void setHouseholdServingFullText(String householdServingFullText){
		this.householdServingFullText = householdServingFullText;
	}

	public String getHouseholdServingFullText(){
		return householdServingFullText;
	}

	public void setServingSizeUnit(String servingSizeUnit){
		this.servingSizeUnit = servingSizeUnit;
	}

	public String getServingSizeUnit(){
		return servingSizeUnit;
	}

	public void setIngredients(String ingredients){
		this.ingredients = ingredients;
	}

	public String getIngredients(){
		return ingredients;
	}

	public void setServingSize(Object servingSize){
		this.servingSize = servingSize;
	}

	public Object getServingSize(){
		return servingSize;
	}

	public void setBrandName(String brandName){
		this.brandName = brandName;
	}

	public String getBrandName(){
		return brandName;
	}

	public void setBrandOwner(String brandOwner){
		this.brandOwner = brandOwner;
	}

	public String getBrandOwner(){
		return brandOwner;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setGtinUpc(String gtinUpc){
		this.gtinUpc = gtinUpc;
	}

	public String getGtinUpc(){
		return gtinUpc;
	}

	public void setModifiedDate(String modifiedDate){
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedDate(){
		return modifiedDate;
	}

	public void setDataSource(String dataSource){
		this.dataSource = dataSource;
	}

	public String getDataSource(){
		return dataSource;
	}

	public void setSubbrandName(String subbrandName){
		this.subbrandName = subbrandName;
	}

	public String getSubbrandName(){
		return subbrandName;
	}

	@Override
 	public String toString(){
		return 
			"FoodsItem{" + 
			"foodNutrients = '" + foodNutrients + '\'' + 
			",dataType = '" + dataType + '\'' + 
			",description = '" + description + '\'' + 
			",allHighlightFields = '" + allHighlightFields + '\'' + 
			",fdcId = '" + fdcId + '\'' + 
			",finalFoodInputFoods = '" + finalFoodInputFoods + '\'' + 
			",score = '" + score + '\'' + 
			",commonNames = '" + commonNames + '\'' + 
			",foodCategoryId = '" + foodCategoryId + '\'' + 
			",microbes = '" + microbes + '\'' + 
			",foodMeasures = '" + foodMeasures + '\'' + 
			",additionalDescriptions = '" + additionalDescriptions + '\'' + 
			",foodAttributeTypes = '" + foodAttributeTypes + '\'' + 
			",publishedDate = '" + publishedDate + '\'' + 
			",foodVersionIds = '" + foodVersionIds + '\'' + 
			",foodCode = '" + foodCode + '\'' + 
			",foodCategory = '" + foodCategory + '\'' + 
			",foodAttributes = '" + foodAttributes + '\'' + 
			",ndbNumber = '" + ndbNumber + '\'' + 
			",marketCountry = '" + marketCountry + '\'' + 
			",tradeChannels = '" + tradeChannels + '\'' + 
			",packageWeight = '" + packageWeight + '\'' + 
			",householdServingFullText = '" + householdServingFullText + '\'' + 
			",servingSizeUnit = '" + servingSizeUnit + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",servingSize = '" + servingSize + '\'' + 
			",brandName = '" + brandName + '\'' + 
			",brandOwner = '" + brandOwner + '\'' + 
			",shortDescription = '" + shortDescription + '\'' + 
			",gtinUpc = '" + gtinUpc + '\'' + 
			",modifiedDate = '" + modifiedDate + '\'' + 
			",dataSource = '" + dataSource + '\'' + 
			",subbrandName = '" + subbrandName + '\'' + 
			"}";
		}
}