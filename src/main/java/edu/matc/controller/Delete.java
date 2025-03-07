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
        urlPatterns = {"/delete-food"}
)

public class Delete extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if("DELETE".equals(method)) {
            doDelete(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("searchFood.jsp");
            rd.forward(request, response);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericDao<Food> genericDao = new GenericDao<>(Food.class);
        try {
            String foodId = request.getParameter("food_to_delete");
            logger.debug("Deleting Food: " + foodId);
            request.setAttribute("foodId", foodId);
            genericDao.deleteEntity(genericDao.getById(Integer.parseInt(foodId)));

            request.setAttribute("title", "Foods");
            request.setAttribute("foods", genericDao.getAll());

            RequestDispatcher rd = request.getRequestDispatcher("searchFood.jsp");
            rd.forward(request, response);
        } catch (Exception e ) {
            logger.error(e);
        }
    }
}
