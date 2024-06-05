package ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemLoader class loads sample items into the inventory.
 * Demonstrates the Factory Design Pattern for creating different types of items.
 */
public class ItemLoader {
    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        items.add(new GadgetItem("E-Reader", 99.99, "Portable e-reader with high-resolution display", 15));
        items.add(new GadgetItem("Wireless Charger", 19.99, "Fast wireless charger for smartphones", 30));
        items.add(new GadgetItem("Bluetooth Speaker", 49.99, "Portable Bluetooth speaker with rich sound", 25));
        items.add(new GadgetItem("Smart Thermostat", 129.99, "Smart thermostat with remote control", 10));
        items.add(new GadgetItem("Action Camera", 199.99, "Compact action camera with 4K recording", 12));
        items.add(new ApparelItem("Running Shoes", 59.99, "Lightweight running shoes with breathable mesh", 40));
        items.add(new ApparelItem("Backpack", 39.99, "Durable backpack with multiple compartments", 35));
        items.add(new ApparelItem("Winter Jacket", 99.99, "Insulated winter jacket for extreme cold", 20));
        items.add(new ApparelItem("Sunglasses", 24.99, "UV protection sunglasses with polarized lenses", 50));
        items.add(new ApparelItem("Leather Belt", 29.99, "Genuine leather belt with metal buckle", 30));
        items.add(new GadgetItem("Laptop", 1299.99, "High-performance laptop with 16GB RAM", 10));
        items.add(new GadgetItem("Smartphone", 899.99, "Latest model smartphone with 5G", 20));
        items.add(new GadgetItem("Tablet", 499.99, "10-inch tablet with high-resolution display", 15));
        items.add(new GadgetItem("Smartwatch", 199.99, "Fitness and health tracker smartwatch", 25));
        items.add(new GadgetItem("Headphones", 149.99, "Noise-cancelling wireless headphones", 30));
        items.add(new ApparelItem("T-Shirt", 19.99, "Comfortable cotton T-shirt", 50));
        items.add(new ApparelItem("Jeans", 39.99, "Slim-fit blue jeans", 30));
        items.add(new ApparelItem("Sneakers", 79.99, "Comfortable running sneakers", 25));
        items.add(new ApparelItem("Dress", 59.99, "Elegant evening dress", 15));
        items.add(new ApparelItem("Hoodie", 49.99, "Warm and cozy hoodie", 40));
        items.add(new GadgetItem("VR Headset", 399.99, "Immersive virtual reality headset", 5));
        items.add(new GadgetItem("Gaming Console", 499.99, "Next-gen gaming console", 8));
        items.add(new GadgetItem("Drone", 299.99, "High-performance drone with camera", 12));
        items.add(new GadgetItem("Smart Light Bulb", 29.99, "Smart light bulb with remote control", 50));
        items.add(new ApparelItem("Cap", 14.99, "Stylish baseball cap", 50));
        items.add(new ApparelItem("Gloves", 24.99, "Warm winter gloves", 30));
        return items;
    }
}
