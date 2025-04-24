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
        urlPatterns = {"/delete-meal"}
)

public class DeleteMeal extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if (method.equals("DELETE")) {
            doDelete(request, response);
        }

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<UserFood> genericDao = new GenericDao<>(UserFood.class);
        try {
            String mealID = request.getParameter("food_to_delete");
            logger.debug("mealToDelete: " + mealID);

            if (mealID != null) {
                int mealToDelete = Integer.parseInt(mealID);
                UserFood foodToDelete = genericDao.getById(mealToDelete);
                logger.debug("foodToDelete: " + foodToDelete);

                if (foodToDelete != null) {
                    genericDao.deleteEntity(foodToDelete);
                    logger.debug("Deleted Meal: " + foodToDelete);
                }
            }

            response.sendRedirect(request.getContextPath() + "/meal-display");
        } catch (Exception e) {
            logger.error("Error while deleting meal", e);
        }
    }
}
