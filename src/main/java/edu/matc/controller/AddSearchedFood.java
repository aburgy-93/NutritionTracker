package edu.matc.controller;

import com.NutrientsItem;
import com.Servings;
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
}
