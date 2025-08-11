package projects.notification.observers;

import java.util.ArrayList;
import java.util.List;

import projects.notification.modals.Notification;
import projects.notification.strategy.NotificationStrategy;

public class NotificationEngine implements Observer<Notification> {
  private List<NotificationStrategy> notificationStrategy;

  public NotificationEngine(NotificationStrategy notificationStrategy) {
    this.notificationStrategy = new ArrayList<>(List.of(notificationStrategy));
  }

  public NotificationEngine(List<NotificationStrategy> notificationStrategy) {
    this.notificationStrategy = notificationStrategy;
  }

  @Override
  public void execute(Notification data) {
    notificationStrategy.forEach(strategy -> strategy.sendNotification(data));
  }
}
