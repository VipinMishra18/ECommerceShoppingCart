package com.MishraG.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        ShoppingCart cart = new ShoppingCart();

        productList.add(new Product(1, "Laptop", 999.99));
        productList.add(new Product(2, "Smartphone", 499.99));
        productList.add(new Product(3, "Tablet", 299.99));

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product List:");
                    for (Product product : productList) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to add: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Product productToAdd = null;
                    for (Product product : productList) {
                        if (product.getId() == productId) {
                            productToAdd = product;
                            break;
                        }
                    }
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd, quantity);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    System.out.print("Enter product ID to remove: ");
                    int removeProductId = scanner.nextInt();
                    cart.removeProduct(removeProductId);
                    System.out.println("Removed from cart.");
                    break;
                case 5:
                    double total = cart.checkout();
                    System.out.println("Checkout complete. Total: $" + total);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
