package projects.zomato.modals;

import java.time.Instant;

import projects.zomato.strategy.notification.NotificationGateway;
import projects.zomato.strategy.payment.PaymentGateway;

public abstract class Order {
  private static Integer nextId = 0;
  private Integer id;
  private User user;
  private Cart cart;
  private PaymentGateway payment;
  private NotificationGateway notification;
  private Instant orderTime;
  private String orderType;

  public Order(
    User user,
    Cart cart,
    PaymentGateway paymentStrategy,
    NotificationGateway notificationStrategy,
    Instant orderTime,
    String orderType
  ) {
    id = ++nextId;
    this.cart = cart;
    this.user = user;
    this.payment = paymentStrategy;
    this.notification = notificationStrategy;
    this.orderType = orderType;
    this.orderTime = orderTime;
  }

  public Integer getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public Cart getCart() {
    return cart;
  }

  public Instant getOrderTime() {
    return orderTime;
  }

  public String getOrderType() {
    return orderType;
  }

  public void placeOrder() {
    double payableAmount = cart.getTotalPrice();

    if (payment.pay(payableAmount)) {
      notification.notify("Order [" + id + "] is placed, Amount of [" + payableAmount + "] deducted");
    } else {
      notification.notify("Payment for Order [" + id + "] failed, please try again later");
    }
  }
}
