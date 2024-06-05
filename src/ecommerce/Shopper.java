package ecommerce;

/**
 * Shopper class represents a user of the online shopping system.
 * Encapsulates user information and follows the Single Responsibility Principle.
 */
public class Shopper {
    private String username;
    private String password;
    private String fullName;
    private String email;

    /**
     * Constructs a Shopper with the specified details.
     * 
     * @param username The username of the shopper.
     * @param password The password of the shopper.
     * @param fullName The full name of the shopper.
     * @param email The email address of the shopper.
     */
    public Shopper(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
