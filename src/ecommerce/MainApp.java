package ecommerce;

import java.util.Scanner;
import java.util.List;
import java.util.regex.Pattern;

/**
 * MainApp class provides a console-based interface for users to interact with the online shopping system.
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shopper currentShopper = null;
        ShopperAuth shopperAuth = new ShopperAuth();
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Inventory inventory = new Inventory();

        // Load items into the inventory
        inventory.addItems(ItemLoader.loadItems());

        while (true) {
            System.out.println("\n========== Online Shopping System ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Items");
            System.out.println("4. Add Item to Basket");
            System.out.println("5. View Basket");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");

            if (currentShopper != null) {
                System.out.println("Logged in as: " + currentShopper.getUsername());
            }

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character.

            switch (choice) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    // Validate input
                    if (!isValidUsername(username)) {
                        System.out.println("Username must contain only lowercase letters.");
                    } else if (!isValidPassword(password)) {
                        System.out.println("Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
                    } else if (!isValidName(name)) {
                        System.out.println("Name must be in the format 'First Last' with the first letter of each word capitalized.");
                    } else if (!isValidEmail(email)) {
                        System.out.println("Email must contain the @ symbol.");
                    } else {
                        shopperAuth.registerShopper(username, password, name, email);
                        ActivityLogger.log("Shopper registered: " + username);
                        System.out.println("Shopper registered successfully!");
                    }
                    break;
                case 2: // Login
                    if (currentShopper != null) {
                        System.out.println("You are already logged in.");
                    } else {
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();
                        currentShopper = shopperAuth.login(loginUsername, loginPassword);

                        if (currentShopper != null) {
                            ActivityLogger.log("Shopper logged in: " + currentShopper.getUsername());
                            System.out.println("Login successful. Welcome, " + currentShopper.getUsername() + "!");
                        } else {
                            ActivityLogger.log("Login failed for shopper: " + loginUsername);
                            System.out.println("Login failed. Please check your credentials.");
                        }
                    }
                    break;
                case 3: // Browse Items
                    displayItemList(inventory.getAllItems());
                    break;
                case 4: // Add Item to Basket
                    if (currentShopper != null) {
                        System.out.print("Enter the item name to add to the basket: ");
                        String itemName = scanner.nextLine();
                        Item selectedItem = findItemByName(inventory.getAllItems(), itemName);

                        if (selectedItem != null) {
                            shoppingBasket.addItem(selectedItem);
                            System.out.println("Item added to the basket.");
                        } else {
                            System.out.println("Item not found in the inventory.");
                        }
                    } else {
                        System.out.println("You need to log in to add items to the basket.");
                    }
                    break;
                case 5: // View Basket
                    if (currentShopper != null) {
                        List<Item> basketItems = shoppingBasket.getItems();
                        System.out.println("\n========== Shopping Basket ==========");
                        for (Item item : basketItems) {
                            System.out.println(item.getItemName() + " - $" + item.getItemPrice());
                        }
                        double totalPrice = calculateTotalPrice(shoppingBasket);
                        System.out.println("Total Price: $" + totalPrice);
                    } else {
                        System.out.println("You need to log in to view your basket.");
                    }
                    break;
                case 6: // Place Order
                    if (currentShopper != null) {
                        System.out.println("Placing an order...");
                        double totalPrice = calculateTotalPrice(shoppingBasket);
                        boolean paymentSuccess = new PaymentHandler().handlePayment(totalPrice, "Credit Card");

                        if (paymentSuccess) {
                            ActivityLogger.log("Order placed for shopper: " + currentShopper.getUsername());
                            System.out.println("Order placed successfully.");
                            shoppingBasket.clear();  // Clear the basket after a successful order
                        } else {
                            ActivityLogger.log("Payment failed for shopper: " + currentShopper.getUsername());
                            System.out.println("Payment failed. Please try again.");
                        }
                    } else {
                        System.out.println("You need to log in to place an order.");
                    }
                    break;
                case 7: // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Validates the format of the username.
     * 
     * @param username The username to validate.
     * @return True if the username is valid, false otherwise.
     */
    private static boolean isValidUsername(String username) {
        return Pattern.matches("^[a-z]+$", username);
    }

    /**
     * Validates the format of the password.
     * 
     * @param password The password to validate.
     * @return True if the password is valid, false otherwise.
     */
    private static boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$", password);
    }

    /**
     * Validates the format of the name.
     * 
     * @param name The name to validate.
     * @return True if the name is valid, false otherwise.
     */
    private static boolean isValidName(String name) {
        return Pattern.matches("^[A-Z][a-z]* [A-Z][a-z]*$", name);
    }

    /**
     * Validates the format of the email.
     * 
     * @param email The email to validate.
     * @return True if the email is valid, false otherwise.
     */
    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    /**
     * Displays a list of items.
     * 
     * @param itemList The list of items to display.
     */
    private static void displayItemList(List<Item> itemList) {
        System.out.println("\n========== Item List ==========");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.println((i + 1) + ". " + item.getItemName() + " - $" + item.getItemPrice());
            System.out.println("   Description: " + item.getItemDescription());
            System.out.println("   Quantity in Stock: " + item.getItemStock());
        }
    }

    /**
     * Finds an item by its name from a list of items.
     * 
     * @param inventoryItems The list of items to search.
     * @param itemName The name of the item to find.
     * @return The item if found, or null if no item with the given name exists.
     */
    private static Item findItemByName(List<Item> inventoryItems, String itemName) {
        for (Item item : inventoryItems) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Calculates the total price of items in the shopping basket.
     * 
     * @param shoppingBasket The shopping basket to calculate the total price for.
     * @return The total price of items in the shopping basket.
     */
    private static double calculateTotalPrice(ShoppingBasket shoppingBasket) {
        double total = 0.0;
        for (Item item : shoppingBasket.getItems()) {
            total += item.getItemPrice();
        }
        return total;
    }
}
