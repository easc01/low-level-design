package projects.notification.decorators;

import projects.notification.modals.Notification;

public class SignatureNotificationDecorator extends NotificationDecorator {
  private String signature;

  public SignatureNotificationDecorator(Notification notification, String signature) {
    super(notification);
    this.signature = signature;
  }

  @Override
  public String getContent() {
    return notification.getContent() + "\n\n" + signature;
  }
}
