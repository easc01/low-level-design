package projects.zomato.modals;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private static Integer nextId = 0;
  private Integer id;
  private Restaurant restaurant;
  private List<MenuItem> items;

  public Cart(Restaurant restaurant) {
    id = ++nextId;
    this.restaurant = restaurant;
    this.items = new ArrayList<>();
  }

  public Cart(Restaurant restaurant, List<MenuItem> items) {
    id = ++nextId;
    this.restaurant = restaurant;
    this.items = items;
  }

  public Integer getId() {
    return id;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void addItem(MenuItem item) {
    items.add(item);
  }

  public void removeItem(MenuItem item) {
    items.remove(item);
  }

  public Double getTotalPrice() {
    double totalPrice = 0;

    for (MenuItem item : items) {
      totalPrice += item.getPrice();
    }

    return totalPrice;
  }

  public Boolean isEmpty() {
    return items.size() == 0;
  }

  public void clear() {
    items = new ArrayList<>();
  }

  public List<MenuItem> getItems() {
    return items;
  }
}
