package edu.matc.controller;

import edu.matc.entity.Calculator;
import edu.matc.entity.User;
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
import java.util.HashMap;

/**
 * The type Macro calculator.
 */
@WebServlet(
        urlPatterns = {"/macro-results"}
)

public class MacroCalculator extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will get the values from the submitted form, create a new Calculator object, and display the results
     * to the jsp.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        if (session != null && sub != null) {
            try {
                // Get the values from the request
                String age = request.getParameter("age");
                String gender = request.getParameter("gender");
                String heightFeet = request.getParameter("heightFeet");
                String heightInches = request.getParameter("heightInches");
                String weight = request.getParameter("weight");
                String activity = request.getParameter("activity");
                String goal = request.getParameter("goal");

                // Parse the strings that need to be either integers or doubles to their correct datatypes
                int ageInt = Integer.parseInt(age);
                int heightFeetInt = Integer.parseInt(heightFeet);
                int heightInchesInt = Integer.parseInt(heightInches);
                double weightInt = Double.parseDouble(weight);
                double activityLevelInt = Double.parseDouble(activity);

                // Instantiate a new Calculator and pass in the user's information
                Calculator calculator = new Calculator(ageInt, gender, heightFeetInt, heightInchesInt, weightInt, activityLevelInt, goal);

                // Create a HashMap with key, value pairs for the returned values from the calculateMacros method
                HashMap<String, Double> results = calculator.calculateMacros();

                // Set the attributes for the request
                request.setAttribute("results",results);
                request.setAttribute("title", "Macro Calculator");

                // Tell the server where the request is going
                RequestDispatcher rd = request.getRequestDispatcher("/macroResults.jsp");

                // Forward the request and response
                rd.forward(request, response);

                // Log the information for debugging
                logger.info(results);
            } catch (Exception e) {
                logger.debug("Error processing request: {}", e.getMessage(), e);
            }
        } else {
            // TODO: Route to error page
        }
    }
}

