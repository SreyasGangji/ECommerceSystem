package ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class manages a collection of items.
 * Implements the Single Responsibility Principle by focusing solely on inventory management.
 */
public class Inventory {
    private List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the inventory.
     * 
     * @param item The item to be added to the inventory.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Retrieves an item by its name from the inventory.
     * 
     * @param name The name of the item to retrieve.
     * @return The item if found, or null if no item with the given name exists.
     */
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Retrieves all items from the inventory.
     * 
     * @return A list of all items in the inventory.
     */
    public List<Item> getAllItems() {
        return items;
    }

    /**
     * Adds a list of items to the inventory.
     * 
     * @param newItems The list of items to be added to the inventory.
     */
    public void addItems(List<Item> newItems) {
        items.addAll(newItems);
    }
}
