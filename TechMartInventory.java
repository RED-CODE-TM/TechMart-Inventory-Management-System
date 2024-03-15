package techmartinventory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import org.apache.poi.ss.usermodel.*;

// Abstract class for Item
abstract class Item {
    protected String productName;
    protected double price;

    public Item(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public abstract void displayDetails();
}

// Product class
class Product extends Item {
    private int id;
    private int quantityInStock;

    public Product(String productName, int id, double price, int quantityInStock) {
        super(productName, price);
        this.id = id;
        this.quantityInStock = quantityInStock;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public void displayDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("ID: " + id);
        System.out.println("Price: " + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }
}

// Inventory class
class Inventory {
    private final ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to display the list of products in the inventory and their details
    public void displayProductList() {
        for (Product product : products) {
            product.displayDetails();
        }
    }
}

// Subclass of Product: ElectronicProduct
class ElectronicProduct extends Product {

    public ElectronicProduct(String productName, int id, double price, int quantityInStock, String brand) {
        super(productName, id, price, quantityInStock);
    }

    // Other specific methods for ElectronicProduct
}

// Subclass of Product: ClothingProduct
class ClothingProduct extends Product {

    public ClothingProduct(String productName, int id, double price, int quantityInStock, String size) {
        super(productName, id, price, quantityInStock);
    }

    // Other specific methods for ClothingProduct
}

// FileHandler class
class FileHandler {
    // Method to read product information from an Excel file and update the inventory
    public void readFromExcel(File file, Inventory inventory) throws IOException {
        // Read from the Excel file and update the inventory
    }

    // Method to write the current inventory information to an Excel file for record-keeping
    public void writeToExcel(File file, Inventory inventory) throws IOException {
        // Write the current inventory information to the Excel file
    }
}

// Main class
public class TechMartInventory {
    public static void main(String[] args) {
        // Create products and add them to inventory
        Product genericProduct = new Product("Fabric product", 2, 50000.0, 10);
        ElectronicProduct laptop = new ElectronicProduct("Phones", 9, 80000.0, 120, "Samsung");
        ClothingProduct tShirt = new ClothingProduct("Pants", 10, 25000.0, 50, "M");

        Inventory inventory = new Inventory();
        inventory.addProduct(genericProduct);
        inventory.addProduct(laptop);
        inventory.addProduct(tShirt);

        // Display the list of products in the inventory
        inventory.displayProductList();

        // Read from and write to Excel file
        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.readFromExcel(new File("inventory.xlsx"), inventory);
            fileHandler.writeToExcel(new File("inventory.xlsx"), inventory);
        } catch (IOException e) {
        }
    }
}
