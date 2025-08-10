package projects.zomato.modals;

public class MenuItem {
  private String code;
  private String name;
  private Double price;

  public MenuItem(String code, String name, Double price) {
    this.code = code;
    this.name = name;
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }
}
