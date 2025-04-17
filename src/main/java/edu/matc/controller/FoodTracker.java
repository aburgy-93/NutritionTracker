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
            // Get offset from url
            String offsetParam = request.getParameter("weekOffSet");

            // initalize offset to 0
            int weekOffSet = 0;

            // check that offsetParam is not null, if a number set weekOffSet to the passed in param
            // if not a number, set to 0
            if (offsetParam != null) {
                try {
                    weekOffSet = Integer.parseInt(offsetParam);
                } catch (NumberFormatException e) {
                    weekOffSet = 0;
                }
            }

            // get today's date
            LocalDate today = LocalDate.now();

            // Set the beginning date to be monday plus the offset
            LocalDate monday = today.with(DayOfWeek.MONDAY).plusWeeks(weekOffSet);

            // Create a list of strings that are dates
            List<String> weekDates = new ArrayList<>();

            // Set up the formatter to format the date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            // In a for loop, loop over the dates starting from 0 but less than 7.
            // For each dat get the current day by calculating the number of days from monday.
            // Format the date by getting the current day of the week and then format the current day date.
            // Add the formatted dates to the weekDates list.
            for (int day = 0; day < 7; day++) {
                LocalDate currentDay = monday.plusDays(day);
                String formattedDate = currentDay.getDayOfWeek() + ", " + currentDay.format(formatter);
                weekDates.add(formattedDate);
            }

            // Set the attributes and forward the request.
            request.setAttribute("title", "Your Meals");
            request.setAttribute("weekDates", weekDates);
            request.setAttribute("weekOffSet", weekOffSet);
            RequestDispatcher rd = request.getRequestDispatcher("/mealsDisplay.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            logger.debug("Error processing request: {}", e.getMessage(), e);
        }
    }
}
