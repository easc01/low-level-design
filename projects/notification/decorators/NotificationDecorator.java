package projects.notification.decorators;

import projects.notification.modals.Notification;

public abstract class NotificationDecorator implements Notification {
  protected Notification notification;
  
  NotificationDecorator(Notification notification) {
    this.notification = notification;
  }
}
