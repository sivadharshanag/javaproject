public class Medicine {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String expiryDate;

    // Constructor
    public Medicine(int id, String name, int quantity, double price, String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display medicine details
    @Override
    public String toString() {
        return "Medicine ID: " + id +
               ", Name: " + name +
               ", Quantity: " + quantity +
               ", Price: $" + price +
               ", Expiry Date: " + expiryDate;
    }
}
