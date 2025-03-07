package edu.matc.controller;

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
        urlPatterns = {"/edit-food"}
)

public class Edit extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if("EDIT".equals(method)) {
            doPut(request, response);
        } else {
            logger.debug(method);
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String foodId = request.getParameter("food_to_edit");
            logger.debug("Editing Food: " + foodId);
            request.setAttribute("foodId", foodId);

            RequestDispatcher rd = request.getRequestDispatcher("editFood.jsp");
            rd.forward(request, response);
        } catch (Exception e ) {
            logger.error(e);
        }
    }
}
