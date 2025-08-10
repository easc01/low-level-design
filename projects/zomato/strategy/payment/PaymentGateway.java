package projects.zomato.strategy.payment;

public interface PaymentGateway {
  boolean pay(Double amount);
}
