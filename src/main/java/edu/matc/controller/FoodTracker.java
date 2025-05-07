package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.UserFood;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.UserfoodDao;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Food tracker.
 */
@WebServlet(
        urlPatterns = {"/meal-display"}
)

public class FoodTracker extends HttpServlet {
    // Create the logger for debugging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do Get
     * This method will set the current week to be displayed in the calendar.
     * It can also take in an offset value to go forward or back a week in the calendar.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get offset from url
            String offsetParam = request.getParameter("weekOffSet");

            // initialize offset to 0
            int weekOffSet = 0;

            // Check that offsetParam is not null, if a number set weekOffSet to the passed in param
            // if not a number, set to 0
            if (offsetParam != null) {
                try {
                    weekOffSet = Integer.parseInt(offsetParam);
                } catch (NumberFormatException e) {
                    weekOffSet = 0;
                }
            }

            // Get today's date
            LocalDate today = LocalDate.now();

            // Set the beginning date to be monday plus the offset
            LocalDate monday = today.with(DayOfWeek.MONDAY).plusWeeks(weekOffSet);

            // Create a list of strings that are dates and with day of week
            List<String> weekDates = new ArrayList<>();

            // Create a list of strings that are just dates
            List<String> isoWeekDates = new ArrayList<>();

            // Set up the formatter to format the date with day of week
            DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("EEEE, MM/dd/yyyy");

            // Set up the formatter to format the date without the day of week
            DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // In a for loop, loop over the dates starting from 0 but less than 7.
            // For each dat get the current day by calculating the number of days from monday.
            // Format the date by getting the current day of the week and then format the current day date.
            // Add the formatted dates to the weekDates list.
            for (int day = 0; day < 7; day++) {
                LocalDate currentDay = monday.plusDays(day);
                weekDates.add(currentDay.format(displayFormatter));
                isoWeekDates.add(currentDay.format(isoFormatter));
            }

            // Get all meals by user from food tracker
            GenericDao<User> userDao = new GenericDao<>(User.class);
            UserfoodDao listFoodDao = new UserfoodDao();

            // TODO: get current user based on who is logged in
            // Get the user
            HttpSession session = request.getSession(false);
            if(session != null) {
                // get the sub string from the session.
                String sub = session.getAttribute("sub").toString();
                logger.info("sub: " + sub);

                User userRetrievedSub = userDao.getBySub("sub", sub);
                logger.info("userRetrievedSub: " + userRetrievedSub);

                if(userRetrievedSub != null) {
                    int userId = userRetrievedSub.getId();

                    // Get all meals made by the user in food_tracker table, organize meals by date
                    Map<String, List<UserFood>> mealsByDate = listFoodDao.getMealsGroupedByMealTimeSortedByDate(userId);

                    // Log the list of foods for debugging
                    logger.debug("Retrieved user food list: " + mealsByDate );

                    // Set the attributes and forward the request.
                    request.setAttribute("title", "Your Meals");
                    request.setAttribute("weekDates", weekDates);
                    request.setAttribute("isoWeekDates", isoWeekDates);
                    request.setAttribute("weekOffSet", weekOffSet);
                    request.setAttribute("meals", mealsByDate);

                    // Tell the server where the request is going
                    RequestDispatcher rd = request.getRequestDispatcher("/mealsDisplay.jsp");

                    // Forward the reqeust and response
                    rd.forward(request, response);
                } else{
                    logger.warn("User not found");
                }
            }

        } catch (Exception e) {
            logger.debug("Error processing request: {}", e.getMessage(), e);
        }
    }
}
