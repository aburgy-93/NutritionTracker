package edu.matc.persistence;

import com.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Spoontacular dao.
 */
public class SpoontacularDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    /**
     * The Api key.
     */
    String apiKey = dotenv.get("SPOONTACULAR_API_KEY");
    /**
     * The Search url.
     */
    String searchUrl = dotenv.get("SPOONTACULAR_SEARCH_STRING");
    /**
     * The Nutrition url.
     */
    String nutritionUrl = dotenv.get("SPOONTACULAR_NUTRITION_URL");
    /**
     * The Nutrition api key.
     */
    String nutritionAPIKey = dotenv.get("SPOONTACULAR_API_KEY_NUTRITION");

    /**
     * Search product search response.
     *
     * @param searchQuery the search query
     * @return the search response
     * @throws JsonProcessingException the json processing exception
     */
    public SearchResponse searchProduct(String searchQuery) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(searchUrl + searchQuery + apiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, SearchResponse.class);
    }

    /**
     * Search products list.
     *
     * @param searchQuery the search query
     * @return the list
     * @throws JsonProcessingException the json processing exception
     */
    public List<Product> searchProducts(String searchQuery) throws JsonProcessingException {
        String encodedSearchQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        SearchResponse searchResponse = searchProduct(encodedSearchQuery);
        logger.debug(searchResponse.toString());
        return searchResponse.getProducts();
    }

    /**
     * Gets nutrition.
     *
     * @param nutritionId the nutrition id
     * @return the nutrition
     * @throws JsonProcessingException the json processing exception
     */
    public NutritionResponse getNutrition(int nutritionId) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(nutritionUrl + nutritionId + nutritionAPIKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, NutritionResponse.class);
    }

    /**
     * Gets nutrients.
     *
     * @param id the id
     * @return the nutrients
     * @throws JsonProcessingException the json processing exception
     */
    public List<NutrientsItem> getNutrients(int id) throws JsonProcessingException {
        NutritionResponse nutritionResponse = getNutrition(id);
        Nutrition nutrition = nutritionResponse.getNutrition();

        List<String> desiredNutrients = Arrays.asList("Calories", "Carbohydrates", "Protein", "Fat");

        return nutrition.getNutrients().stream()
                .filter(n -> desiredNutrients.contains(n.getName()))
                .collect(Collectors.toList());
    }

    /**
     * Gets servings.
     *
     * @param id the id
     * @return the servings
     * @throws JsonProcessingException the json processing exception
     */
    public Servings getServings(int id) throws JsonProcessingException {
        NutritionResponse nutritionResponse = getNutrition(id);

        return nutritionResponse.getServings();
    }
}
