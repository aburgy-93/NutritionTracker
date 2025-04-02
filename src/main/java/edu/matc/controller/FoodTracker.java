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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Food tracker.
 */
@WebServlet(
        urlPatterns = {"/meal-display"}
)

public class FoodTracker extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LocalDate today = LocalDate.now();
            LocalDate monday = today.with(DayOfWeek.MONDAY);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            List<String> weekDates = new ArrayList<>();
            for (int day = 0; day < 7; day++) {
                LocalDate currentDay = monday.plusDays(day);
                String formattedDate = currentDay.getDayOfWeek() + ", " + currentDay.format(formatter);
                weekDates.add(formattedDate);
            }

            request.setAttribute("title", "Meals Display");
            request.setAttribute("weekDates", weekDates);
            RequestDispatcher rd = request.getRequestDispatcher("/mealsDisplay.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.debug("Error processing request: {}", e.getMessage(), e);
        }
    }
}
