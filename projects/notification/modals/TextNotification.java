package projects.notification.modals;

public class TextNotification implements Notification {
  private String textContent;

  public TextNotification(String content) {
    this.textContent = content;
  }

  @Override
  public String getContent() {
    return textContent;
  }
}
