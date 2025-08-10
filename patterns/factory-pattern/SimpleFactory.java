interface Burger {
  void prepare();
}

class BasicBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing basic burger");
  }
}

class CheeseBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing cheese burger");
  }
}

class PremiumBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing premium burger");
  }
}

class BurgerFactory {
  public Burger createBurger(String type) {
    if (type == "basic") {
      return new BasicBurger();
    } else if (type == "cheese") {
      return new CheeseBurger();
    } else if (type == "premium") {
      return new PremiumBurger();
    } else {
      return null;
    }
  }
}

public class SimpleFactory {
  public static void main(String[] args) {
    BurgerFactory factory = new BurgerFactory();
    Burger burger = factory.createBurger("cheese");
    burger.prepare();
  }
}
