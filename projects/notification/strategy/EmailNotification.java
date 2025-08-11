package projects.notification.strategy;

import projects.notification.modals.Notification;

public class EmailNotification implements NotificationStrategy {
  private String email;

  public EmailNotification(String email) {
    this.email = email;
  }

  @Override
  public void sendNotification(Notification notification) {
    System.out.println("Sending Email to " + email);
    System.out.println(notification.getContent() + "\n");
  }
}
