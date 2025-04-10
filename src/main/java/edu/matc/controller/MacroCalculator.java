package edu.matc.controller;

import edu.matc.entity.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * The type Macro calculator.
 */
@WebServlet(
        urlPatterns = {"/macro-results"}
)

public class MacroCalculator extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String heightFeet = request.getParameter("heightFeet");
        String heightInches = request.getParameter("heightInches");
        String weight = request.getParameter("weight");
        String activity = request.getParameter("activity");
        String goal = request.getParameter("goal");

        try {
            int ageInt = Integer.parseInt(age);
            int heightFeetInt = Integer.parseInt(heightFeet);
            int heightInchesInt = Integer.parseInt(heightInches);
            double weightInt = Double.parseDouble(weight);
            double activityLevelInt = Double.parseDouble(activity);

            Calculator calculator = new Calculator(ageInt, gender, heightFeetInt, heightInchesInt, weightInt, activityLevelInt, goal);
            HashMap<String, Double> results = calculator.calculateMacros();

            request.setAttribute("results",results);
            request.setAttribute("title", "Macro Calculator");
            RequestDispatcher rd = request.getRequestDispatcher("/macroResults.jsp");
            rd.forward(request, response);
            logger.info(results);
        } catch (Exception e) {
            logger.debug("Error processing request: {}", e.getMessage(), e);
        }
    }
}

