package edu.matc.controller;

import edu.matc.entity.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/macro-results"}
)

public class MacroCalculator extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
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

            Calculator calculator = new Calculator(ageInt, gender, heightFeetInt, heightInchesInt, weightInt, activity, goal);

            request.setAttribute("results", );
            request.setAttribute("title", "Results");
            RequestDispatcher rd = request.getRequestDispatcher("/macro.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            log("Error processing request: " + e.getMessage(), e);
        }
    }
}
