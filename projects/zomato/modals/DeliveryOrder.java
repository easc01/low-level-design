package projects.zomato.modals;

import java.time.Instant;

import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.payment.PaymentGateway;

public class DeliveryOrder extends Order {
  private String deliveryAddress;

  public DeliveryOrder(
      User user,
      Cart cart,
      PaymentGateway paymentStrategy,
      NotificationGateway notificationStrategy,
      Instant orderTime,
      String orderType,
      String deliveryAddress
    ) {
    super(user, cart, paymentStrategy, notificationStrategy, orderTime, "DeliveryOrder");
    this.deliveryAddress = deliveryAddress;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }
}
