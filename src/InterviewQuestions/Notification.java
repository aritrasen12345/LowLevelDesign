package InterviewQuestions;

import java.util.*;

interface INotification {
    String getContent();
}

/*==========================
   Decorator Design Pattern
============================*/

abstract class INotificationDecorator implements INotification {
    INotification notification;

    INotificationDecorator(INotification _n) {
        this.notification = _n;
    }
}

class TimeStampDecorator extends INotificationDecorator {
    TimeStampDecorator(INotification _n) {
        super(_n);
    }

    @Override
    public String getContent() {
        return "[2025-04-13]" + this.notification.getContent();
    }
}

class SignatureDecorator extends INotificationDecorator {
    String signature;

    SignatureDecorator(INotification _n, String sig) {
        super(_n);
        this.signature = sig;
    }

    @Override
    public String getContent() {
        return this.notification.getContent() + " " + this.signature;
    }
}

class SimpleNotification implements INotification {
    String text;

    SimpleNotification(String _msg) {
        this.text = _msg;
    }
    
    @Override
    public String getContent() {
        return this.text;
    }
}

/*==========================
   Observer Design Pattern
============================*/

interface IObservable {
    void addObserver(IObserver ob);
    void removeObserver(IObserver ob);
    void notifyObservers();
}

interface IObserver {
    void update();
}

class NotificationObservable implements IObservable {
    List<IObserver> observers = new ArrayList<>();
    INotification currentNotification;

    @Override
    public void addObserver(IObserver ob) {
        this.observers.add(ob);
    }

    @Override
    public void removeObserver(IObserver ob) {
        this.observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : this.observers) {
            observer.update();
        }
    }

    void setNotification(INotification notification) {
        this.currentNotification = notification;
        notifyObservers();
    }

    INotification getNotification() {
        return this.currentNotification;
    }

    String getNotificationContent() {
        return this.currentNotification.getContent();
    }
}

class Logger implements IObserver {
    NotificationObservable notificationObservable;

    Logger(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void update() {
        System.out.println("Logging new Notification: \n" + this.notificationObservable.getNotificationContent());
    }
}

/*==========================
   Strategy Design Pattern
============================*/

interface INotificationStrategy {
    void sendNotification(String content);
}

class EmailStrategy implements INotificationStrategy {
    String emailId;

    EmailStrategy(String _email) {
        this.emailId = _email;
    }

    public void sendNotification(String content) {
        System.out.println("Sending email Notification to: " + this.emailId + " " + content);
    }
}

class SmsStrategy implements INotificationStrategy {
    String mobile;

    SmsStrategy(String _mobile) {
        this.mobile = _mobile;
    }

    public void sendNotification(String content) {
        System.out.println("Sending mobile Notification to: " + this.mobile + " " + content);
    }
}

class NotificationEngine implements IObserver {
    NotificationObservable notificationObservable;
    List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    NotificationEngine(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void addNotificationStrategy(INotificationStrategy ns){
        this.notificationStrategies.add(ns);
    }

    public void removeNotificationStrategy(INotificationStrategy ns){
        this.notificationStrategies.remove(ns);
    }

    public void update() {
        String notificationContent = notificationObservable.getNotificationContent();
        for(INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}

class NotificationService {
    NotificationObservable observable;
    private static NotificationService instance = null;
    List<INotification> notifications = new ArrayList<>();

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if(instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return this.observable;
    }

    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}

public class Notification {
    public static void main(String[] args) {
        // Create Notification Sevice
        NotificationService notificationService = NotificationService.getInstance();

        // Get Observable
        NotificationObservable notificationObservable = notificationService.getObservable();

        // Create Logger Observer
        Logger logger = new Logger(notificationObservable);

        // Create NotificationEngine Observers
        NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);

        notificationEngine.addNotificationStrategy(new EmailStrategy("aritra.sen@gmail.com"));
        notificationEngine.addNotificationStrategy(new SmsStrategy("+919999999999"));

        // Attach these observers
        notificationObservable.addObserver(logger);
        notificationObservable.addObserver(notificationEngine);

        // Create a notification with decorator
        INotification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimeStampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Care");

        notificationService.sendNotification(notification);
    }
}
