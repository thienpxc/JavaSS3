package bt8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>(); // Initialize products as an empty ArrayList
    private File file;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager("products.txt");
        System.out.println("Enter the number of products you want to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Product product = productManager.inputData(scanner);
            productManager.addProduct(product);
        }
        productManager.displayProducts();
        System.out.println("Enter the ID of the product you want to search: ");
        int id = scanner.nextInt();
        Product product = productManager.searchProduct(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found");
        }
    }

    public ProductManager(String filePath) {
        file = new File(filePath);
        if (file.exists()) {
            readFromFile();
        }
    }
    public Product inputData(Scanner scanner) {
        System.out.println("Enter the ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter the manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter the price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter other description: ");
        String otherDescription = scanner.nextLine();
        return new Product(id, productName, manufacturer, price, otherDescription);
    }

    public void addProduct(Product product) {
        products.add(product);
        writeToFile();
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product searchProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private void readFromFile() {
       if(file.length() == 0){
           System.out.println("File is empty");
              return;
       }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}