package edu.matc.controller;

import edu.matc.entity.Food;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
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
import java.lang.reflect.InvocationTargetException;

/**
 * The type Search food.
 */
@WebServlet(
        urlPatterns = {"/search-food"}
)

public class SearchYourFoods extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do get.
     * This method will get the searchTerm entered the search box.
     * Check to make sure the searchTerm is not empty. If not then on the genericDao call the getByPropertyLike method and
     * pass in the searchTerm (in this case, we are looking up foodNames, but it could be any property in theory).
     * If the searchTerm is null, then get all the foods.
     * Then forward the request and response off to searchYourFoods.jsp.
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // Get the searchTerm from the request
                String searchTerm = request.getParameter("searchTerm");

                // Instantiate the GenericDao with the Food entity
                GenericDao<Food> genericDao = new GenericDao<>(Food.class);

                // Check that the searchTerm is not null or an empty string
                if (searchTerm != null && !searchTerm.isEmpty()) {
                    // If not empty, set the request attributes
                    request.setAttribute("title", "Search Your Foods");
                    request.setAttribute("foods", genericDao.getByPropertyLike("foodName", searchTerm));
                } else {
                    // Else return all of the foods from the genericDao getAll method
                    request.setAttribute("foods", genericDao.getAll());
                    request.setAttribute("title", "Search Your Foods");
                }

                // Set the request attributes
                request.setAttribute("searchTerm", searchTerm);

                // Tell the server where the request will go
                RequestDispatcher dispatcher = request.getRequestDispatcher("/searchYourFoods.jsp");

                // Forward the request and the response
                dispatcher.forward(request, response);
            } catch (Exception e) {
                logger.error(e);
            }
        } else {
            // Route to error page
        }
    }

    /**
     * This function will get a _method value from either a form submit from an ADD, EDIT or DELETE submission
     * @param request servlet request
     * @param response servlet response
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            try {
                // From the request get the value from the _method parameter, then based on that value call the correct method
                String method = request.getParameter("_method");
                if("ADD".equals(method)) {
                    doAdd(request, response);
                } else if ("EDIT".equals(method)) {
                    doPut(request, response);
                } else if ("UPDATE".equals(method)) {
                    doUpdate(request, response);
                } else if("DELETE".equals(method)) {
                    doDelete(request, response);
                } else {
                    doUpdate(request, response);
                }

            } catch (Exception e) {
                logger.debug(e);
            }
        } else {
            // Route to error page
        }
    }

    /**
     * Do add.
     * If _method == "ADD" we get all the data from the response and put the data into a new Food object.
     * Check to make sure none of the values are empty/null.
     * Set the title of the request and set "foods" to hold the data for all the foods.
     * Forward the request to searchYourFoods.jsp
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException          the servlet exception
     * @throws IOException               the io exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            // Instantiate the GenericDao with the Food entity
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);

            try {
                // Get the parameters from the request
                String foodName = request.getParameter("food_name");
                String foodType = request.getParameter("food_type");
                int servings = Integer.parseInt(request.getParameter("servings"));
                String servingsUnits = request.getParameter("serving_units");
                int calories = Integer.parseInt(request.getParameter("calories"));
                double protein = Double.parseDouble(request.getParameter("protein"));
                double carbs = Double.parseDouble(request.getParameter("carbs"));
                double fat = Double.parseDouble(request.getParameter("fat"));

                // Check that the values are not null or empty strings and that integers are not less than 0
                if (!isNullOrEmptyString(foodName) && !isNullOrEmptyString(foodType) && servings >= 0 &&
                        !isNullOrEmptyString(servingsUnits) && calories >= 0 && !(protein < 0) && !(carbs < 0) && !(fat < 0)) {
                    // Create a new Food object, passing in the parameter values
                    Food newFood = new Food(foodName, foodType, servings, servingsUnits, calories, protein, carbs, fat);

                    // Set the request attribute for the new food
                    request.setAttribute("newFood", genericDao.insert(newFood));
                }

                // Set the request attributes and return all foods if null was returned above
                request.setAttribute("title", "Foods");
                request.setAttribute("foods", genericDao.getAll());

                // Tell the server where the request will go
                RequestDispatcher rd = request.getRequestDispatcher("/searchYourFoods.jsp");

                // forward the request and response
                rd.forward(request, response);
            } catch (Exception e) {
                logger.error(e);
            }
        } else {
            // Route to error page
        }
    }

    /**
     * Do put.
     * If _method == "EDIT" we get the foodId from the button click.
     * Get the food object from the genericDao with getById method with foodId as a parameter.
     * Add that foodToEdit to the request attributes, same with the title.
     * Then forward the foodId to the editFood.jsp.
     * Then get the foodToEdit data from the food object.
     * @param request the request
     * @param response the response
     * @throws IOException the io exception
     * @throws ServletException the servlet exception
     */
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null)  {
            // Instantiate the GenericDao with the Food entity
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);

            try {
                // Get the foodId from the request
                String foodId = request.getParameter("food_to_edit");

                // Get the food we want to edit by passing in the foodId into the getById method on the genericDao
                Food foodToEdit = genericDao.getById(Integer.parseInt(foodId));

                // Log food for debugging
                logger.debug("Editing Food: " + foodId);

                // Set the request attributes
                request.setAttribute("editFood", foodToEdit);
                request.setAttribute("title", "Edit Food");

                // Tell the server where the request will go
                RequestDispatcher rd = request.getRequestDispatcher("/editFood.jsp");

                // Forward the request and response
                rd.forward(request, response);
            } catch (Exception e ) {
                logger.error(e);
            }
        } else {
            // Route to error page
        }
    }

    /**
     * Do update.
     * Get the id of a food entity you want to edit.
     * Get the actual food object by using the getById method from the genericDao.
     * Then get each parameter from the request that needs to set on the existing food object (We do not want to create
     * a new food object, but keep the old one and just update it).
     * Then call the update method on the genericDao object and pass in the updated foodToEdit Food object.
     * Then redirect back to the searchFood page.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException      the io exception
     * @throws ServletException the servlet exception
     */
    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        // If the session is not null and the sub string is not null, continue on. Else route to error page
        if (session != null && sub != null) {
            // Instantiate the GenericDao with the Food entity
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);

            try {
                // Get id of food entity to edit
                int foodId = Integer.parseInt(request.getParameter("food_to_edit"));
                logger.debug("Editing Food: " + foodId);

                // get that entity from the table
                Food foodToEdit = genericDao.getById(foodId);
                logger.debug("Food to Edit: " + foodToEdit);

                // Set the new values and log them for debugging
                foodToEdit.setFoodName(request.getParameter("foodName"));
                logger.debug(request.getParameter("foodName"));

                foodToEdit.setFoodType(request.getParameter("foodType"));
                logger.debug(request.getParameter("foodType"));

                foodToEdit.setServingSize((int) Double.parseDouble(request.getParameter("servingSize")));
                logger.debug(request.getParameter("servingSize"));

                foodToEdit.setServingUnit(request.getParameter("servingUnit"));
                logger.debug(request.getParameter("servingUnit"));

                foodToEdit.setCalories(Double.parseDouble(request.getParameter("calories")));
                logger.debug(request.getParameter("calories"));

                foodToEdit.setProtein(Double.parseDouble(request.getParameter("protein")));
                logger.debug(request.getParameter("protein"));

                foodToEdit.setCarbs(Double.parseDouble(request.getParameter("carbs")));
                logger.debug(request.getParameter("carbs"));

                foodToEdit.setFat(Double.parseDouble(request.getParameter("fat")));
                logger.debug(request.getParameter("fat"));

                // pass an updated food object to the update table method
                genericDao.update(foodToEdit);

                // Redirect back to the searchFood page
                response.sendRedirect("search-food");
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    /**
     * Do delete.
     * This method will get the foodId from the request with the name of food_to_delete in the searchYourFoods.jsp.
     * Set the foodId to the response.
     * Call the deleteEntity function from the genericDao and pass in the returned object from the getById method also
     * in the genericDao.
     * Set the attributes on the request.
     * Forward the request, response to /searchYourFoods.jsp
     * @param request the request
     * @param response the response
     * @throws IOException the io exception
     * @throws ServletException the servlet exception
     */
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get the session and sub string from the session
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String sub = user.getSub();

        if(session != null && sub != null) {
            // Instantiate the GenericDao with the Food entity
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);
            try {
                // Get the foodId from the request
                String foodId = request.getParameter("food_to_delete");

                // Log the food to be deleted for debugging
                logger.debug("Deleting Food: " + foodId);

                // Set the request attribute with the foodId
                request.setAttribute("foodId", foodId);

                // Delete the entity by calling the deleteEntity method from the genericDao by passing in the foodId
                genericDao.deleteEntity(genericDao.getById(Integer.parseInt(foodId)));

                // Set the request attributes
                request.setAttribute("title", "Foods");
                request.setAttribute("foods", genericDao.getAll());

                // Tell the server where the request will go
                RequestDispatcher rd = request.getRequestDispatcher("/searchYourFoods.jsp");

                // Forward the request and response
                rd.forward(request, response);
            } catch (Exception e ) {
                logger.error(e);
            }
        } else {
            // TODO: Route to error page
        }
    }

    /**
     * checks to see if the string values passed in are null or empty
     * @param str the string
     * @return null or true if empty
     */
    private boolean isNullOrEmptyString(String str) {
        return str == null || str.isEmpty();
    }

}
