package Patterns.FactoryDesignPattern.SimpleFactory;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    BasicBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Basic burger!");
    }
}

class StandardBurger implements Burger{
    StandardBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Standard burger!");
    }
}

class PremiumBurger implements Burger{
    PremiumBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Premium burger!");
    }
}


class BurgerFactory {
    BurgerFactory() {}

    Burger createBurger(String type) {
        switch (type) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            default:
                throw new Error("Invalid burger type!!");
        }
    }
}


public class SimpleFactory {
    public static void main(String[] args) {
        String type = "basic";
        BurgerFactory burgerFactory = new BurgerFactory();
        Burger b = burgerFactory.createBurger(type);
        b.prepare();
    }
}
