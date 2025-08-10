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

class PremiumWheatBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing premium wheat burger");
  }
}

class BasicWheatBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing basic wheat burger");
  }
}

class CheeseWheatBurger implements Burger {
  @Override
  public void prepare() {
    System.out.println("Preparing cheese wheat burger");
  }
}

interface BurgerFactory {
  Burger createBurger(String type);
}

class MCDFactory implements BurgerFactory {
  @Override
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

class BKingFactory implements BurgerFactory {
  @Override
  public Burger createBurger(String type) {
    if (type == "basic") {
      return new BasicWheatBurger();
    } else if (type == "cheese") {
      return new CheeseWheatBurger();
    } else if (type == "premium") {
      return new PremiumWheatBurger();
    } else {
      return null;
    }
  }
}


public class FactoryMethod {
  public static void main(String[] args) {
    BurgerFactory factory = new BKingFactory();
    Burger burger = factory.createBurger("cheese");
    burger.prepare();
  }
}
