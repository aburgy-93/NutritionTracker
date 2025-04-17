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
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SpoontacularDao spoontacularDao = new SpoontacularDao();
            String idParam = request.getParameter("add_searched_food_to_meal");
            String foodName = request.getParameter("searched_food_name");

            System.out.println("Received ID: " + idParam);
            try {
                int foodId = Integer.parseInt(idParam);

                Servings servings = spoontacularDao.getServings(foodId);
                List<NutrientsItem> nutrientsItemList = spoontacularDao.getNutrients(foodId);
                logger.debug("Nutrients returned: " + nutrientsItemList);


                double calories = (double) nutrientsItemList.get(1).getAmount();
                double protein = (double) nutrientsItemList.get(3).getAmount();
                double carbs = (double) nutrientsItemList.get(0).getAmount();
                double fat = (double) nutrientsItemList.get(2).getAmount();

                request.setAttribute("calories", calories);
                request.setAttribute("protein", protein);
                request.setAttribute("carbs", carbs);
                request.setAttribute("fat", fat);
                request.setAttribute("SearchedFoodId", foodId);
                request.setAttribute("SearchedFoodName", foodName);
                request.setAttribute("SearchedFoodServings", servings);
                request.setAttribute("title", "Track Your Food");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/addSearchedForFood.jsp");
                dispatcher.forward(request, response);
            } catch (NumberFormatException e) {
                //TODO: change to logger
                System.err.println("Invalid number submitted: " + idParam);
            }

        } catch (Exception e) {
            logger.error("Exception in AddSearchedFood servlet", e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Instantiate DAOs
            GenericDao<UserFood> userFoodDao = new GenericDao<>(UserFood.class);
            GenericDao<Food> foodDao = new GenericDao<>(Food.class);
            GenericDao<User> userDao = new GenericDao<>(User.class);

            // Get form data
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

                // Redirect to the meals display page
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
