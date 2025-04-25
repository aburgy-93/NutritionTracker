package edu.matc.controller;

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

/**
 * The type Search food.
 */
@WebServlet(
        urlPatterns = {"/search"}
)

public class SearchForFoods extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will return the foods that a user searched for by using the spoonacular API.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            // Get the search term from the request
            String search = request.getParameter("search");

            // Instantiate the spoontacularDao
            SpoontacularDao spoontacularDao = new SpoontacularDao();

            // Check if search is not null and not an empty string
            if (search != null && !search.isEmpty()) {
                // Get the results from the spoontacularDao with the passed in search term
                var results = spoontacularDao.searchProducts(search);

                // Set the request attributes
                request.setAttribute("title", "Search For Foods");
                request.setAttribute("products", results);

                // Log the results information for debugging
                logger.info(results);
            } else {
                request.setAttribute("title", "Search For Foods");
            }

            // Set the request attributes
            request.setAttribute("search", search);

            // Tell the server where the request will go
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchForFoods.jsp");

            // Forward the reqeust and response
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error("Error in SearchForFoods", e);
            // Change this later
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong.");
        }
    }
}
