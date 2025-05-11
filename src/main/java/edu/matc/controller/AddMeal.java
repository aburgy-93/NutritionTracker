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
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Double.parseDouble;

/**
 * The type Add meal.
 */
@WebServlet(
        urlPatterns = {"/add-meal"}
)

public class AddMeal extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will get the food information from the database based on the id of the food clicked on.
     * The information will then be placed in a form for a user to add to their tracker.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        String sub = session.getAttribute("sub").toString();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // Create a new instance of the GenericDao with the Food class entity
                GenericDao<Food> genericDao = new GenericDao<>(Food.class);

                // Get the food id from the request parameter
                String foodId = request.getParameter("add_food_to_meal");

                // Get the food by calling the getById method and pass in the foodId
                Food foodToAdd = genericDao.getById(Integer.parseInt(foodId));

                // Log the added food data for debugging
                logger.debug("Food to add: " + foodToAdd);

                // Add the foodToAdd as an attribute to the request
                request.setAttribute("foodToAdd", foodToAdd);

                // Set the title for the jsp
                request.setAttribute("title", "Track Your Food");

                // Tell the server where the request is going to
                RequestDispatcher rd = request.getRequestDispatcher("/addMeal.jsp");

                // Forward the request
                rd.forward(request, response);
            } catch (Exception e) {
                logger.error(e);
            }
        } else {
            // TODO: Error Page
        }
    }

    /**
     * Do Post
     * This method will get the information submitted from the form, by the user.
     * It will parse the data to create a new UserFood object to be inserted into the food_tracker database.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        String sub = session.getAttribute("sub").toString();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // Retrieve DAOs for the UserFood and User entities
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
                        // For testing, this is hardcoded
                        // User user = userDao.getById(1);
                        User user = userDao.getBySub("sub", sub);

                        // Create a UserFood entry
                        UserFood foodEnteredByUser = new UserFood(user, foodToAdd, date, servings, mealTime);

                        // Insert the new food entry into the database
                        userFoodDao.insert(foodEnteredByUser);

                        // Redirect to the meals' display page
                        response.sendRedirect(request.getContextPath() + "/meal-display");

                        // Log the success
                        logger.debug("Food entry added successfully: " + foodEnteredByUser);

                        // TODO: Error page
                    } else {
                        // If validation fails, log an error
                        logger.debug("Invalid input detected, unable to add meal.");
                        request.setAttribute("error", "Invalid input. Please check your form data.");
                        request.getRequestDispatcher("/addMeal.jsp").forward(request, response);
                    }

                // TODO: Error page
            } catch (Exception e) {
                // Log the exception with its stack trace
                logger.error("Add Meal Error: " + e.getMessage(), e);
                request.setAttribute("error", "An error occurred while adding the meal.");
                request.getRequestDispatcher("/addMeal.jsp").forward(request, response);
            }
        } else {
            // If the session is null, send the user back to the login page
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
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
