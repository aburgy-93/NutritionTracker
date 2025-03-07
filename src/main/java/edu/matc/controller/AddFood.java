package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/add-food"}
)

public class AddFood extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("title", "Add Food");
            RequestDispatcher rd = request.getRequestDispatcher("/addFood.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.debug(e);
        }
    }
}
