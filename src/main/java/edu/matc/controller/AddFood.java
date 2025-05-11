package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * The type Add food.
 */
@WebServlet(
        urlPatterns = {"/add-food"}
)

public class AddFood extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will direct a user to the add food form.
     * @param request servlet request
     * @param response servlet response
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        String sub = session.getAttribute("sub").toString();

        logger.info("sub: " + sub);

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // Set the title of the JSP
                request.setAttribute("title", "Add Food");

                // Tell the server where the request is going to
                RequestDispatcher rd = request.getRequestDispatcher("/addFood.jsp");

                // Forward the request
                rd.forward(request, response);

            } catch (Exception e) {
                logger.debug(e);
            }
        } else {
            // If the session is null, return the user to the login page
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }
}
