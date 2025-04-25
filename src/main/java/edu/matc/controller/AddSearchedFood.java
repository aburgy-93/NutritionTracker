package edu.matc.controller;

import com.NutrientsItem;
import com.Servings;
import edu.matc.entity.Food;
import edu.matc.entity.User;
import edu.matc.entity.UserFood;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.SpoontacularDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * The type Add searched food.
 */
@WebServlet(
        urlPatterns = {"/add-searched-meal"}
)

public class AddSearchedFood extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will get the food information from the spoonactular API with the search term
     * a user enters, and when a user clicks on the food, the nutrition information will be populated in a form.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Instantiate the SpoontactularDao
            SpoontacularDao spoontacularDao = new SpoontacularDao();

            // Get the id of the searched for food from the request
            String idParam = request.getParameter("add_searched_food_to_meal");

            // Get the name of the searched for food from the request
            String foodName = request.getParameter("searched_food_name");

            // Log the id of the searched for food for debugging
            System.out.println("Received ID: " + idParam);

            try {
                // Parse the id to an integer
                int foodId = Integer.parseInt(idParam);

                // From the spoontacularDao get the servings of the food from the foodId
                Servings servings = spoontacularDao.getServings(foodId);

                // Create a list containing the food's nutrients and map it to the NutrientsItem entity based on foodId
                List<NutrientsItem> nutrientsItemList = spoontacularDao.getNutrients(foodId);

                // Log the list for debuggin
                logger.debug("Nutrients returned: " + nutrientsItemList);

                // From the list cast the nutrient information to a double and save to local variables
                double calories = (double) nutrientsItemList.get(1).getAmount();
                double protein = (double) nutrientsItemList.get(3).getAmount();
                double carbs = (double) nutrientsItemList.get(0).getAmount();
                double fat = (double) nutrientsItemList.get(2).getAmount();

                // Set the attributes for the food on the request
                request.setAttribute("calories", calories);
                request.setAttribute("protein", protein);
                request.setAttribute("carbs", carbs);
                request.setAttribute("fat", fat);
                request.setAttribute("SearchedFoodId", foodId);
                request.setAttribute("SearchedFoodName", foodName);
                request.setAttribute("SearchedFoodServings", servings);
                request.setAttribute("title", "Track Your Food");

                // Tell the server where the request will be sent to
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addSearchedForFood.jsp");

                // forward the request
                dispatcher.forward(request, response);
            } catch (NumberFormatException e) {
                // Log any errors
                logger.error("Invalid number submitted: " + idParam);
            }

        } catch (Exception e) {
            logger.error("Exception in AddSearchedFood servlet", e);
        }
    }

    /**
     * Do Post
     * This method will add the food a user entered in the form to their food table to be used again in the future.
     * The new food will be stored in the food database.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Instantiate DAOs with their respective entities
            GenericDao<UserFood> userFoodDao = new GenericDao<>(UserFood.class);
            GenericDao<Food> foodDao = new GenericDao<>(Food.class);
            GenericDao<User> userDao = new GenericDao<>(User.class);

            // Get the form data
            String date = request.getParameter("date");
            String foodIdStr = request.getParameter("searched_food_id");
            String foodName = request.getParameter("food_name");
            String foodType = request.getParameter("food_type");
            String servingsStr = request.getParameter("servings");
            String servingUnits = request.getParameter("serving_units");
            String mealTime = request.getParameter("meal_times");
            String caloriesStr = request.getParameter("calories");
            String proteinStr = request.getParameter("protein");
            String carbsStr = request.getParameter("carbs");
            String fatStr  = request.getParameter("fat");

            // Check for null values before parsing
            if (isNullOrEmptyString(servingsStr) || isNullOrEmptyString(caloriesStr) || isNullOrEmptyString(proteinStr)
                || isNullOrEmptyString(carbsStr) || isNullOrEmptyString(fatStr)) {
                logger.error("Missing or empty numeric input(s): servings='{}', calories='{}', protein='{}', carbs='{}', fats='{}'",
                        servingsStr, caloriesStr, proteinStr, carbsStr, fatStr);

                request.setAttribute("error", "Missing numeric inputs. Please make sure all fields are filled.");
                request.getRequestDispatcher("/addSearchedForFood.jsp").forward(request, response);
                return;
            }

            // Parse numeric values (double), handle potential errors
            double servings = parseDouble(servingsStr);
            double calories = parseDouble(caloriesStr);
            double protein = parseDouble(proteinStr);
            double carbs = parseDouble(carbsStr);
            double fats = parseDouble(fatStr);

            // Validate input (ensure non-null and non-empty for text fields, non-negative for numeric fields)
            if(!isNullOrEmptyString(date) && !isNullOrEmptyString(foodName) && !isNullOrEmptyString(foodType)
                    && !isNullOrEmptyString(mealTime) && servings >= 0 && !isNullOrEmptyString(servingUnits)
                    && calories >= 0 && protein >= 0 && carbs >= 0 && fats >=0) {

                // TODO: Retrieve the actual user ID from the session (or Cognito)
                User user = userDao.getById(1);  // For testing, this is hardcoded

                // Create food to be entered
                Food foodToAdd = new Food(foodName, foodType, servings, servingUnits, calories, protein, carbs, fats);

                // Save food to food DB
                foodDao.insert(foodToAdd);

                // Create a UserFood entry
                UserFood mealEnteredByUser = new UserFood(user, foodToAdd, date, servings, mealTime);

                // Check to make sure the meal is not null
                if (mealEnteredByUser == null) {
                    logger.error("MealEnteredByUser is null");
                }

                // Insert new meal into the database
                userFoodDao.insert(mealEnteredByUser);

                // Redirect to the meals' display page
                response.sendRedirect(request.getContextPath() + "/meal-display");

                // Log the success
                logger.debug("Meal entered by user was successful: " + mealEnteredByUser);
            } else {
                // Check for data errors
                logger.debug("Form inputs: date={}, foodName={}, foodType={}, mealTime={}, servings={}, servingUnits={}, calories={}, protein={}, carbs={}, fats={}",
                        date, foodName, foodType, mealTime, servings, servingUnits, calories, protein, carbs, fats);

                // if validation fails
                logger.error("Invalid input detected, unable to add Food");
                request.setAttribute("error", "Invalid input detected. Please check your form data");
                request.getRequestDispatcher("/addSearchedForFood.jsp").forward(request, response);
            }

        } catch (Exception e) {
            logger.error("Add searched food failed " + e.getMessage(), e);
            request.setAttribute("error", "An error occurred while adding the searched food to the database.");
            request.getRequestDispatcher("/addSearchedForFood.jsp");
        }
    }

    private boolean isNullOrEmptyString(String str) {
        return str == null || str.isEmpty();
    }
}
