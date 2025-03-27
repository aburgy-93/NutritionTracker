package gov.usda;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("marketCountry")
	private String marketCountry;

	@JsonProperty("brandName")
	private String brandName;

	@JsonProperty("foodNutrients")
	private List<FoodNutrientsItem> foodNutrients;

	@JsonProperty("foodComponents")
	private List<Object> foodComponents;

	@JsonProperty("foodUpdateLog")
	private List<FoodUpdateLogItem> foodUpdateLog;

	@JsonProperty("packageWeight")
	private String packageWeight;

	@JsonProperty("dataType")
	private String dataType;

	@JsonProperty("brandOwner")
	private String brandOwner;

	@JsonProperty("description")
	private String description;

	@JsonProperty("availableDate")
	private String availableDate;

	@JsonProperty("fdcId")
	private int fdcId;

	@JsonProperty("brandedFoodCategory")
	private String brandedFoodCategory;

	@JsonProperty("servingSizeUnit")
	private String servingSizeUnit;

	@JsonProperty("modifiedDate")
	private String modifiedDate;

	@JsonProperty("gtinUpc")
	private String gtinUpc;

	@JsonProperty("foodPortions")
	private List<Object> foodPortions;

	@JsonProperty("ingredients")
	private String ingredients;

	@JsonProperty("foodClass")
	private String foodClass;

	@JsonProperty("labelNutrients")
	private LabelNutrients labelNutrients;

	@JsonProperty("discontinuedDate")
	private String discontinuedDate;

	@JsonProperty("publicationDate")
	private String publicationDate;

	@JsonProperty("dataSource")
	private String dataSource;

	@JsonProperty("servingSize")
	private Object servingSize;

	@JsonProperty("foodAttributes")
	private List<FoodAttributesItem> foodAttributes;

	@JsonProperty("householdServingFullText")
	private String householdServingFullText;

	public String getHouseholdServingFullText() {
		return householdServingFullText;
	}

	public void setHouseholdServingFullText(String householdServingFullText) {
		this.householdServingFullText = householdServingFullText;
	}

	public void setMarketCountry(String marketCountry){
		this.marketCountry = marketCountry;
	}

	public String getMarketCountry(){
		return marketCountry;
	}

	public void setBrandName(String brandName){
		this.brandName = brandName;
	}

	public String getBrandName(){
		return brandName;
	}

	public void setFoodNutrients(List<FoodNutrientsItem> foodNutrients){
		this.foodNutrients = foodNutrients;
	}

	public List<FoodNutrientsItem> getFoodNutrients(){
		return foodNutrients;
	}

	public void setFoodComponents(List<Object> foodComponents){
		this.foodComponents = foodComponents;
	}

	public List<Object> getFoodComponents(){
		return foodComponents;
	}

	public void setFoodUpdateLog(List<FoodUpdateLogItem> foodUpdateLog){
		this.foodUpdateLog = foodUpdateLog;
	}

	public List<FoodUpdateLogItem> getFoodUpdateLog(){
		return foodUpdateLog;
	}

	public void setPackageWeight(String packageWeight){
		this.packageWeight = packageWeight;
	}

	public String getPackageWeight(){
		return packageWeight;
	}

	public void setDataType(String dataType){
		this.dataType = dataType;
	}

	public String getDataType(){
		return dataType;
	}

	public void setBrandOwner(String brandOwner){
		this.brandOwner = brandOwner;
	}

	public String getBrandOwner(){
		return brandOwner;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAvailableDate(String availableDate){
		this.availableDate = availableDate;
	}

	public String getAvailableDate(){
		return availableDate;
	}

	public void setFdcId(int fdcId){
		this.fdcId = fdcId;
	}

	public int getFdcId(){
		return fdcId;
	}

	public void setBrandedFoodCategory(String brandedFoodCategory){
		this.brandedFoodCategory = brandedFoodCategory;
	}

	public String getBrandedFoodCategory(){
		return brandedFoodCategory;
	}

	public void setServingSizeUnit(String servingSizeUnit){
		this.servingSizeUnit = servingSizeUnit;
	}

	public String getServingSizeUnit(){
		return servingSizeUnit;
	}

	public void setModifiedDate(String modifiedDate){
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedDate(){
		return modifiedDate;
	}

	public void setGtinUpc(String gtinUpc){
		this.gtinUpc = gtinUpc;
	}

	public String getGtinUpc(){
		return gtinUpc;
	}

	public void setFoodPortions(List<Object> foodPortions){
		this.foodPortions = foodPortions;
	}

	public List<Object> getFoodPortions(){
		return foodPortions;
	}

	public void setIngredients(String ingredients){
		this.ingredients = ingredients;
	}

	public String getIngredients(){
		return ingredients;
	}

	public void setFoodClass(String foodClass){
		this.foodClass = foodClass;
	}

	public String getFoodClass(){
		return foodClass;
	}

	public void setLabelNutrients(LabelNutrients labelNutrients){
		this.labelNutrients = labelNutrients;
	}

	public LabelNutrients getLabelNutrients(){
		return labelNutrients;
	}

	public void setDiscontinuedDate(String discontinuedDate){
		this.discontinuedDate = discontinuedDate;
	}

	public String getDiscontinuedDate(){
		return discontinuedDate;
	}

	public void setPublicationDate(String publicationDate){
		this.publicationDate = publicationDate;
	}

	public String getPublicationDate(){
		return publicationDate;
	}

	public void setDataSource(String dataSource){
		this.dataSource = dataSource;
	}

	public String getDataSource(){
		return dataSource;
	}

	public void setServingSize(Object servingSize){
		this.servingSize = servingSize;
	}

	public Object getServingSize(){
		return servingSize;
	}

	public void setFoodAttributes(List<FoodAttributesItem> foodAttributes){
		this.foodAttributes = foodAttributes;
	}

	public List<FoodAttributesItem> getFoodAttributes(){
		return foodAttributes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"marketCountry = '" + marketCountry + '\'' + 
			",brandName = '" + brandName + '\'' + 
			",foodNutrients = '" + foodNutrients + '\'' + 
			",foodComponents = '" + foodComponents + '\'' + 
			",foodUpdateLog = '" + foodUpdateLog + '\'' + 
			",packageWeight = '" + packageWeight + '\'' + 
			",dataType = '" + dataType + '\'' + 
			",brandOwner = '" + brandOwner + '\'' + 
			",description = '" + description + '\'' + 
			",availableDate = '" + availableDate + '\'' + 
			",fdcId = '" + fdcId + '\'' + 
			",brandedFoodCategory = '" + brandedFoodCategory + '\'' + 
			",servingSizeUnit = '" + servingSizeUnit + '\'' + 
			",modifiedDate = '" + modifiedDate + '\'' + 
			",gtinUpc = '" + gtinUpc + '\'' + 
			",foodPortions = '" + foodPortions + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",foodClass = '" + foodClass + '\'' + 
			",labelNutrients = '" + labelNutrients + '\'' + 
			",discontinuedDate = '" + discontinuedDate + '\'' + 
			",publicationDate = '" + publicationDate + '\'' + 
			",dataSource = '" + dataSource + '\'' + 
			",servingSize = '" + servingSize + '\'' + 
			",foodAttributes = '" + foodAttributes + '\'' + 
			"}";
		}
}