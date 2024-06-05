package ecommerce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * MainAppGUI class provides a graphical user interface for the online shopping system.
 */
public class MainAppGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private Shopper currentShopper;
    private ShopperAuth shopperAuth;
    private ShoppingBasket shoppingBasket;
    private Inventory inventory;

    public MainAppGUI() {
        super("Online Shopping System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        shopperAuth = new ShopperAuth();
        shoppingBasket = new ShoppingBasket();
        inventory = new Inventory();

        // Load items into the inventory
        inventory.addItems(ItemLoader.loadItems());

        createGUIComponents();
        setVisible(true);
    }

    private void createGUIComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Styling for buttons
        JButton registerButton = createStyledButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationDialog();
            }
        });
        buttonPanel.add(registerButton);

        JButton loginButton = createStyledButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });
        buttonPanel.add(loginButton);

        JButton browseItemsButton = createStyledButton("Browse Items");
        browseItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showItemList();
            }
        });
        buttonPanel.add(browseItemsButton);

        JButton addToBasketButton = createStyledButton("Add to Basket");
        addToBasketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddToBasketDialog();
            }
        });
        buttonPanel.add(addToBasketButton);

        JButton viewBasketButton = createStyledButton("View Basket");
        viewBasketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBasket();
            }
        });
        buttonPanel.add(viewBasketButton);

        JButton placeOrderButton = createStyledButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        buttonPanel.add(placeOrderButton);

        JButton removeFromBasketButton = createStyledButton("Remove from Basket");
        removeFromBasketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromBasketDialog();
            }
        });
        buttonPanel.add(removeFromBasketButton);

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private void showRegistrationDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField fullNameField = new JTextField();
        JTextField emailField = new JTextField();

        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField,
                "Full Name:", fullNameField,
                "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String fullName = fullNameField.getText();
            String email = emailField.getText();

            // Validate input
            if (!isValidUsername(username)) {
                JOptionPane.showMessageDialog(null, "Username must contain only lowercase letters.");
            } else if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(null, "Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
            } else if (!isValidName(fullName)) {
                JOptionPane.showMessageDialog(null, "Full Name must be in the format 'First Last' with the first letter of each word capitalized.");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email must contain the @ symbol.");
            } else {
                shopperAuth.registerShopper(username, password, fullName, email);
                ActivityLogger.log("Shopper registered: " + username);
                JOptionPane.showMessageDialog(null, "Shopper registered successfully!");
            }
        }
    }

    private void showLoginDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String loginUsername = usernameField.getText();
            String loginPassword = new String(passwordField.getPassword());

            if (currentShopper != null) {
                JOptionPane.showMessageDialog(null, "You are already logged in.");
            } else {
                currentShopper = shopperAuth.login(loginUsername, loginPassword);

                if (currentShopper != null) {
                    ActivityLogger.log("Shopper logged in: " + currentShopper.getUsername());
                    JOptionPane.showMessageDialog(null, "Login successful. Welcome, " + currentShopper.getUsername() + "!");
                } else {
                    ActivityLogger.log("Login failed for shopper: " + loginUsername);
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
                }
            }
        }
    }

    private void showItemList() {
        List<Item> itemList = inventory.getAllItems();

        if (!itemList.isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Item item : itemList) {
                String itemInfo = item.getItemName() + " - $" + item.getItemPrice() +
                        "\n Description: " + item.getItemDescription() +
                        "\n Quantity in Stock: " + item.getItemStock() + "\n";
                listModel.addElement(itemInfo);
            }

            JList<String> itemListJList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(itemListJList);
            JOptionPane.showMessageDialog(null, scrollPane, "Item List", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No items available in the inventory.", "Item List", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showAddToBasketDialog() {
        if (currentShopper != null) {
            JTextField itemNameField = new JTextField();

            Object[] message = {
                    "Enter the item name to add to the basket:", itemNameField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Add to Basket", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                String itemName = itemNameField.getText();
                Item selectedItem = findItemByName(inventory.getAllItems(), itemName);

                if (selectedItem != null) {
                    shoppingBasket.addItem(selectedItem);
                    JOptionPane.showMessageDialog(null, "Item added to the basket.");
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found in the inventory.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to add items to the basket.");
        }
    }

    private void removeFromBasketDialog() {
        if (currentShopper != null) {
            List<Item> basketItems = shoppingBasket.getItems();

            if (!basketItems.isEmpty()) {
                JTextField itemNameField = new JTextField();

                Object[] message = {
                        "Enter the item name to remove from the basket:", itemNameField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Remove from Basket", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String itemName = itemNameField.getText();
                    Item itemToRemove = findItemByName(basketItems, itemName);

                    if (itemToRemove != null) {
                        shoppingBasket.removeItem(itemToRemove);
                        JOptionPane.showMessageDialog(null, "Item removed from the basket.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Item not found in the basket.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Your shopping basket is empty.", "Remove from Basket", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to remove items from the basket.");
        }
    }

    private void showBasket() {
        List<Item> basketItems = shoppingBasket.getItems();

        if (!basketItems.isEmpty()) {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Item item : basketItems) {
                String itemInfo = item.getItemName() + " - $" + item.getItemPrice();
                listModel.addElement(itemInfo);
            }

            JList<String> basketItemList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(basketItemList);

            double totalPrice = calculateTotalPrice(shoppingBasket);
            String totalPriceMessage = "Total Price: $" + totalPrice;

            JOptionPane.showMessageDialog(null, new Object[]{scrollPane, totalPriceMessage}, "Shopping Basket", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Your shopping basket is empty.", "Shopping Basket", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void placeOrder() {
        if (currentShopper != null) {
            System.out.println("Placing an order...");
            double totalPrice = calculateTotalPrice(shoppingBasket);
            boolean paymentSuccess = new PaymentHandler().handlePayment(totalPrice, "Credit Card");

            if (paymentSuccess) {
                ActivityLogger.log("Order placed for shopper: " + currentShopper.getUsername());
                JOptionPane.showMessageDialog(null, "Order placed successfully. Payment received.");
                shoppingBasket.clear();  // Clear the basket after a successful order
            } else {
                ActivityLogger.log("Payment failed for shopper: " + currentShopper.getUsername());
                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You need to log in to place an order.");
        }
    }

    private boolean isValidUsername(String username) {
        return username.matches("^[a-z]+$");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$");
    }

    private boolean isValidName(String fullName) {
        return fullName.matches("^[A-Z][a-z]*\\s[A-Z][a-z]*$");
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private Item findItemByName(List<Item> items, String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    private double calculateTotalPrice(ShoppingBasket shoppingBasket) {
        double total = 0.0;
        for (Item item : shoppingBasket.getItems()) {
            total += item.getItemPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainAppGUI();
            }
        });
    }
}
