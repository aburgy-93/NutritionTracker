package com;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Nutrition response.
 */
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

	/**
	 * Set image.
	 *
	 * @param image the image
	 */
	public void setImage(String image){
		this.image = image;
	}

	/**
	 * Get image string.
	 *
	 * @return the string
	 */
	public String getImage(){
		return image;
	}

	/**
	 * Set images.
	 *
	 * @param images the images
	 */
	public void setImages(List<String> images){
		this.images = images;
	}

	/**
	 * Get images list.
	 *
	 * @return the list
	 */
	public List<String> getImages(){
		return images;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Get description string.
	 *
	 * @return the string
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set upc.
	 *
	 * @param upc the upc
	 */
	public void setUpc(String upc){
		this.upc = upc;
	}

	/**
	 * Get upc string.
	 *
	 * @return the string
	 */
	public String getUpc(){
		return upc;
	}

	/**
	 * Set ingredient count.
	 *
	 * @param ingredientCount the ingredient count
	 */
	public void setIngredientCount(int ingredientCount){
		this.ingredientCount = ingredientCount;
	}

	/**
	 * Get ingredient count int.
	 *
	 * @return the int
	 */
	public int getIngredientCount(){
		return ingredientCount;
	}

	/**
	 * Set title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Get title string.
	 *
	 * @return the string
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Set aisle.
	 *
	 * @param aisle the aisle
	 */
	public void setAisle(Object aisle){
		this.aisle = aisle;
	}

	/**
	 * Get aisle object.
	 *
	 * @return the object
	 */
	public Object getAisle(){
		return aisle;
	}

	/**
	 * Set badges.
	 *
	 * @param badges the badges
	 */
	public void setBadges(List<String> badges){
		this.badges = badges;
	}

	/**
	 * Get badges list.
	 *
	 * @return the list
	 */
	public List<String> getBadges(){
		return badges;
	}

	/**
	 * Set generated text.
	 *
	 * @param generatedText the generated text
	 */
	public void setGeneratedText(Object generatedText){
		this.generatedText = generatedText;
	}

	/**
	 * Get generated text object.
	 *
	 * @return the object
	 */
	public Object getGeneratedText(){
		return generatedText;
	}

	/**
	 * Set nutrition.
	 *
	 * @param nutrition the nutrition
	 */
	public void setNutrition(Nutrition nutrition){
		this.nutrition = nutrition;
	}

	/**
	 * Get nutrition nutrition.
	 *
	 * @return the nutrition
	 */
	public Nutrition getNutrition(){
		return nutrition;
	}

	/**
	 * Set servings.
	 *
	 * @param servings the servings
	 */
	public void setServings(Servings servings){
		this.servings = servings;
	}

	/**
	 * Get servings servings.
	 *
	 * @return the servings
	 */
	public Servings getServings(){
		return servings;
	}

	/**
	 * Set credits.
	 *
	 * @param credits the credits
	 */
	public void setCredits(Credits credits){
		this.credits = credits;
	}

	/**
	 * Get credits credits.
	 *
	 * @return the credits
	 */
	public Credits getCredits(){
		return credits;
	}

	/**
	 * Set price.
	 *
	 * @param price the price
	 */
	public void setPrice(Object price){
		this.price = price;
	}

	/**
	 * Get price object.
	 *
	 * @return the object
	 */
	public Object getPrice(){
		return price;
	}

	/**
	 * Set ingredient list.
	 *
	 * @param ingredientList the ingredient list
	 */
	public void setIngredientList(String ingredientList){
		this.ingredientList = ingredientList;
	}

	/**
	 * Get ingredient list string.
	 *
	 * @return the string
	 */
	public String getIngredientList(){
		return ingredientList;
	}

	/**
	 * Set usda code.
	 *
	 * @param usdaCode the usda code
	 */
	public void setUsdaCode(Object usdaCode){
		this.usdaCode = usdaCode;
	}

	/**
	 * Get usda code object.
	 *
	 * @return the object
	 */
	public Object getUsdaCode(){
		return usdaCode;
	}

	/**
	 * Set ingredients.
	 *
	 * @param ingredients the ingredients
	 */
	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	/**
	 * Get ingredients list.
	 *
	 * @return the list
	 */
	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	/**
	 * Set spoonacular score.
	 *
	 * @param spoonacularScore the spoonacular score
	 */
	public void setSpoonacularScore(Object spoonacularScore){
		this.spoonacularScore = spoonacularScore;
	}

	/**
	 * Get spoonacular score object.
	 *
	 * @return the object
	 */
	public Object getSpoonacularScore(){
		return spoonacularScore;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Set category.
	 *
	 * @param category the category
	 */
	public void setCategory(String category){
		this.category = category;
	}

	/**
	 * Get category string.
	 *
	 * @return the string
	 */
	public String getCategory(){
		return category;
	}

	/**
	 * Set image type.
	 *
	 * @param imageType the image type
	 */
	public void setImageType(String imageType){
		this.imageType = imageType;
	}

	/**
	 * Get image type string.
	 *
	 * @return the string
	 */
	public String getImageType(){
		return imageType;
	}

	/**
	 * Set brand.
	 *
	 * @param brand the brand
	 */
	public void setBrand(String brand){
		this.brand = brand;
	}

	/**
	 * Get brand string.
	 *
	 * @return the string
	 */
	public String getBrand(){
		return brand;
	}

	/**
	 * Set breadcrumbs.
	 *
	 * @param breadcrumbs the breadcrumbs
	 */
	public void setBreadcrumbs(List<String> breadcrumbs){
		this.breadcrumbs = breadcrumbs;
	}

	/**
	 * Get breadcrumbs list.
	 *
	 * @return the list
	 */
	public List<String> getBreadcrumbs(){
		return breadcrumbs;
	}

	/**
	 * Set likes.
	 *
	 * @param likes the likes
	 */
	public void setLikes(int likes){
		this.likes = likes;
	}

	/**
	 * Get likes int.
	 *
	 * @return the int
	 */
	public int getLikes(){
		return likes;
	}

	/**
	 * Set important badges.
	 *
	 * @param importantBadges the important badges
	 */
	public void setImportantBadges(List<String> importantBadges){
		this.importantBadges = importantBadges;
	}

	/**
	 * Get important badges list.
	 *
	 * @return the list
	 */
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