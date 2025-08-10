package projects.zomato.strategy.payment;

public class CardPayment implements PaymentGateway {
    private String cardNumber;

  public CardPayment(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  @Override
  public boolean pay(Double amount) {
    System.out.println("[" + amount + "] deducted via UPI payment [" + cardNumber + "]");
    return true;
  }

}
