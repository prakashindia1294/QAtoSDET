package OOP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Class is to understand the Class and Object
 */
public class StockMaintenance {

    private static class Product{ //Concrete Class as individal
        private String productID;
        private String productName;
        private String brand;
        private String category;
        private int quantityInStock;
        private BigDecimal purchasePrice;
        private BigDecimal sellingPrice;
        private String vendor;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Product(String productID,
                       String productName,
                       String brand,
                       String category,
                       int quantityInStock,
                       BigDecimal purchasePrice,
                       BigDecimal sellingPrice,
                       String vendor){
            this.productID = productID;
            this.productName = productName;
            this.brand = brand;
            this.category = category;
            this.quantityInStock = quantityInStock;
            this.purchasePrice = purchasePrice;
            this.sellingPrice = sellingPrice;
            this.vendor = vendor;
        }

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getQuantityInStock() {
            return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        public BigDecimal getPurchasePrice() {
            return purchasePrice;
        }

        public void setPurchasePrice(BigDecimal purchasePrice) {
            this.purchasePrice = purchasePrice;
        }

        public BigDecimal getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(BigDecimal sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        @Override
        public String toString(){
            return "Item{" +
                    "productID='" + productID + "', " +
                    "productName='" + productName + "', " +
                    "brand='" + brand + "', " +
                    "category='" + category + "', " +
                    "quantityInStock=" + quantityInStock + ", " +
                    "purchasePrice=" + purchasePrice + ", " +
                    "sellingPrice=" + sellingPrice + ", " +
                    "vendor='" + vendor + "'" +
                    "}";
        }

    }

    private static class StockManager<T>{ //Staic nested class
        private List<T> products;

        public List<T> getProducts() {
            return products;
        }

        public StockManager() {
            products = new ArrayList<>();
        }

        public void addProducts(T product){
            try{
                products.add(product);
                System.out.println("Product added successfully: " + product);
            } catch (Exception e){
                System.out.println("Error adding item: " + e.getMessage());
            }
        }

        public void removeProduct(T product) {
            try {
                if (!products.contains(product)) {
                    throw new IllegalArgumentException("product not found in inventory.");
                }
                products.remove(product);
                System.out.println("product removed successfully: " + product);
            } catch (Exception e) {
                System.out.println("Error removing product: " + e.getMessage());
            }
        }

        public void viewProducts(){
            if(products.isEmpty()){
                System.out.println("Inventory is empty");
            } else {
                System.out.println("Inventory items:");
                for (T product : products){
                    System.out.println(product);
                }
            }
        }
    }

    public static void main(String[] args) {
        StockManager<Product> stockManager = new StockManager<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("\nInventory System");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. View product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add an product
                    System.out.print("Enter productID: ");
                    String productID = scanner.nextLine();
                    System.out.print("Enter productName: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter product quantityInStock: ");
                    int quantityInStock = scanner.nextInt();
                    System.out.print("Enter product purchasePrice: ");
                    BigDecimal purchasePrice = scanner.nextBigDecimal();
                    System.out.print("Enter product sellingPrice: ");
                    BigDecimal sellingPrice = scanner.nextBigDecimal();
                    System.out.print("Enter product vendor: ");
                    String vendor = scanner.next();

                    Product newProduct = new Product(productID, productName, brand, category, quantityInStock, purchasePrice,
                            sellingPrice, vendor);
                    stockManager.addProducts(newProduct);
                    break;

                case 2:
                    // Remove an product
                    System.out.print("Enter product name to remove: ");
                    String productNameToRemove = scanner.nextLine();
                    Product productToRemove = null;

                    // Search for the item using the getter method for items
                    for (Product product : stockManager.getProducts()) {
                        if (product.getProductName().equalsIgnoreCase(productNameToRemove)) {
                            productToRemove = product;
                            break;
                        }
                    }

                    if (productToRemove != null) {
                        stockManager.removeProduct(productToRemove);
                    } else {
                        System.out.println("Item not found in inventory.");
                    }
                    break;

                case 3:
                    // View items
                    stockManager.viewProducts();
                    break;

                case 4:
                    // Exit
                    exit = true;
                    System.out.println("Exiting Inventory System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

}
