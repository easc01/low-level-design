package projects.notification.modals;

public class HTMLNotification implements Notification {
  private String htmlContent;

  public HTMLNotification(String content) {
    this.htmlContent = content;
  }

  @Override
  public String getContent() {
    return htmlContent;
  }
}
