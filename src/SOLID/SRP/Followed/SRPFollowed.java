package SOLID.SRP.Followed;

import java.util.*;

class Product {
    double price;
    String name;

    Product(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

//? Shopping Cart should Have only a single responsibility
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

    void saveToDB() {
        System.out.println("Saving cart data to DB of " + this.cart.calculateTotalPrice());
    }

    
}


public class SRPFollowed {
    public static void main(String[] args) {
        Product p = new Product(100, "Shirt");
        ShoppingCart cart = new ShoppingCart();

        //! ADDING PRODUCTS
        cart.addProduct(p, 5);

        //! CALCULATING TOTAL PRICE
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Cart total price " +  totalPrice);


        //! PRINTING INVOICE
        SOLID.SRP.Followed.CartInvoicePrinter cPrinter = new SOLID.SRP.Followed.CartInvoicePrinter(cart);

        cPrinter.printInvoice();

        //! SAVING DATA TO DB
        SOLID.SRP.Followed.CartDBStorage cdbs = new SOLID.SRP.Followed.CartDBStorage(cart);
        cdbs.saveToDB();
    }

}
