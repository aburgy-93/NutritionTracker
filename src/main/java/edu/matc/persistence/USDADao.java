package com.nutritiontracker.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import usda.FoodsItem;
import usda.Search;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The type Usda dao.
 */
public class USDADao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    /**
     * The Search url.
     */
    String searchUrl = dotenv.get("USDA_SEARCH_STRING");
    /**
     * The Api key.
     */
    String apiKey = dotenv.get("USDA_API_KEY");


    /**
     * Search food search.
     *
     * @param searchString the search string
     * @return the search
     * @throws JsonProcessingException the json processing exception
     */
    public Search searchFood(String searchString) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(searchUrl + searchString +"&dataType=Branded&pageSize=25&pageNumber=2&sortBy=dataType.keyword&sortOrder=asc" + apiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, Search.class);
    }

    /**
     * Gets foods list.
     *
     * @param searchString the search string
     * @return the foods list
     * @throws JsonProcessingException the json processing exception
     */
    public List<FoodsItem> getFoodsList(String searchString) throws JsonProcessingException {
        Search searchResult = searchFood(searchString);
        logger.debug(searchResult);
        return searchResult.getFoods();
    }
}

