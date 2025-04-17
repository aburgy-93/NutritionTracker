package edu.matc.controller;

import edu.matc.entity.Food;
import edu.matc.entity.User;
import edu.matc.entity.UserFood;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Double.parseDouble;

/**
 * The type Add meal.
 */
@WebServlet(
        urlPatterns = {"/add-meal"}
)

public class AddMeal extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);
            String foodId = request.getParameter("add_food_to_meal");
            Food foodToAdd = genericDao.getById(Integer.parseInt(foodId));

            logger.debug("Food to add: " + foodToAdd);
            request.setAttribute("foodToAdd", foodToAdd);
            request.setAttribute("title", "Track Your Food");

            RequestDispatcher rd = request.getRequestDispatcher("/addMeal.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve DAOs
            GenericDao<UserFood> userFoodDao = new GenericDao<>(UserFood.class);
            GenericDao<User> userDao = new GenericDao<>(User.class);

            // Get form data
            String date = request.getParameter("date");
            String foodIdStr = request.getParameter("food_id");
            String foodName = request.getParameter("food_name");
            String foodType = request.getParameter("food_type");
            String servingsStr = request.getParameter("servings");
            String servingsUnits = request.getParameter("serving_units");
            String mealTime = request.getParameter("meal_times");
            String caloriesStr = request.getParameter("calories");
            String proteinStr = request.getParameter("protein");
            String carbsStr = request.getParameter("carbs");
            String fatStr = request.getParameter("fat");

            // Try to parse numeric values (double), handle potential errors
            double servings = parseDouble(servingsStr);
            double calories = parseDouble(caloriesStr);
            double protein = parseDouble(proteinStr);
            double carbs = parseDouble(carbsStr);
            double fat = parseDouble(fatStr);

            // Validate input (ensure non-null and non-empty for text fields, non-negative for numeric fields)
            if (!isNullOrEmptyString(date) && !isNullOrEmptyString(foodName) && !isNullOrEmptyString(foodType)
                    && !isNullOrEmptyString(mealTime) && servings >= 0 && !isNullOrEmptyString(servingsUnits)
                    && calories >= 0 && protein >= 0 && carbs >= 0 && fat >= 0) {

                // Get the food item from the database using the foodId
                GenericDao<Food> foodDao = new GenericDao<>(Food.class);
                Food foodToAdd = foodDao.getById(Integer.parseInt(foodIdStr));

                // TODO: Retrieve the actual user ID from the session (or Cognito)
                User user = userDao.getById(1);  // For testing, this is hardcoded

                // Create a UserFood entry
                UserFood foodEnteredByUser = new UserFood(user, foodToAdd, date, servings, mealTime);

                // Insert the new food entry into the database
                userFoodDao.insert(foodEnteredByUser);

                // Pass attributes to the request for feedback (success message, meal info, etc.)
//                request.setAttribute("newFood", foodEnteredByUser);
//                request.setAttribute("message", "Food entry added successfully!");

                // Redirect to the meals display page
                response.sendRedirect(request.getContextPath() + "/meal-display");

                // Log the success
                logger.debug("Food entry added successfully: " + foodEnteredByUser);

            } else {
                // If validation fails, log an error
                logger.warn("Invalid input detected, unable to add meal.");
                request.setAttribute("error", "Invalid input. Please check your form data.");
                request.getRequestDispatcher("/addMeal.jsp").forward(request, response);
            }

        } catch (Exception e) {
            logger.error("Add Meal Error: " + e.getMessage(), e);  // Log the exception with its stack trace
            request.setAttribute("error", "An error occurred while adding the meal.");
            request.getRequestDispatcher("/addMeal.jsp").forward(request, response);
        }
    }


    /**
     * checks to see if the string values passed in are null or empty
     * @param str the string
     * @return null or true if empty
     */
    private boolean isNullOrEmptyString(String str) {
        return str == null || str.isEmpty();
    }
}
