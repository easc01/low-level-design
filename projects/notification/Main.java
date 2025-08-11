package projects.notification;

import java.util.List;

import projects.notification.decorators.SignatureNotificationDecorator;
import projects.notification.decorators.TimestampNotificationDecorator;
import projects.notification.modals.Notification;
import projects.notification.modals.TextNotification;
import projects.notification.observers.NotificationEngine;
import projects.notification.observers.NotificationLogger;
import projects.notification.observers.NotificationPersistence;
import projects.notification.strategy.EmailNotification;
import projects.notification.strategy.SMSNotification;

public class Main {
  public static void main(String[] args) {
    NotificationService notificationService = NotificationService.getInstance();

    NotificationLogger logger = new NotificationLogger();
    NotificationPersistence nPersistence = new NotificationPersistence();
    
    notificationService.registerObservers(List.of(logger, nPersistence));

    Notification eBillNotification = new TextNotification("Hi, kindly pay your electricity bills");
    eBillNotification = new TimestampNotificationDecorator(eBillNotification);
    eBillNotification = new SignatureNotificationDecorator(eBillNotification, "DelhiElectricityBoard");
  
    notificationService.sendNotification(
      eBillNotification, 
      new NotificationEngine(
        List.of(
          new SMSNotification("9876543210"),
          new EmailNotification("ishant@gmail.com")
        )
      )
    );
  }
}
