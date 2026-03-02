package Patterns.FactoryDesignPattern.FactoryMethod;

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

class BasicWheatBurger implements Burger {
    BasicWheatBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Basic wheat burger!");
    }
}

class StandardWheatBurger implements Burger{
    StandardWheatBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Standard wheat burger!");
    }
}

class PremiumWheatBurger implements Burger{
    PremiumWheatBurger() {}

    @Override
    public void prepare() {
        System.out.println("Preparing Premium wheat burger!");
    }
}


interface BurgerFactory {
    Burger createBurger(String type);
}

class SinghBurgerFactory implements BurgerFactory {
    SinghBurgerFactory() {}

    @Override
    public Burger createBurger(String type) {
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

class KingBurgerFactory implements BurgerFactory {
    KingBurgerFactory() {}

    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "basic":
                return new BasicWheatBurger();
            case "standard":
                return new StandardWheatBurger();
            case "premium":
                return new PremiumWheatBurger();
            default:
                throw new Error("Invalid wheat burger type!!");
        }
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        String type = "basic";
        BurgerFactory burgerFactory = new SinghBurgerFactory();
        Burger b = burgerFactory.createBurger(type);
        b.prepare();

        BurgerFactory kingBurgerFactory = new KingBurgerFactory();
        Burger wb = kingBurgerFactory.createBurger(type);
        wb.prepare();
    }
}
