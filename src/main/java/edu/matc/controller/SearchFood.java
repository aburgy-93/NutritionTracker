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
        urlPatterns = {"/search-food"}
)

public class SearchFood extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setAttribute("title", "Search for Foods");
            RequestDispatcher rd = request.getRequestDispatcher("/searchFood.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
