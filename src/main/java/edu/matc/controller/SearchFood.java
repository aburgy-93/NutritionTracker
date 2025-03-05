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
                request.setAttribute("title", "Search for Foods");
                request.setAttribute("foods", genericDao.getByPropertyLike("foodName", searchTerm));
            } else {
                request.setAttribute("foods", genericDao.getAll());
                request.setAttribute("title", "Search for Foods");
            }

            request.setAttribute("searchTerm", searchTerm);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchFood.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
