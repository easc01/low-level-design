package projects.zomato.modals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
  private static Integer nextId = 0;
  private Integer id;
  private String name;
  private String location;
  private String address;
  private List<Order> orders;
  private Map<Integer, Cart> carts;

  private String mobileNumber;
  private String email;

  public User(
      String name,
      String location,
      String address,
      String mobile,
      String email) {
    id = ++nextId;
    this.name = name;
    this.location = location;
    this.address = address;
    this.mobileNumber = mobile;
    this.email = email;
    orders = new ArrayList<>();
    carts = new HashMap<>();
  }

  public Integer getId() {
    return id;
  }

  public String getLocation() {
    return location;
  }

  public String getAddress() {
    return address;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getMobile() {
    return mobileNumber;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public Cart getCart(Integer restaurantId) {
    return carts.get(restaurantId);
  }
}
