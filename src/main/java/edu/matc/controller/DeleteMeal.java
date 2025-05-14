package com.nutritiontracker.controller;

import com.nutritiontracker.entity.User;
import com.nutritiontracker.entity.UserFood;
import com.nutritiontracker.persistence.GenericDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * The type Delete meal.
 */
@WebServlet(
        urlPatterns = {"/delete-meal"}
)

public class DeleteMeal extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Post
     * This method will check to see if the returned value from _method == DELETE.
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
            // Get the which _method was submitted with the form
            String method = request.getParameter("_method");

            // If the method was a DELETE request, then call the doDelete method and pass in the request and response
            if (method.equals("DELETE")) {
                doDelete(request, response);
            }
        } else {
            // TODO: Route to error page
        }

    }

    /**
     * Do Delete
     * This method will get an id of a meal to delete in the food_tracker.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            // Instantiate the GenericDao with the UserFood entity
            GenericDao<UserFood> genericDao = new GenericDao<>(UserFood.class);

            try {
                // Get the meal id from the parameter food_to_delete
                String mealID = request.getParameter("food_to_delete");

                // Log id for debugging to make sure correct id is captured
                logger.debug("mealToDelete: " + mealID);

                // If mealID is not null
                if (mealID != null) {
                    // Parse mealID to an integer
                    int mealToDelete = Integer.parseInt(mealID);

                    // Use the genericDao to get the meal by passing in the id
                    UserFood foodToDelete = genericDao.getById(mealToDelete);

                    // Log meal to make sure the correct meal is being deleted for debugging
                    logger.debug("foodToDelete: " + foodToDelete);

                    // If foodToDelete exists and does not return null
                    if (foodToDelete != null) {
                        // Call the deleteEntity method on the genericDao and pass in the meal id
                        genericDao.deleteEntity(foodToDelete);

                        // Log the success message for debugging
                        logger.debug("Successfully deleted Meal: " + foodToDelete);
                    }
                }

                // Redirect user to the /meal-display route to view changes
                response.sendRedirect(request.getContextPath() + "/meal-display");
            } catch (Exception e) {
                logger.error("Error while deleting meal", e);
            }
        } else {
            // TODO: Route to error page
        }
    }
}
