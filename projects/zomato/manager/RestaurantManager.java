package projects.zomato.manager;

import java.util.ArrayList;
import java.util.List;

import projects.zomato.modals.Restaurant;

public class RestaurantManager {
  private List<Restaurant> restaurants;
  private static volatile RestaurantManager instance;

  public static RestaurantManager getInstance() {
    if (instance == null) {
      synchronized (RestaurantManager.class) {
        if (instance == null) {
          instance = new RestaurantManager();
        }
      }
    }
    return instance;
  }

  private RestaurantManager() {
    this.restaurants = new ArrayList<>();
  }

  public List<Restaurant> getAllRestaurants() {
    return restaurants;
  }

  public Restaurant getRestaurantById(Integer id) {
    return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().get();
  }

  public void addRestaurant(Restaurant restaurant) {
    restaurants.add(restaurant);
  }

  public void removeRestaurant(Restaurant restaurant) {
    restaurants.remove(restaurant);
  }

  public List<Restaurant> getRestaurantsByLocation(String location) {
    return restaurants.stream().filter(r -> r.getLocation().equals(location)).toList();
  }
}
