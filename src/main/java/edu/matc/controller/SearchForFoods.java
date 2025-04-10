package edu.matc.controller;

import edu.matc.entity.Food;
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
import java.lang.reflect.InvocationTargetException;

/**
 * The type Search food.
 */
@WebServlet(
        urlPatterns = {"/search"}
)

public class SearchForFoods extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            String search = request.getParameter("search");
            SpoontacularDao spoontacularDao = new SpoontacularDao();

            if (search != null && !search.isEmpty()) {
                var results = spoontacularDao.searchProducts(search);
                request.setAttribute("title", "Search For Foods");
                request.setAttribute("products", results);
                logger.info(results);
            } else {
                request.setAttribute("title", "Search For Foods");
            }

            request.setAttribute("search", search);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchForFoods.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error("Error in SearchForFoods", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong.");
        }
    }
}
