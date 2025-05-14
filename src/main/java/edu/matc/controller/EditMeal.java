package com.nutritiontracker.controller;

import com.nutritiontracker.entity.User;
import com.nutritiontracker.entity.UserFood;
import com.nutritiontracker.persistence.GenericDao;

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

@WebServlet(
        urlPatterns = {"/edit-meal"}
)

public class EditMeal extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Instantiate the GenericDao with the UserFood entity
    GenericDao<UserFood> genericDao = new GenericDao<>(UserFood.class);

    /**
     * Do Get
     * This method will get the food information of a passed in id if it exists to be edited.
     * It will populate the food nutrition information into a form.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // TODO: Check for null!
                // Get the mealId from the request
                String mealId = request.getParameter("mealId");

                // Get the meal from UserFood based on the mealId passed in
                UserFood foodToEdit = genericDao.getById(Integer.parseInt(mealId));

                // Check to see if meal exists in the database
                if (foodToEdit == null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPages/400Error.jsp");
                    dispatcher.forward(request, response);
                }

                // Log meal for debugging
                logger.debug("Editing Meal: " + foodToEdit);

                // Set the attributes for the reqeust
                request.setAttribute("editMeal", foodToEdit);
                request.setAttribute("title", "Edit Meal");

                // Tell the server where the reqeust will go
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editMeal.jsp");

                // Forward the request and response
                dispatcher.forward(request, response);
            } catch (Exception e) {
                logger.error("Error in doGet for EditMeal: ", e);
            }
        } else {
            // TODO: Error Page
        }
    }

    /**
     * Do Post
     * This method will update the meal whose ID was passed in.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // Get the mealId from the request and parse it as an integer
                int mealId = Integer.parseInt(request.getParameter("food_to_edit"));

                // Log the mealId for debugging
                logger.debug("Edited Meal: " + mealId);

                // Get the meal specified by the mealId with the getById method from the genericDao
                UserFood mealToEdit = genericDao.getById(mealId);

                // set the new values and log them for debugging
                mealToEdit.setServingSize((int) Double.parseDouble(request.getParameter("servingSize")));
                logger.debug(request.getParameter("servingSize"));

                mealToEdit.setMealTime(request.getParameter("meal_times"));
                logger.debug(request.getParameter("meal_times"));

                mealToEdit.setUpdatedCalories(Double.parseDouble(request.getParameter("calories")));
                logger.debug(request.getParameter("calories"));

                mealToEdit.setUpdatedProtein(Double.parseDouble(request.getParameter("protein")));
                logger.debug(request.getParameter("protein"));

                mealToEdit.setUpdatedCarbs(Double.parseDouble(request.getParameter("carbs")));
                logger.debug(request.getParameter("carbs"));

                mealToEdit.setUpdatedFats(Double.parseDouble(request.getParameter("fat")));
                logger.debug(request.getParameter("fat"));

                // Pass an updated food object to the update table method
                genericDao.update(mealToEdit);

                // Redirect back to the searchFood page
                response.sendRedirect("meal-display");

            } catch (Exception e) {
                logger.error("Error updating meal in doPost for EditMeal: ", e);
            }
        }

    }
}
