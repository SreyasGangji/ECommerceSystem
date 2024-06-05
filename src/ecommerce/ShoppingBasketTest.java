package ecommerce;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

/**
 * ShoppingBasketTest class tests the functionality of the ShoppingBasket class.
 * Ensures that items can be added to and removed from the basket and the total amount is calculated correctly.
 */
public class ShoppingBasketTest {
    @Test
    public void testGetTotalAmount() {
        List<Item> items = ItemLoader.loadItems();
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(items.get(0)); // E-Reader
        basket.addItem(items.get(1)); // Wireless Charger
        basket.addItem(items.get(5)); // Running Shoes
        basket.addItem(items.get(8)); // Sunglasses

        double expectedTotalAmount = items.get(0).getItemPrice() + items.get(1).getItemPrice()
                + items.get(5).getItemPrice() + items.get(8).getItemPrice();

        assertEquals(expectedTotalAmount, basket.getTotalAmount(), 0.01);
    }

    @Test
    public void testAddItem() {
        List<Item> items = ItemLoader.loadItems();
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(items.get(2)); // Bluetooth Speaker
        assertEquals(1, basket.getItems().size());
        assertEquals(items.get(2), basket.getItems().get(0));
    }

    @Test
    public void testRemoveItem() {
        List<Item> items = ItemLoader.loadItems();
        ShoppingBasket basket = new ShoppingBasket();
        Item item = items.get(3); // Smart Thermostat
        basket.addItem(item);
        basket.removeItem(item);
        assertEquals(0, basket.getItems().size());
    }
}
