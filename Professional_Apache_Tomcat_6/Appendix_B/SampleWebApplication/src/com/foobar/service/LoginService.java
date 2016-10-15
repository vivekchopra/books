package com.foobar.service;
import com.foobar.model.LoginCredentials;
import com.foobar.model.User;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service for logging in user to website
 */
public class LoginService {
    private static Logger logger = Logger.getLogger(
            "com.foobar.service.LoginService");

    /**
     * Verify the user credentials
     *
     * @param loginCredentials Credentials presented by user to log in
     *
     * @return Null on failed login, corresponding User object for successful
     *         login.
     */
    public static User login(LoginCredentials loginCredentials) {
        if (loginCredentials == null) {
            return null;
        }

        logger.log(Level.INFO,
            "Attempting to log in user:" + loginCredentials.getUsername());

        // Typically this would be verified against a database
        if (loginCredentials.getUsername().equals("johndoe") &&
                loginCredentials.getPassword().equals("secret")) {
            User loggedInUser = new User();
            loggedInUser.setUsername(loginCredentials.getUsername());
            loggedInUser.setDisplayName("John J. Doe Jr.");
            loggedInUser.setPreferences(null);
            return loggedInUser;
        }

        return null;
    }
}
