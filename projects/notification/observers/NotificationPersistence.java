package projects.notification.observers;

import projects.notification.modals.Notification;

public class NotificationPersistence implements Observer<Notification> {
  @Override
  public void execute(Notification data) {
    System.out.println("Notification saved -> \n" + data.getContent() + "\n");
  }
}
