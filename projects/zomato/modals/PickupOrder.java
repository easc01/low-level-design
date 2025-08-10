package projects.zomato.modals;

import java.time.Instant;

import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.payment.PaymentGateway;

public class PickupOrder extends Order {
  private String restaurantAddress;

  public PickupOrder(
      User user,
      Cart cart,
      PaymentGateway paymentStrategy,
      NotificationGateway notificationStrategy,
      Instant orderTime,
      String orderType,
      String restaurantAddress
    ) {
    super(user, cart, paymentStrategy, notificationStrategy, orderTime, "PickupOrder");
    this.restaurantAddress = restaurantAddress;
  }

  public String getRestaurantAddress() {
    return restaurantAddress;
  }
}
