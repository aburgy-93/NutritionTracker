package gov.usda;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.persistence.USDADao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import io.github.cdimascio.dotenv.Dotenv;
import usda.FoodsItem;

import java.util.List;

public class ProductTest {
    USDADao dao;

    @BeforeEach
    void setUp() {
        dao = new USDADao();
    }

    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("USDA_API_KEY");
    String searchUrl = dotenv.get("USDA_SEARCH_STRING");

    @Test
    public void getAPIKey() throws Exception{
        assertEquals(apiKey, dotenv.get("USDA_API_KEY"));
        assertNotNull(searchUrl, dotenv.get("USDA_SEARCH_STRING"));
    }

    @Test
    public void testSearch() throws JsonProcessingException {
        String searchQuery = "cheese";

        List<FoodsItem> expectedFoodsList = dao.searchFood(searchQuery).getFoods();
        List<FoodsItem> actualFoodsList = dao.getFoodsList(searchQuery);

        assertNotNull(actualFoodsList);
        assertEquals(expectedFoodsList, actualFoodsList);
    }
}
