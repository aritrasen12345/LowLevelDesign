package SOLID.OCP.Followed;

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


interface DBPersistence {
    void save(ShoppingCart cart);
}

class SaveToFile implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving cart data to file of " + cart.calculateTotalPrice());
    }
}

class SaveToMongoDB implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving cart data to MongoDB of " + cart.calculateTotalPrice());
    }
}

class SaveToSQLDB implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving cart data to SQL DB of " + cart.calculateTotalPrice());
    }
}

public class OCPFollowed {
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
        SaveToFile saveToFileDBPersistence = new SaveToFile();
        saveToFileDBPersistence.save(cart);

        //! SAVING DATA TO MONGODB
        SaveToMongoDB saveToMongoDBPersistence = new SaveToMongoDB();
        saveToMongoDBPersistence.save(cart);

         //! SAVING DATA TO SQL DB
        SaveToSQLDB saveToSQLDBPersistence = new SaveToSQLDB();
        saveToSQLDBPersistence.save(cart);
    }

}
