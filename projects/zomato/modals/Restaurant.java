package projects.zomato.modals;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
  private static Integer nextId = 0;
  private Integer id;
  private String location;
  private String address;
  private List<MenuItem> menuItems;
  private String name;

  public Restaurant(
      String name,
      String location,
      String address) {
    id = ++nextId;
    this.name = name;
    this.location = location;
    this.address = address;
    this.menuItems = new ArrayList<>();
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public String getAddress() {
    return address;
  }

  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

  public void addMenuItem(MenuItem item) {
    menuItems.add(item);
  }
}
