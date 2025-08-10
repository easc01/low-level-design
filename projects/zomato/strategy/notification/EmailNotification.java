package projects.zomato.strategy.notification;

public class EmailNotification implements NotificationGateway {
  private String email;

  public EmailNotification(String email) {
    this.email = email;
  }

  @Override
  public void notify(String message) {
    System.out.println("Email sent to [ " + email + " ]-> \n--------------------------------------\n" + message);
  }
}
