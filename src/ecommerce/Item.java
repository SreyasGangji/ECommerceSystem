package ecommerce;

/**
 * Item interface representing the general structure of an item.
 * Follows the Interface Segregation Principle by providing specific methods for item details.
 */
public interface Item {
    String getItemName();
    double getItemPrice();
    String getItemDescription();
    int getItemStock();
}
