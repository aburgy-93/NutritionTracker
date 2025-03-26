package gov.usda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.cdimascio.dotenv.Dotenv;

public class ProductTest {
    private static final Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("USDA_API_KEY");

    @Test
    public void getAPIKey() throws Exception{
        assertEquals(apiKey, dotenv.get("USDA_API_KEY"));
    }

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.nal.usda.gov/fdc/v1/food/2095236?api_key=QsBQXUsRUxK5bCTPj2PpXc34Y0QOIOpYV2JpWXeP");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response foodResponse = mapper.readValue(response, Response.class);


        String expectedProductName = "CHEDDAR CHEESE";
        int id = 2095236;
        // Validate foodNutrients list
        List<FoodNutrientsItem> foodNutrients = foodResponse.getFoodNutrients();
        assertNotNull(foodNutrients);
        assertFalse(foodNutrients.isEmpty());


        assertEquals(expectedProductName, foodResponse.getDescription());
        assertEquals(id, foodResponse.getFdcId());
        assertEquals(foodNutrients, foodResponse.getFoodNutrients());
    }
}
