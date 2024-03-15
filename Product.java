package Product;

public class Product {
    private String productName;
    private int id;
    private double price;
    private int quantityInStock;

    // Constructor
    public Product(String productName, int id, double price, int quantityInStock) {
        this.productName = productName;
        this.id = id;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getter and Setter methods
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    // Method to update stock quantity
    public void updateStockQuantity(int quantity) {
        this.quantityInStock += quantity;
    }

    // Method to calculate total inventory value
    public double calculateInventoryValue() {
        return price * quantityInStock;
    }
}