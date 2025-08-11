package projects.notification.strategy;

import projects.notification.modals.Notification;

public class SMSNotification implements NotificationStrategy {
  private String mobileNumber;

  public SMSNotification(String mobile) {
    this.mobileNumber = mobile;
  }

  @Override
  public void sendNotification(Notification notification) {
    System.out.println("Sending SMS to " + mobileNumber);
    System.out.println(notification.getContent() + "\n");
  }
}
