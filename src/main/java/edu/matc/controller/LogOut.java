package com.nutritiontracker.controller;

import com.nutritiontracker.persistence.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Log in.
 */
@WebServlet(
        urlPatterns = {"/logOut"}
)

/** Begins the authentication process using AWS Cognito
 *
 */
public class LogOut extends HttpServlet implements PropertiesLoader {
    /**
     * The Properties.
     */
    Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The constant CLIENT_ID.
     */
    public static String CLIENT_ID;
    /**
     * The constant LOGIN_URL.
     */
    public static String LOGOUT_URL;
    /**
     * The constant REDIRECT_URL.
     */
    public static String LOGOUT_REDIRECT_URL;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read in the cognito props file and get the client id and required urls
     * for authenticating a user.
     */
    // TODO This code appears in a couple classes, consider using a startup servlet similar to adv java project
    // 4 to do this work a single time and put the properties in the application scope
    private void loadProperties() throws IOException {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            LOGOUT_URL = properties.getProperty("logoutURL");
            LOGOUT_REDIRECT_URL = properties.getProperty("logoutRedirectUrl");
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO if properties weren't loaded properly, route to an error page
        // Get session without creating a new one
        HttpSession session = req.getSession(false);
        String sub = req.getParameter("sub");

        // Destroy the session
        if (session != null) {
            session.invalidate(); // Destroys the session

            logger.debug("Session invalidated: " + sub);
        }

        // TODO: Rewrite string so not hard coded
        String url = "https://us-east-2if53rzaoz.auth.us-east-2.amazoncognito.com/logout?client_id=43d94gjlojq8i6oq4btbas462v&logout_uri=http://localhost:8080/NutritionTracker_war/logout.jsp";
        logger.debug(url);
        resp.sendRedirect(url);
    }
}