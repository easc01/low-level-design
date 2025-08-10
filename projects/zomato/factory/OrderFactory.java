package projects.zomato.factory;

import projects.zomato.modals.Cart;
import projects.zomato.modals.Order;
import projects.zomato.modals.User;
import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.payment.PaymentGateway;

public interface OrderFactory {
  Order createOrder(
    User user, 
    Cart cart, 
    String orderType,
    PaymentGateway paymentStrategy, 
    NotificationGateway notificationStrategy
  );
}
