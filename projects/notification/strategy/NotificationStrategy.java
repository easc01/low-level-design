package projects.notification.strategy;

import projects.notification.modals.Notification;

public interface NotificationStrategy {
  void sendNotification(Notification notification);
}
