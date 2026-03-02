package Patterns.SingletonDesignPattern;


class Singleton {
    static Singleton instance = null;

    private Singleton() {
        System.out.println("Singleton constructor called, new object created!!");
    }

    static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
    }
}
