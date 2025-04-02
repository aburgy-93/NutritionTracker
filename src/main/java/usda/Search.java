package usda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search{
	@JsonProperty("foodSearchCriteria")
	private FoodSearchCriteria foodSearchCriteria;

	@JsonProperty("foods")
	private List<FoodsItem> foods;

	@JsonProperty("totalHits")
	private int totalHits;

	@JsonProperty("totalPages")
	private int totalPages;

	@JsonProperty("pageList")
	private List<Integer> pageList;

	@JsonProperty("currentPage")
	private int currentPage;

	@JsonProperty("aggregations")
	private Aggregations aggregations;

	public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteria){
		this.foodSearchCriteria = foodSearchCriteria;
	}

	public FoodSearchCriteria getFoodSearchCriteria(){
		return foodSearchCriteria;
	}

	public void setFoods(List<FoodsItem> foods){
		this.foods = foods;
	}

	public List<FoodsItem> getFoods(){
		return foods;
	}

	public void setTotalHits(int totalHits){
		this.totalHits = totalHits;
	}

	public int getTotalHits(){
		return totalHits;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setPageList(List<Integer> pageList){
		this.pageList = pageList;
	}

	public List<Integer> getPageList(){
		return pageList;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	public void setAggregations(Aggregations aggregations){
		this.aggregations = aggregations;
	}

	public Aggregations getAggregations(){
		return aggregations;
	}

	@Override
 	public String toString(){
		return 
			"Search{" + 
			"foodSearchCriteria = '" + foodSearchCriteria + '\'' + 
			",foods = '" + foods + '\'' + 
			",totalHits = '" + totalHits + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",pageList = '" + pageList + '\'' + 
			",currentPage = '" + currentPage + '\'' + 
			",aggregations = '" + aggregations + '\'' + 
			"}";
		}
}