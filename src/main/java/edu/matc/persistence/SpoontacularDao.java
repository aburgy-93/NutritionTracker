package edu.matc.persistence;

import com.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpoontacularDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("SPOONTACULAR_API_KEY");
    String searchUrl = dotenv.get("SPOONTACULAR_SEARCH_STRING");
    String nutritionUrl = dotenv.get("SPOONTACULAR_NUTRITION_URL");
    String nutritionAPIKey = dotenv.get("SPOONTACULAR_API_KEY_NUTRITION");

    public SearchResponse searchProduct(String searchQuery) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(searchUrl + searchQuery + apiKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, SearchResponse.class);
    }

    public List<Product> searchProducts(String searchQuery) throws JsonProcessingException {
        String encodedSearchQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        SearchResponse searchResponse = searchProduct(encodedSearchQuery);
        logger.debug(searchResponse.toString());
        return searchResponse.getProducts();
    }

    public NutritionResponse getNutrition(int nutritionId) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(nutritionUrl + nutritionId + nutritionAPIKey);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        logger.debug(response);
        return mapper.readValue(response, NutritionResponse.class);
    }

    public List<NutrientsItem> getNutrients(int id) throws JsonProcessingException {
        NutritionResponse nutritionResponse = getNutrition(id);
        Nutrition nutrition = nutritionResponse.getNutrition();

        List<String> desiredNutrients = Arrays.asList("Calories", "Carbohydrates", "Protein", "Fat");

        return nutrition.getNutrients().stream()
                .filter(n -> desiredNutrients.contains(n.getName()))
                .collect(Collectors.toList());
    }

    public Servings getServings(int id) throws JsonProcessingException {
        NutritionResponse nutritionResponse = getNutrition(id);

        return nutritionResponse.getServings();
    }
}
