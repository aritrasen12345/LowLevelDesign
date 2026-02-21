package SOLID.SRP.Violated;

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

    //! PRINT INVOICE
    void printInvoice() {
        System.out.println("PRINTING INVOICE");
    }

    //! SAVE TO DB
    void saveToDB() {
        System.out.println("PERSISTANCE DATA INTO DATABASE");
    }
}

class SRPViolated {
    public static void main(String[] args) {
        Product p = new Product(100, "Shirt");
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p, 5);

        double totalPrice = cart.calculateTotalPrice();

        System.out.println("Cart total price " +  totalPrice);

        cart.printInvoice();
        cart.saveToDB();
    }
}
