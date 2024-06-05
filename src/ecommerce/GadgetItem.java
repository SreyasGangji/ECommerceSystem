package ecommerce;

/**
 * GadgetItem class represents a specific type of item - gadget.
 * Follows the Liskov Substitution Principle as it can be used interchangeably with other Item types.
 */
public class GadgetItem implements Item {
    private String name;
    private double price;
    private String description;
    private int stock;

    /**
     * Constructs a GadgetItem with the specified details.
     * 
     * @param name The name of the gadget item.
     * @param price The price of the gadget item.
     * @param description A brief description of the gadget item.
     * @param stock The quantity in stock of the gadget item.
     */
    public GadgetItem(String name, double price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public double getItemPrice() {
        return price;
    }

    @Override
    public String getItemDescription() {
        return description;
    }

    @Override
    public int getItemStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "GadgetItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
