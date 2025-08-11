package projects.notification.decorators;

import projects.notification.modals.Notification;

public class TimestampNotificationDecorator extends NotificationDecorator {
  public TimestampNotificationDecorator(Notification notification) {
    super(notification);
  }

  @Override
  public String getContent() {
    return "[2025-11-08 18:05:33 IST]\n" + notification.getContent();
  }
}
