package projects.zomato.strategy.payment;

public class UPIPayment implements PaymentGateway {
  private String mobile;

  public UPIPayment(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public boolean pay(Double amount) {
    System.out.println("[" + amount + "] deducted via UPI payment [" + mobile + "]");
    return true;
  }

}
