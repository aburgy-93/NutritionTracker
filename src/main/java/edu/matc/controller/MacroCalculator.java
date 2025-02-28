package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/macro-results"}
)

public class MacroCalculator extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            RequestDispatcher rd = request.getRequestDispatcher("/macro.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            log("Error processing request: " + e.getMessage(), e);
        }
    }
}
