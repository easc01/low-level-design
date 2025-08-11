package projects.notification;

import java.util.List;

import projects.notification.modals.Notification;
import projects.notification.observers.NotificationEngine;
import projects.notification.observers.NotificationObservable;
import projects.notification.observers.Observer;

public class NotificationService {
  private static volatile NotificationService instance;
  private NotificationObservable notificationObservable;

  private NotificationService() {
    this.notificationObservable = new NotificationObservable();
  }

  public static NotificationService getInstance() {
    if (instance == null) {
      synchronized (NotificationService.class) {
        if (instance == null) {
          instance = new NotificationService();
        }
      }
    }

    return instance;
  }

  public void sendNotification(Notification notification) {
    notificationObservable.notifyObservers(notification);
  }

  public void sendNotification(Notification notification, NotificationEngine nEngine) {
    notificationObservable.notifyObservers(notification);
    nEngine.execute(notification);
  }

  public void registerObservers(List<Observer<Notification>> observers) {
    observers.forEach(o -> notificationObservable.addObserver(o));
  }
}
