package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.persistence.SpoontacularDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class ResponseTest {
    SpoontacularDao dao;

    @BeforeEach
    void setUp() {
        dao = new SpoontacularDao();
    }

    private static final Dotenv dotenv = Dotenv.load();
    String searchUrl = dotenv.get("SPOONTACULAR_SEARCH_STRING");
    String apiKey = dotenv.get("SPOONTACULAR_API_KEY");

    @Test
    public void getAPIKey() throws JsonProcessingException {
        assertNotNull(searchUrl, dotenv.get("SPOONTACULAR_SEARCH_STRING"));
        assertEquals(apiKey, dotenv.get("SPOONTACULAR_API_KEY"));
    }

    @Test
    @Disabled
    public void getProductsList() throws JsonProcessingException {
        String searchQuery = "chicken%20breast";

        List<Product> foodResponse = dao.searchProduct(searchQuery).getProducts();

        assertNotNull(foodResponse);
        assertEquals(8074580, foodResponse);
    }

    @Test
    public void getProduct() throws JsonProcessingException {
        String searchQuery = "chicken%20breast";

        List<Product> foodResponse = dao.searchProduct(searchQuery).getProducts();

        assertNotNull(foodResponse);
        assertEquals(8074580, foodResponse.get(0).getId());
    }
}
