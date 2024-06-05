package ecommerce;

/**
 * ActivityLogger class provides simple logging functionality.
 * Follows the Single Responsibility Principle by focusing solely on logging messages.
 */
public class ActivityLogger {
    /**
     * Logs a message to the console.
     * 
     * @param message The message to be logged.
     */
    public static void log(String message) {
        System.out.println(message);
    }
}
