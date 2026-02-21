package SOLID.OCP.Violated;

import java.util.*;

class Product {
    double price;
    String name;

    Product(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

class ShoppingCart {
    HashMap<Product, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    //! ADDING PRODUCT
    void addProduct(Product p, int quantity) {
        this.cart.put(p, this.cart.getOrDefault(p, 0) + quantity);
    }

    //! CALCULATING TOTAL PRICE
     double calculateTotalPrice() {
        double totalPrice = 0;

        for(Map.Entry<Product, Integer> entry : this.cart.entrySet()) {
            Product selectedProduct = entry.getKey();
            double selectedProductCount = entry.getValue();

            totalPrice += selectedProduct.price * selectedProductCount;
        }
        return totalPrice;
    }
}

class CartInvoicePrinter {
    ShoppingCart cart;

    CartInvoicePrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    void printInvoice(){
        System.out.println("Printing invoice amount" + this.cart.calculateTotalPrice());
    }
}

class CartDBStorage {
    ShoppingCart cart;

    public CartDBStorage(ShoppingCart cart) {
        this.cart = cart; 
    }

    void saveToFile() {
        System.out.println("Saving cart data to file of " + this.cart.calculateTotalPrice());
    }

    //! HERE WE Broke Single Responsibility Principle
    void saveToMongoDB() {
        System.out.println("Saving cart data to MongoDB of " + this.cart.calculateTotalPrice());
    }   
}

public class OCPViolated {
    public static void main(String[] args) {
        Product p = new Product(100, "Shirt");
        ShoppingCart cart = new ShoppingCart();

        //! ADDING PRODUCTS
        cart.addProduct(p, 5);

        //! CALCULATING TOTAL PRICE
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Cart total price " +  totalPrice);


        //! PRINTING INVOICE
        CartInvoicePrinter cPrinter = new CartInvoicePrinter(cart);

        cPrinter.printInvoice();

        //! SAVING DATA TO FILE
        CartDBStorage cdbs = new CartDBStorage(cart);
        cdbs.saveToFile();

        //! SAVING DATA TO MONGODB
        cdbs.saveToMongoDB();
    }

}
