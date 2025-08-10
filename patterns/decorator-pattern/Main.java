interface Mario {
  String getAbilities();
}

class NormalMario implements Mario {
  public String getAbilities() {
    return "Normal Mario";
  }
}

// Base decorator
abstract class MarioDecorator implements Mario {
  protected Mario mario;

  public MarioDecorator(Mario mario) {
    this.mario = mario;
  }
}

class HeightUpMario extends MarioDecorator {
  public HeightUpMario(Mario mario) {
    super(mario);
  }

  @Override
  public String getAbilities() {
    return mario.getAbilities() + " with height up";
  }
}

class StrongMario extends MarioDecorator {
  public StrongMario(Mario mario) {
    super(mario);
  }

  @Override
  public String getAbilities() {
    return mario.getAbilities() + " with power up";
  }
}

class FlyableMario extends MarioDecorator {
  public FlyableMario(Mario mario) {
    super(mario);
  }

  @Override
  public String getAbilities() {
    return mario.getAbilities() + " with fly power";
  }
}

public class Main {
  public static void main(String[] args) {
    Mario mario = new NormalMario();
    System.out.println(mario.getAbilities());

    mario = new StrongMario(mario);
    System.out.println(mario.getAbilities());

    mario = new FlyableMario(mario);
    System.out.println(mario.getAbilities());

    mario = new HeightUpMario(mario);
    System.out.println(mario.getAbilities());
  }
}
