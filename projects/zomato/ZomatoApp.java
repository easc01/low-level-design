package projects.zomato;

import java.time.Instant;
import java.util.List;

import projects.zomato.factory.ImmediateOrderFactory;
import projects.zomato.factory.OrderFactory;
import projects.zomato.factory.ScheduledOrderFactory;
import projects.zomato.manager.RestaurantManager;
import projects.zomato.modals.Cart;
import projects.zomato.modals.MenuItem;
import projects.zomato.modals.Order;
import projects.zomato.modals.Restaurant;
import projects.zomato.modals.User;
import projects.zomato.strategy.notification.EmailNotification;
import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.notification.SMSNotification;
import projects.zomato.strategy.payment.PaymentGateway;

public class ZomatoApp {
  private RestaurantManager restaurantManager;

  public ZomatoApp() {
    this.restaurantManager = RestaurantManager.getInstance();
    Restaurant bikaner = new Restaurant("Bikaner", "bikaner", "123, Bikaner Road");
    bikaner.addMenuItem(new MenuItem("A1", "Rasgulla", 45.0));
    bikaner.addMenuItem(new MenuItem("A2", "Chole Bhature", 180.0));
    bikaner.addMenuItem(new MenuItem("A3", "Ladoo", 40.0));

    Restaurant haldiram = new Restaurant("Haldiram", "bikaner", "241, haldiram Road");
    haldiram.addMenuItem(new MenuItem("C1", "Parathe", 45.0));
    haldiram.addMenuItem(new MenuItem("C2", "Chole Kulche", 70.0));
    haldiram.addMenuItem(new MenuItem("C3", "Pav Bhaji", 60.0));

    restaurantManager.addRestaurant(bikaner);
    restaurantManager.addRestaurant(haldiram);
  }

  public User createAccount(String name, String location, String address, String number, String email) {
    return new User(name, location, address, number, email);
  }

  public List<Restaurant> searchByLocation(String location) {
    return restaurantManager.getRestaurantsByLocation(location);
  }

  public Cart openRestaurantCart(Restaurant restaurant) {
    return new Cart(restaurant);
  }

  public void addItemToCart(Cart cart, MenuItem item) {
    cart.addItem(item);
  }

  public void removeItemFromCart(Cart cart, MenuItem item) {
    cart.removeItem(item);
  }

  public Order checkoutNow(User user, Cart cart, String orderType, PaymentGateway paymentGateway) {
    return checkout(user, cart, orderType, paymentGateway, new ImmediateOrderFactory());
  }

  public Order checkoutLater(User user, Cart cart, String orderType, Instant time, PaymentGateway paymentGateway) {
    return checkout(user, cart, orderType, paymentGateway, new ScheduledOrderFactory(time));
  }

  private Order checkout(User user, Cart cart, String orderType, PaymentGateway paymentGateway,
      OrderFactory orderFactory) {
    if (cart.isEmpty()) {
      return null;
    }

    NotificationGateway notificationGateway = user.getMobile() != null ? new SMSNotification(user.getMobile())
        : new EmailNotification(user.getEmail());

    return orderFactory.createOrder(user, cart, orderType, paymentGateway, notificationGateway);
  }

  public void payForOrder(Order order, Cart cart) {
    order.placeOrder();
    cart.clear();
  }

  public void showRestaurantCart(Cart cart) {
    System.out.println("Items in cart:");
    System.out.println("------------------------------------");

    for (MenuItem item : cart.getItems()) {
      System.out.println(item.getCode() + " : " + item.getName() + " : Rs." + item.getPrice());
    }

    System.out.println("------------------------------------");
    System.out.println("Grand total : Rs." + cart.getTotalPrice());

    System.out.println("\n");
  }
}
