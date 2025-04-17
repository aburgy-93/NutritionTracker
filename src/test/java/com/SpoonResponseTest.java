package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.persistence.SpoontacularDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class SpoonResponseTest {
    SpoontacularDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        dao = new SpoontacularDao();
    }

    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("SPOONTACULAR_API_KEY");
    String searchUrl = dotenv.get("SPOONTACULAR_SEARCH_STRING");
    String nutritionUrl = dotenv.get("SPOONTACULAR_NUTRITION_URL");

    @Test
    public void getAPIKey() throws JsonProcessingException {
        assertEquals(apiKey, dotenv.get("SPOONTACULAR_API_KEY"));
        assertEquals(searchUrl, dotenv.get("SPOONTACULAR_SEARCH_STRING"));
        assertEquals(nutritionUrl, dotenv.get("SPOONTACULAR_NUTRITION_URL"));
    }

    @Test
    @Disabled
    public void getProductsFromResponse() throws JsonProcessingException {
        String searchQuery = "chicken%20breast";

        List<Product> foodResponse = dao.searchProduct(searchQuery).getProducts();

        Assertions.assertNotNull(foodResponse);
        assertEquals(8074580, foodResponse);
    }

    @Test
    @Disabled
    public void getProductInResponse() throws JsonProcessingException {
        String searchQuery = "chicken%20breast";

        List<Product> foodResponse = dao.searchProduct(searchQuery).getProducts();

        Assertions.assertNotNull(foodResponse);
        assertEquals(8074580, foodResponse.get(0).getId());
    }

    @Test
    @Disabled
    public void getNutritionFromResponse() throws JsonProcessingException {
        int ID = 22347;

        NutritionResponse nutritionResponse = dao.getNutrition(ID);
        assertNotNull(nutritionResponse);
        assertEquals(ID, nutritionResponse.getId());
    }

    @Test
    @Disabled
    public void getCarbs() throws JsonProcessingException {
        int ID = 22347;

        List<NutrientsItem> returnedNutrients = dao.getNutrients(ID);
        Assertions.assertNotNull(returnedNutrients);
        assertEquals("Carbohydrates", returnedNutrients.get(0).getName());
    }

    @Test
    @Disabled
    public void getCalories() throws JsonProcessingException {
        int ID = 22347;

        List<NutrientsItem> returnedNutrients = dao.getNutrients(ID);
        Assertions.assertNotNull(returnedNutrients);
        assertEquals("Calories", returnedNutrients.get(1).getName());
    }

    @Test
    @Disabled
    public void getFats() throws JsonProcessingException {
        int ID = 22347;

        List<NutrientsItem> returnedNutrients = dao.getNutrients(ID);
        Assertions.assertNotNull(returnedNutrients);
        assertEquals("Fat", returnedNutrients.get(2).getName());
    }

    @Test
    @Disabled
    public void getProtein() throws JsonProcessingException {
        int ID = 22347;

        List<NutrientsItem> returnedNutrients = dao.getNutrients(ID);
        Assertions.assertNotNull(returnedNutrients);
        assertEquals("Protein", returnedNutrients.get(3).getName());
    }
}
