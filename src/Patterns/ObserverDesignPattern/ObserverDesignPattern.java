package Patterns.ObserverDesignPattern;

interface IChannel {
    void subscribe(ISubscriber s);
    void unSubscribe(ISubscriber s);
    void notify();
}

interface ISubscriber {
    void update();
}


class Channel implements IChannel {
    
}






public class ObserverDesignPattern {
    public static void main(String[] args) {

    }
}


