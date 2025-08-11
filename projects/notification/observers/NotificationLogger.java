package projects.notification.observers;

import projects.notification.modals.Notification;

public class NotificationLogger implements Observer<Notification> {
  @Override
  public void execute(Notification data) {
    System.out.println("Notification logged -> \n" + data.getContent() + "\n");
  }
}
