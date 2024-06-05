package ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * ShopperAuth class manages user authentication.
 * Implements the Single Responsibility Principle by focusing on user registration and login.
 */
public class ShopperAuth {
    private List<Shopper> shoppers;

    /**
     * Constructs a ShopperAuth object with an empty list of shoppers.
     */
    public ShopperAuth() {
        this.shoppers = new ArrayList<>();
    }

    /**
     * Registers a new shopper.
     * 
     * @param username The username of the shopper.
     * @param password The password of the shopper.
     * @param fullName The full name of the shopper.
     * @param email The email address of the shopper.
     */
    public void registerShopper(String username, String password, String fullName, String email) {
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }
        Shopper newShopper = new Shopper(username, password, fullName, email);
        shoppers.add(newShopper);
        System.out.println("Shopper registered successfully!");
    }

    /**
     * Logs in an existing shopper.
     * 
     * @param username The username of the shopper.
     * @param password The password of the shopper.
     * @return The shopper if the credentials are valid, or null if invalid.
     */
    public Shopper login(String username, String password) {
        for (Shopper shopper : shoppers) {
            if (shopper.getUsername().equals(username) && shopper.getPassword().equals(password)) {
                return shopper;
            }
        }
        return null;
    }

    /**
     * Checks if a username is already taken.
     * 
     * @param username The username to check.
     * @return True if the username is taken, false otherwise.
     */
    private boolean isUsernameTaken(String username) {
        for (Shopper shopper : shoppers) {
            if (shopper.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
