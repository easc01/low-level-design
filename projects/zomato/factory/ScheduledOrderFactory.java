package projects.zomato.factory;

import java.time.Instant;

import projects.zomato.modals.Cart;
import projects.zomato.modals.DeliveryOrder;
import projects.zomato.modals.Order;
import projects.zomato.modals.PickupOrder;
import projects.zomato.modals.User;
import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.payment.PaymentGateway;

public class ScheduledOrderFactory implements OrderFactory {
  private Instant scheduledTime;

  public ScheduledOrderFactory(Instant scheduledTime) {
    this.scheduledTime = scheduledTime;
  }

  @Override
  public Order createOrder(
    User user, 
    Cart cart, 
    String orderType, 
    PaymentGateway paymentStrategy,
    NotificationGateway notificationStrategy
  ) {
    Order order = null;

    if (orderType.equals("DeliveryOrder")) {
      String address = user.getAddress();
      order = new DeliveryOrder(
        user, 
        cart, 
        paymentStrategy, 
        notificationStrategy, 
        scheduledTime, 
        orderType, 
        address
      );
    } else {
      String address = cart.getRestaurant().getAddress();
      order = new PickupOrder(
        user,
        cart, 
        paymentStrategy, 
        notificationStrategy, 
        scheduledTime, 
        orderType, 
        address
      );
    }

    return order;
  }


  
}
