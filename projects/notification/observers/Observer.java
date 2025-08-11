package projects.notification.observers;

public interface Observer<T> {
  void execute(T data);
}
