package edu.matc.controller;

import edu.matc.entity.Food;
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

/**
 * The type Search food.
 */
@WebServlet(
        urlPatterns = {"/search-food"}
)

public class SearchFood extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String searchTerm = request.getParameter("searchTerm");
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);

            if (searchTerm != null && !searchTerm.isEmpty()) {
                request.setAttribute("title", "Foods");
                request.setAttribute("foods", genericDao.getByPropertyLike("foodName", searchTerm));
            } else {
                request.setAttribute("foods", genericDao.getAll());
                request.setAttribute("title", "Foods");
            }

            request.setAttribute("searchTerm", searchTerm);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchFood.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);
            String foodName = request.getParameter("food_name");
            String foodType = request.getParameter("food_type");
            int calories = Integer.parseInt(request.getParameter("calories"));
            double protein = Double.parseDouble(request.getParameter("protein"));
            double carbs = Double.parseDouble(request.getParameter("carbs"));
            double fat = Double.parseDouble(request.getParameter("fat"));

            if(isNullOrEmptyString(foodName) || isNullOrEmptyString(foodType) || calories < 0 || protein < 0 ||
                    carbs < 0 || fat < 0) {
                request.setAttribute("title", "Foods");
                request.setAttribute("foods", genericDao.getAll());
            } else {
                Food newFood = new Food();
            }


            RequestDispatcher rd = request.getRequestDispatcher("/searchFood.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.debug(e);
        }
    }

    private boolean isNullOrEmptyString(String str) {
        return str == null || str.isEmpty();
    }
}
