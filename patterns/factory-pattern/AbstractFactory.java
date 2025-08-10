interface Burger {
  void prepare();
}

interface Pizza {
  void prepare();
}


class VeggiePizza implements Pizza {
  @Override
  public void prepare() {
    System.out.println("Preparing Veggie Pizza");
  }
}

class PepperoniPizza implements Pizza {
  @Override
  public void prepare() {
    System.out.println("Preparing Pepperoni Pizza");
  }
}

class BBQChickenPizza implements Pizza {
  @Override
  public void prepare() {
    System.out.println("Preparing BBQ Chicken Pizza");
  }
}

class MexicanPizza implements Pizza {
  @Override
  public void prepare() {
    System.out.println("Preparing Mexican Pizza");
  }
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

  Pizza createPizza(String type);
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

  @Override
  public Pizza createPizza(String type) {
    if (type == "veg") {
      return new VeggiePizza();
    } else {
      return new BBQChickenPizza();
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

  @Override
  public Pizza createPizza(String type) {
    if (type == "veg") {
      return new MexicanPizza();
    } else {
      return new PepperoniPizza();
    }
  }
}

public class AbstractFactory {
  public static void main(String[] args) {
    BurgerFactory factory = new BKingFactory();
    Burger burger = factory.createBurger("cheese");
    Pizza pizza = factory.createPizza("nonveg");
    burger.prepare();
    pizza.prepare();
  }
}
