package Patterns.ObserverDesignPattern;

import java.util.*;

interface IChannel {
   void subscribe(ISubscriber s);
   void unsubscribe(ISubscriber s);
   void notifySubscribers();
}

class Channel implements IChannel {
   private List<ISubscriber> subscribers;
   private String latestVideo;

   Channel() {
      this.subscribers = new ArrayList<>();
   }

   @Override()
   public void subscribe(ISubscriber s) {
      this.subscribers.add(s);
   }

   @Override()
   public void unsubscribe(ISubscriber s) {
      this.subscribers.remove(s);
   }

   @Override()
   public void notifySubscribers() {
      for (ISubscriber subscriber : subscribers) {
         subscriber.update(latestVideo);
      }
   }

   public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println("\nChannel uploaded new video: " + title);
        notifySubscribers();
   }
}

interface ISubscriber {
   void update(String videoTitle);
}

class Subscriber implements ISubscriber{
   private String name;

   Subscriber(String _name) {
      this.name = _name;
   }

   @Override()
   public void update(String videoTitle) {
      System.out.println(this.name + " received notification: New Video uploaded:  " + videoTitle);
   }
}
public class ObserverDesignPattern {
   public static void main(String[] args) {
       Channel channel = new Channel();

        ISubscriber s1 = new Subscriber("Aritra");
        ISubscriber s2 = new Subscriber("Souresh");
        ISubscriber s3 = new Subscriber("Rounak");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);

        channel.uploadVideo("Observer Design Pattern Explained");

        channel.unsubscribe(s2);

        channel.uploadVideo("Low Level Design Interview Preparation");
   }
}


