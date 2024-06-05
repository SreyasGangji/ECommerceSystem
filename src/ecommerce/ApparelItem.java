package ecommerce;

/**
 * ApparelItem class represents a specific type of item - apparel.
 * Follows the Liskov Substitution Principle as it can be used interchangeably with other Item types.
 */
public class ApparelItem implements Item {
    private String name;
    private double price;
    private String description;
    private int stock;

    /**
     * Constructs an ApparelItem with the specified details.
     * 
     * @param name The name of the apparel item.
     * @param price The price of the apparel item.
     * @param description A brief description of the apparel item.
     * @param stock The quantity in stock of the apparel item.
     */
    public ApparelItem(String name, double price, String description, int stock) {
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
        return "ApparelItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
