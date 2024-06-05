package ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingBasket class manages a collection of items in the shopper's basket.
 * Implements the Single Responsibility Principle by focusing solely on basket management.
 */
public class ShoppingBasket {
    private List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the basket.
     * 
     * @param item The item to be added to the basket.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the basket.
     * 
     * @param item The item to be removed from the basket.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Retrieves all items from the basket.
     * 
     * @return A list of all items in the basket.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Calculates the total amount of the items in the basket.
     * 
     * @return The total amount of the items in the basket.
     */
    public double getTotalAmount() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getItemPrice();
        }
        return total;
    }

    /**
     * Clears all items from the basket.
     * 
     * Used after a successful order placement.
     */
    public void clear() {
        items.clear();
    }
}
