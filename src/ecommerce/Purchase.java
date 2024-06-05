package ecommerce;

/**
 * Purchase class represents an order placed by a shopper.
 * Encapsulates order details and follows the Single Responsibility Principle.
 */
public class Purchase {
    private Shopper shopper;
    private ShoppingBasket basket;
    private String orderStatus;

    /**
     * Constructs a Purchase with the specified shopper and shopping basket.
     * 
     * @param shopper The shopper placing the order.
     * @param basket The shopping basket containing the items.
     */
    public Purchase(Shopper shopper, ShoppingBasket basket) {
        this.shopper = shopper;
        this.basket = basket;
        this.orderStatus = "Pending";
    }

    /**
     * Places the order by printing order details and updating the order status.
     */
    public void placeOrder() {
        if (orderStatus.equals("Pending")) {
            System.out.println("Placing the order for Shopper: " + shopper.getUsername());
            System.out.println("Order Details:");
            for (Item item : basket.getItems()) {
                System.out.println(item.getItemName() + " - $" + item.getItemPrice());
            }
            System.out.println("Total Amount: $" + basket.getTotalAmount());
            this.orderStatus = "Placed";
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order has already been placed.");
        }
    }

    public Shopper getShopper() {
        return shopper;
    }

    public ShoppingBasket getBasket() {
        return basket;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
