package edu.matc.controller;

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

@WebServlet(
        urlPatterns = {"/edit-meal"}
)

public class EditMeal extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<UserFood> genericDao = new GenericDao<>(UserFood.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String mealId = request.getParameter("mealId");
            UserFood foodToEdit = genericDao.getById(Integer.parseInt(mealId));

            logger.debug("Editing Meal: " + foodToEdit);
            request.setAttribute("editMeal", foodToEdit);
            request.setAttribute("title", "Edit Meal");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/editMeal.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error("Error in doGet for EditMeal: ", e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int mealId = Integer.parseInt(request.getParameter("food_to_edit"));
            logger.debug("Editing Meal: " + mealId);

            UserFood mealToEdit = genericDao.getById(mealId);
            logger.debug("Editing Meal: " + mealToEdit);

            // set the new values

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


            // pass an updated food object to the update table method
            genericDao.update(mealToEdit);

            // Redirect back to the searchFood page
            response.sendRedirect("meal-display");

        } catch (Exception e) {
            logger.error("Error updating meal in doPost for EditMeal: ", e);
        }
    }
}
