package projects.zomato.strategy.notification;

public class SMSNotification implements NotificationGateway {
  private String mobile;

  public SMSNotification(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public void notify(String message) {
    System.out.println("SMS sent to mobile [ " + mobile + " ]-> \n--------------------------------------\n" + message);
  }
}
