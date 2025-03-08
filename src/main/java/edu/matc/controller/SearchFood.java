package edu.matc.controller;

import edu.matc.entity.Food;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Search food.
 */
@WebServlet(
        urlPatterns = {"/search-food"}
)

public class SearchFood extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Do get.
     * This method will get the searchTerm entered the search box.
     * Check to make sure the searchTerm is not empty. If not then on the genericDao call the getByPropertyLike method and
     * pass in the searchTerm (in this case, we are looking up foodNames, but it could be any property in theory).
     * If the searchTerm is null, then get all the foods.
     * Then forward the request and response off to searchFood.jsp.
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException the io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String searchTerm = request.getParameter("searchTerm");
            GenericDao<Food> genericDao = new GenericDao<>(Food.class);

            if (searchTerm != null && !searchTerm.isEmpty()) {
                request.setAttribute("title", "Foods");
                request.setAttribute("foods", genericDao.getByPropertyLike("foodName", searchTerm));
            } else {
                request.setAttribute("foods", genericDao.getAll());
                request.setAttribute("title", "Foods");
            }

            request.setAttribute("searchTerm", searchTerm);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/searchFood.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    // This function will get a _method value from either a form submit from an ADD, EDIT or DELETE submission
    // The search button, edit button;
    // delete buttons have a _method value attached to them to know what HTTP Verb we want
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String method = request.getParameter("_method");
            if("ADD".equals(method)) {
                doAdd(request, response);
            } else if ("EDIT".equals(method)) {
                doPut(request, response);
            } else if("DELETE".equals(method)) {
                doDelete(request, response);
            } else {
                doUpdate(request, response);
            }

        } catch (Exception e) {
            logger.debug(e);
        }
    }

    /**
     * Do add.
     * If _method == "ADD" we get all the data from the response and put the data into a new Food object.
     * Check to make sure none of the values are empty/null.
     * Set the title of the request and set "foods" to hold the data for all the foods.
     * Forward the request to searchFood.jsp
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
        GenericDao<Food> genericDao = new GenericDao<>(Food.class);
        String foodName = request.getParameter("food_name");
        String foodType = request.getParameter("food_type");
        int servings = Integer.parseInt(request.getParameter("servings"));
        String servingsUnits = request.getParameter("serving_units");
        int calories = Integer.parseInt(request.getParameter("calories"));
        double protein = Double.parseDouble(request.getParameter("protein"));
        double carbs = Double.parseDouble(request.getParameter("carbs"));
        double fat = Double.parseDouble(request.getParameter("fat"));

        if (!isNullOrEmptyString(foodName) && !isNullOrEmptyString(foodType) && servings >= 0 &&
                !isNullOrEmptyString(servingsUnits) && calories >= 0 && !(protein < 0) && !(carbs < 0) && !(fat < 0)) {
            Food newFood = new Food(foodName, foodType, servings, servingsUnits, calories, protein, carbs, fat);
            request.setAttribute("newFood", genericDao.insert(newFood));
        }
        request.setAttribute("title", "Foods");
        request.setAttribute("foods", genericDao.getAll());

        RequestDispatcher rd = request.getRequestDispatcher("/searchFood.jsp");
        rd.forward(request, response);
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
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericDao<Food> genericDao = new GenericDao<>(Food.class);
        try {
            String foodId = request.getParameter("food_to_edit");
            Food foodToEdit = genericDao.getById(Integer.parseInt(foodId));

            logger.debug("Editing Food: " + foodId);
            request.setAttribute("editFood", foodToEdit);
            request.setAttribute("title", "Edit Food");

            RequestDispatcher rd = request.getRequestDispatcher("/editFood.jsp");
            rd.forward(request, response);
        } catch (Exception e ) {
            logger.error(e);
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
     * @param request the request
     * @param response the response
     * @throws IOException the io exception
     * @throws ServletException the servlet exception
     */
    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericDao<Food> genericDao = new GenericDao<>(Food.class);
        try {
            // get id of food entity to edit
            int foodId = Integer.parseInt(request.getParameter("food_to_edit"));
            logger.debug("Editing Food: " + foodId);

            // get that entity from the table
            Food foodToEdit = genericDao.getById(foodId);
            logger.debug("Food to Edit: " + foodToEdit);

            // set the new values
            foodToEdit.setFoodName(request.getParameter("foodName"));
            logger.debug(request.getParameter("foodName"));

            foodToEdit.setFoodType(request.getParameter("foodType"));
            logger.debug(request.getParameter("foodType"));

            foodToEdit.setServingSize((int) Double.parseDouble(request.getParameter("servingSize")));
            logger.debug(request.getParameter("servingSize"));

            foodToEdit.setServingUnit(request.getParameter("servingUnit"));
            logger.debug(request.getParameter("servingUnit"));

            foodToEdit.setCalories(Integer.parseInt(request.getParameter("calories")));
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

    /**
     * Do delete.
     * This method will get the foodId from the request with the name of food_to_delete in the searchFood.jsp.
     * Set the foodId to the response.
     * Call the deleteEntity function from the genericDao and pass in the returned object from the getById method also
     * in the genericDao.
     * Set tje attrbutes on the request.
     * Forward the request, response to /searchFood.jsp
     * @param request the request
     * @param response the response
     * @throws IOException the io exception
     * @throws ServletException the servlet exception
     */
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericDao<Food> genericDao = new GenericDao<>(Food.class);
        try {
            String foodId = request.getParameter("food_to_delete");
            logger.debug("Deleting Food: " + foodId);
            request.setAttribute("foodId", foodId);
            genericDao.deleteEntity(genericDao.getById(Integer.parseInt(foodId)));

            request.setAttribute("title", "Foods");
            request.setAttribute("foods", genericDao.getAll());

            RequestDispatcher rd = request.getRequestDispatcher("/searchFood.jsp");
            rd.forward(request, response);
        } catch (Exception e ) {
            logger.error(e);
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
