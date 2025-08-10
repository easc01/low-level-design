package projects.zomato.strategy.payment;

public class NetBanking implements PaymentGateway {
  private String accountNumber;

  public NetBanking(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  @Override
  public boolean pay(Double amount) {
    System.out.println("[" + amount + "] deducted via UPI payment [" + accountNumber + "]");
    return true;
  }

}
