package com.adaptnxt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProductDetailsToCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of products
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        
        // Create an array to store the product details
        Product[] products = new Product[numProducts];
        
        // Read the product details
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details for product " + (i+1));
            System.out.print("productName: ");
            String name = scanner.next();
            System.out.print("productPrice: ");
            double price = scanner.nextDouble();
            System.out.print("itemnumber: ");
            int itemnumber = scanner.nextInt();
            System.out.print("modelNumber: ");
            String modelnumber = scanner.next();
            System.out.print("productCategory: ");
            String category = scanner.next();
            System.out.print("productDescription: ");
            String description = scanner.next();
            products[i] = new Product(name, price, itemnumber,modelnumber,category,description);
        }
        
        // Export the product details to a CSV file
        try {
            FileWriter writer = new FileWriter("products.csv");
            writer.write("Name,Price,Itemnumber,Modelnumber,Category,Description\n"); // Write the header row
            
            for (Product product : products) {
                writer.write(product.getName() + ",");
                writer.write(product.getPrice() + ",");
                writer.write(product.getItemnumber() + ",");
                writer.write(product.getModelnumber() + ",");
                writer.write(product.getCategory() + ",");
                writer.write(product.getDescription() + "\n");
            }
            
            writer.close();
            System.out.println("Product details exported to products.csv");
        } catch (IOException e) {
            System.out.println("Error exporting product details: " + e.getMessage());
        }
    }
}

class Product {
    private String name;
    private double price;
    private int itemnumber;
    private String modelnumber;
    private String category;
    private String description;
    
    public Product(String name, double price, int itemnumber,String modelnumber,String category,String description) {
        this.name = name;
        this.price = price;
        this.itemnumber=itemnumber;
        this.modelnumber=modelnumber;
        this.category=category;
        this.description=description;

    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
   public int getItemnumber() {
        return itemnumber;
    }
   public String getModelnumber() {
        return modelnumber;
    }
   public String getCategory() {
        return category;
    }
    
    public String getDescription() {
        return description;
    }
}

