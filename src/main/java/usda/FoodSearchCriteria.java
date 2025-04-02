package usda;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodSearchCriteria{
	@JsonProperty("pageNumber")
	private int pageNumber;

	@JsonProperty("generalSearchInput")
	private String generalSearchInput;

	@JsonProperty("query")
	private String query;

	@JsonProperty("numberOfResultsPerPage")
	private int numberOfResultsPerPage;

	@JsonProperty("pageSize")
	private int pageSize;

	@JsonProperty("requireAllWords")
	private boolean requireAllWords;

	public void setPageNumber(int pageNumber){
		this.pageNumber = pageNumber;
	}

	public int getPageNumber(){
		return pageNumber;
	}

	public void setGeneralSearchInput(String generalSearchInput){
		this.generalSearchInput = generalSearchInput;
	}

	public String getGeneralSearchInput(){
		return generalSearchInput;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setNumberOfResultsPerPage(int numberOfResultsPerPage){
		this.numberOfResultsPerPage = numberOfResultsPerPage;
	}

	public int getNumberOfResultsPerPage(){
		return numberOfResultsPerPage;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setRequireAllWords(boolean requireAllWords){
		this.requireAllWords = requireAllWords;
	}

	public boolean isRequireAllWords(){
		return requireAllWords;
	}

	@Override
 	public String toString(){
		return 
			"FoodSearchCriteria{" + 
			"pageNumber = '" + pageNumber + '\'' + 
			",generalSearchInput = '" + generalSearchInput + '\'' + 
			",query = '" + query + '\'' + 
			",numberOfResultsPerPage = '" + numberOfResultsPerPage + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",requireAllWords = '" + requireAllWords + '\'' + 
			"}";
		}
}