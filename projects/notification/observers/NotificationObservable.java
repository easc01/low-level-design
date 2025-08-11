package projects.notification.observers;

import java.util.ArrayList;
import java.util.List;

import projects.notification.modals.Notification;

public class NotificationObservable implements Observable<Notification> {
  private List<Observer<Notification>> observers;

  public NotificationObservable() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void addObserver(Observer<Notification> observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer<Notification> observer) {
    observers.remove(observer);

  }

  @Override
  public void notifyObservers(Notification data) {
    observers.forEach(o -> o.execute(data));
  }

}
