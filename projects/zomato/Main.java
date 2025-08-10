package projects.zomato;

import java.util.List;

import projects.zomato.modals.Cart;
import projects.zomato.modals.MenuItem;
import projects.zomato.modals.Order;
import projects.zomato.modals.Restaurant;
import projects.zomato.modals.User;
import projects.zomato.strategy.payment.UPIPayment;

public class Main {
  public static void main(String[] args) {
    ZomatoApp app = new ZomatoApp();

    User user = app.createAccount("Ishant", "bikaner", "324, Residency", "122345789", null);
    List<Restaurant> restaurants = app.searchByLocation(user.getLocation());

    restaurants.forEach(r -> {
      System.out.println(r.getName());
    });
    System.out.println();

    Restaurant selectedRestaurant = restaurants.get(0);
    Cart cart = app.openRestaurantCart(selectedRestaurant);

    app.showRestaurantCart(cart);

    List<MenuItem> items = selectedRestaurant.getMenuItems();
    app.addItemToCart(cart, items.get(0));
    app.addItemToCart(cart, items.get(1));

    app.showRestaurantCart(cart);

    Order order = app.checkoutNow(user, cart, "DeliveryOrder", new UPIPayment(user.getMobile()));
    app.payForOrder(order, cart);

    app.showRestaurantCart(cart);
  }
}
