package com;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritionResponse{

	@JsonProperty("image")
	private String image;

	@JsonProperty("images")
	private List<String> images;

	@JsonProperty("description")
	private String description;

	@JsonProperty("upc")
	private String upc;

	@JsonProperty("ingredientCount")
	private int ingredientCount;

	@JsonProperty("title")
	private String title;

	@JsonProperty("aisle")
	private Object aisle;

	@JsonProperty("badges")
	private List<String> badges;

	@JsonProperty("generatedText")
	private Object generatedText;

	@JsonProperty("nutrition")
	private Nutrition nutrition;

	@JsonProperty("servings")
	private Servings servings;

	@JsonProperty("credits")
	private Credits credits;

	@JsonProperty("price")
	private Object price;

	@JsonProperty("ingredientList")
	private String ingredientList;

	@JsonProperty("usdaCode")
	private Object usdaCode;

	@JsonProperty("ingredients")
	private List<IngredientsItem> ingredients;

	@JsonProperty("spoonacularScore")
	private Object spoonacularScore;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private String category;

	@JsonProperty("imageType")
	private String imageType;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("breadcrumbs")
	private List<String> breadcrumbs;

	@JsonProperty("likes")
	private int likes;

	@JsonProperty("importantBadges")
	private List<String> importantBadges;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setUpc(String upc){
		this.upc = upc;
	}

	public String getUpc(){
		return upc;
	}

	public void setIngredientCount(int ingredientCount){
		this.ingredientCount = ingredientCount;
	}

	public int getIngredientCount(){
		return ingredientCount;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setAisle(Object aisle){
		this.aisle = aisle;
	}

	public Object getAisle(){
		return aisle;
	}

	public void setBadges(List<String> badges){
		this.badges = badges;
	}

	public List<String> getBadges(){
		return badges;
	}

	public void setGeneratedText(Object generatedText){
		this.generatedText = generatedText;
	}

	public Object getGeneratedText(){
		return generatedText;
	}

	public void setNutrition(Nutrition nutrition){
		this.nutrition = nutrition;
	}

	public Nutrition getNutrition(){
		return nutrition;
	}

	public void setServings(Servings servings){
		this.servings = servings;
	}

	public Servings getServings(){
		return servings;
	}

	public void setCredits(Credits credits){
		this.credits = credits;
	}

	public Credits getCredits(){
		return credits;
	}

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setIngredientList(String ingredientList){
		this.ingredientList = ingredientList;
	}

	public String getIngredientList(){
		return ingredientList;
	}

	public void setUsdaCode(Object usdaCode){
		this.usdaCode = usdaCode;
	}

	public Object getUsdaCode(){
		return usdaCode;
	}

	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setSpoonacularScore(Object spoonacularScore){
		this.spoonacularScore = spoonacularScore;
	}

	public Object getSpoonacularScore(){
		return spoonacularScore;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setImageType(String imageType){
		this.imageType = imageType;
	}

	public String getImageType(){
		return imageType;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	public void setBreadcrumbs(List<String> breadcrumbs){
		this.breadcrumbs = breadcrumbs;
	}

	public List<String> getBreadcrumbs(){
		return breadcrumbs;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}

	public void setImportantBadges(List<String> importantBadges){
		this.importantBadges = importantBadges;
	}

	public List<String> getImportantBadges(){
		return importantBadges;
	}

	@Override
 	public String toString(){
		return 
			"NutritionResponse{" + 
			"image = '" + image + '\'' + 
			",images = '" + images + '\'' + 
			",description = '" + description + '\'' + 
			",upc = '" + upc + '\'' + 
			",ingredientCount = '" + ingredientCount + '\'' + 
			",title = '" + title + '\'' + 
			",aisle = '" + aisle + '\'' + 
			",badges = '" + badges + '\'' + 
			",generatedText = '" + generatedText + '\'' + 
			",nutrition = '" + nutrition + '\'' + 
			",servings = '" + servings + '\'' + 
			",credits = '" + credits + '\'' + 
			",price = '" + price + '\'' + 
			",ingredientList = '" + ingredientList + '\'' + 
			",usdaCode = '" + usdaCode + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",spoonacularScore = '" + spoonacularScore + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",imageType = '" + imageType + '\'' + 
			",brand = '" + brand + '\'' + 
			",breadcrumbs = '" + breadcrumbs + '\'' + 
			",likes = '" + likes + '\'' + 
			",importantBadges = '" + importantBadges + '\'' + 
			"}";
		}
}