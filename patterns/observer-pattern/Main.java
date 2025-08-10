import java.util.ArrayList;
import java.util.List;

interface Observable<T> {
  void addObserver(Observer<T> observer);

  void removeObserver(Observer<T> observer);

  void notifyObservers(T data);
}

interface Observer<T> {
  void execute(T data);
}

class ObservableManager<T> implements Observable<T> {
  private List<Observer<T>> observers;

  public ObservableManager() {
    this.observers = new ArrayList<>();
  }

  public ObservableManager(List<Observer<T>> observers) {
    this.observers = new ArrayList<>(observers);
  }

  @Override
  public synchronized void addObserver(Observer<T> observer) {
    this.observers.add(observer);
  }

  @Override
  public synchronized void removeObserver(Observer<T> observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers(T data) {
    List<Observer<T>> snapshot;
    synchronized (this) {
      snapshot = new ArrayList<>(observers);
    }
    snapshot.forEach(o -> o.execute(data));
  }
}

class ConcreteObservable<T> implements Observable<T> {
  private ObservableManager<T> manager;
  private T state;

  public ConcreteObservable(T state) {
    this.state = state;
    this.manager = new ObservableManager<>();
  }

  public void setState(T state) {
    this.state = state;
    notifyObservers(getState());
  }

  public T getState() {
    return this.state;
  }

  @Override
  public void addObserver(Observer<T> observer) {
    this.manager.addObserver(observer);
  }

  @Override
  public void removeObserver(Observer<T> observer) {
    this.manager.removeObserver(observer);
  }

  @Override
  public void notifyObservers(T data) {
    this.manager.notifyObservers(data);
  }
}

class ConcreteObserver<T> implements Observer<T> {
  @Override
  public void execute(T data) {
    System.out.println("Data received by [" + this + "] -> [" + data + "]");
  }
}

public class Main {
  public static void main(String[] args) {
    ConcreteObservable<String> news = new ConcreteObservable<>("No news at the moment");
    ConcreteObservable<String> radio = new ConcreteObservable<>("No news at the moment");
    
    Observer<String> aman = new ConcreteObserver<>();
    Observer<String> rohit = new ConcreteObserver<>();
    Observer<String> anshul = new ConcreteObserver<>();

    news.addObserver(aman);
    news.addObserver(rohit);
    news.addObserver(anshul);

    radio.addObserver(anshul);
    radio.addObserver(aman);

    news.setState("Tsunami incoming, beware and stay safe - 4 PM");
    radio.setState("Cricket over 13, 6 balls remaining, 14 runs to go");
  }
}
