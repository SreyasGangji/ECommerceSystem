
package ecommerce;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * InventoryTest class tests the functionality of the Inventory class.
 * Ensures that items can be added to the inventory and retrieved correctly.
 */
public class InventoryTest {
    @Test
    public void testAddItem() {
        Inventory inventory = new Inventory();
        Item laptop = new GadgetItem("Laptop", 1200.0, "High-performance laptop", 10);
        inventory.addItem(laptop);
        assertEquals(1, inventory.getAllItems().size());
        assertEquals(laptop, inventory.getItemByName("Laptop"));
    }

    @Test
    public void testAddItems() {
        Inventory inventory = new Inventory();
        List<Item> newItems = new ArrayList<>();
        Item tShirt = new ApparelItem("T-Shirt", 25.0, "Comfortable cotton T-shirt", 50);
        newItems.add(tShirt);
        inventory.addItems(newItems);
        assertEquals(1, inventory.getAllItems().size());
        assertEquals(tShirt, inventory.getItemByName("T-Shirt"));
    }

    @Test
    public void testGetItemByName() {
        Inventory inventory = new Inventory();
        Item laptop = new GadgetItem("Laptop", 1200.0, "High-performance laptop", 10);
        inventory.addItem(laptop);
        assertEquals(laptop, inventory.getItemByName("Laptop"));
        assertNull(inventory.getItemByName("NonexistentItem"));
    }
}
